package com.enigma.walletkurs.daoimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.enigma.walletkurs.additional.Autogenerateid;
import com.enigma.walletkurs.dao.WalletDao;
import com.enigma.walletkurs.exception.EntityNotFoundException;
import com.enigma.walletkurs.exception.ExistException;
import com.enigma.walletkurs.models.WalletAccountEntity;
import com.enigma.walletkurs.models.WalletEntity;
import com.enigma.walletkurs.models.dto.WalletDto;
import com.enigma.walletkurs.repository.WalletAccountRepository;
import com.enigma.walletkurs.repository.WalletRepository;

public class WalletDaoImplement implements WalletDao{

	@Autowired
	WalletRepository walletrepo;
	
	@Autowired
	WalletAccountRepository walletaccrepo;
	@PersistenceContext
	EntityManager em;
	
	String regex="[$-/:-?{-~!\"^_`\\[\\]]";
	
	@Override
	public List<WalletEntity> getAllWallet() {
		// TODO Auto-generated method stub
		List<WalletEntity>listwallet=walletrepo.findAll();
		return listwallet;
	}

	@Override
	public WalletEntity createwallet(WalletDto wallet) throws ExistException {
		if (walletrepo.existsByDescription(wallet.getDescription())){
			throw  new ExistException(46, "Error,Description is exist");
		}
		wallet.setCreatedDate(new Date());
		wallet.setStatus("active");
		WalletEntity tempwall=new WalletEntity();
		tempwall.setCreatedDate(wallet.getCreatedDate());
		tempwall.setCustomerNumber(wallet.getCustomerNumber());
		tempwall.setDescription(wallet.getDescription());
		tempwall.setStatus(wallet.getStatus());
		
		Query query=em.createQuery("from WalletEntity order by walletId desc");
		query.setMaxResults(1);
		if (query.getResultList().isEmpty()) {
			tempwall.setWalletId("W-001");
		}else {
			WalletEntity idwal= (WalletEntity) query.getSingleResult();
			Autogenerateid nid=new Autogenerateid("W-", idwal.getWalletId(), "0", 2);
			tempwall.setWalletId(nid.generatedid());
		}
		return walletrepo.save(tempwall);
	}

	@Override
	public WalletAccountEntity registeraccount(WalletAccountEntity walletacc) {
		walletacc.setStatus("active");
		return walletaccrepo.save(walletacc);
	}

	@Override
	public List<WalletEntity> getAllWalletByCustomer(String customerNumber) {
		List<WalletEntity>listwallet=walletrepo.findBycustomerNumberCustomerNumberAndStatus(customerNumber,"active");
		return listwallet;
	}

	@Override
	public List<WalletAccountEntity> getAllWalletAccountByWallet(String walletId) {
		List<WalletAccountEntity>listwalletacc=walletaccrepo.findByWalletIdWalletIdAndStatus(walletId, "active");
		return listwalletacc;
	}

	@Override
	public String deletewallet(String walletid) throws EntityNotFoundException {
		if (!walletrepo.existsById(walletid)) {
			throw new EntityNotFoundException(44,"Error,Data not found");
		}
		WalletEntity tempwal= walletrepo.findById(walletid).orElse(null);
		tempwal.setStatus("nonactive");
		walletrepo.save(tempwal);
		return "success";
	}

	@Override
	public WalletEntity getwalletById(String walletid) {
		WalletEntity tempwal=walletrepo.findByWalletIdAndStatus(walletid,"active");
		return tempwal;
	}

}
