
package com.enigma.walletkurs.daoimpl;

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
import com.enigma.walletkurs.models.AccountEntity;
import com.enigma.walletkurs.models.CustomerEntity;
import com.enigma.walletkurs.models.WalletAccountEntity;
import com.enigma.walletkurs.models.WalletEntity;
import com.enigma.walletkurs.models.dto.AccountDto;
import com.enigma.walletkurs.models.dto.WalletAccountDto;
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
	
	String statactive="active";
	
	String regex="[$-/:-?{-~!\"^_`\\[\\]]";
	
	@Override
	public List<WalletEntity> getAllWallet() {
		return walletrepo.findAll();
	}

	@Override
	public WalletEntity createwallet(WalletDto wallet) throws ExistException {
		wallet.setCreatedDate(new Date());
		wallet.setStatus(statactive);
		WalletEntity tempwall=new WalletEntity();
		tempwall.setCreatedDate(wallet.getCreatedDate());
		tempwall.setCustomerNumber(new CustomerEntity(wallet.getCustomerNumber().getCustomerNumber()));
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
	public WalletAccountEntity registeraccount(WalletAccountDto walletacc) {
		WalletAccountEntity tempwalac= new WalletAccountEntity();
		AccountEntity tempacc = new AccountEntity();
		AccountDto tempaccdto= walletacc.getAccountNumber();
		tempacc.setAccountNumber(tempaccdto.getAccountNumber());
		WalletEntity tempwallet= new WalletEntity();
		tempwallet.setWalletId(walletacc.getWalletId().getWalletId());
		tempwalac.setAccountNumber(tempacc);
		tempwalac.setWalletId(tempwallet);
		tempwalac.setStatus(statactive);
		return walletaccrepo.save(tempwalac);
	}

	@Override
	public List<WalletEntity> getAllWalletByCustomer(String customerNumber) {
		return walletrepo.findBycustomerNumberCustomerNumberAndStatus(customerNumber,statactive);
		
	}

	@Override
	public List<WalletAccountEntity> getAllWalletAccountByWallet(String walletId) {
		return walletaccrepo.findByWalletIdWalletIdAndStatus(walletId, statactive);
	}

	@Override
	public String deletewallet(String walletid) throws EntityNotFoundException {
		WalletEntity tempwal= walletrepo.findById(walletid).orElse(null);
		if (tempwal!=null) {
		tempwal.setStatus("nonactive");
		walletrepo.save(tempwal);
		}else {
			throw new EntityNotFoundException(44, "Error,Wallet not found");
		}
		return "success";
	}

	@Override
	public WalletEntity getwalletById(String walletid) {
		return walletrepo.findByWalletIdAndStatus(walletid,statactive);
	}

}
