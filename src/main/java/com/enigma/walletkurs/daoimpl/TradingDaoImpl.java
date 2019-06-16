package com.enigma.walletkurs.daoimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.enigma.walletkurs.dao.AccountDao;
import com.enigma.walletkurs.dao.TradingDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.InsufficientAmountException;
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.ExchangeEntity;
import com.enigma.walletkurs.models.TradingEntity;
import com.enigma.walletkurs.models.dto.TradingDto;
import com.enigma.walletkurs.repository.ExchangeRepository;
import com.enigma.walletkurs.repository.TradingRepository;

public class TradingDaoImpl implements TradingDao {

	@Autowired
	TradingRepository traderepo;
	
	@Autowired
	ExchangeRepository exchangerepo;
	
	@Autowired
	AccountDao accdao;
	
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public TradingEntity buyAsset(TradingDto trade) throws InsufficientAmountException {
		// TODO Auto-generated method stub
		TradingEntity temptrade= new TradingEntity();
		List<AccountEntity> tempacc= accdao.getAccountsByCustomerNumber(trade.getTradingId());
		Query query = em.createQuery("from ExchangeEntity order by rateId desc");
		query.setMaxResults(1);
		ExchangeEntity exchange= (ExchangeEntity) query.getSingleResult();
		Double balance=tempacc.get(0).getBalance();
		Double dollaramount=trade.getAmount()*exchange.getSell();
		if (balance < dollaramount) {
			throw new InsufficientAmountException(52, "Sorry your virtual account balance not enaough");
		}else {
		tempacc.get(0).setBalance(balance-dollaramount);
		temptrade.setAmount(trade.getAmount());
		temptrade.setCcy(trade.getCcy());
		temptrade.setDate(new Date());
		temptrade.setSisa(trade.getAmount());
		temptrade.setType("b");
		temptrade.setRateId(exchange);
		temptrade.setTradingId(trade.getTradingId());
		traderepo.save(temptrade);
		}
		return temptrade;
	}

	@Override
	public TradingEntity sellAsset(TradingDto trade) throws EntityNotFoundException, InsufficientAmountException {
		TradingEntity temptrd=new TradingEntity();
	Query sumtrading = em.createQuery("select sum(TradingEntity.sisa) from TradingEntity where tradingId=?1");
	sumtrading.setParameter(1, trade.getTradingId());
	if (sumtrading.getResultList()==null) {
		throw new EntityNotFoundException(44, "Error,You dont have trade balance");
	}else {
		Double tradeamount=(Double) sumtrading.getSingleResult();
		if (tradeamount<trade.getAmount()) {
			throw new InsufficientAmountException(52, "Error, Trade balance is not enough");
		}
		int i=0;
		Query greater=em.createQuery("from TradingEntity where sisa>0 and tradingid=?1");
		greater.setParameter(1, trade.getTradingId());
		List<TradingEntity>temptrades= greater.getResultList();
		while(trade.getAmount()>0) {
			if (trade.getAmount()-temptrades.get(i).getAmount()>0) {
				Double tempbalance=trade.getAmount()-temptrades.get(i).getAmount();
				temptrades.get(i).setIncome(temptrades.get(i).getRateId().getBuy()*temptrades.get(i).getAmount());
				trade.setAmount(tempbalance);
				temptrades.get(i).setSisa(0.0);
			}else if(trade.getAmount()-temptrades.get(i).getAmount()<0) {
				Double tempbalance=temptrades.get(i).getAmount()-trade.getAmount();
				temptrades.get(i).setIncome(temptrades.get(i).getRateId().getBuy()*temptrades.get(i).getAmount());
				trade.setAmount(0.0);
				temptrades.get(i).setSisa(tempbalance);
			}else{
				trade.setAmount(0.0);
				temptrades.get(i).setSisa(0.0);				
			};
			traderepo.save(temptrades.get(i));
			i++;
		}
	}
		return temptrd;
	}

	@Override
	public List<ExchangeEntity> listRate() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
