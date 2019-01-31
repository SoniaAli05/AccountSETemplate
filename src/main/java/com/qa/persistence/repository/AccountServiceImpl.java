package com.qa.persistence.repository;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountServiceImpl implements AccountRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	JSONUtil util = new JSONUtil();

	@Override
	public String getAllAccounts() {
		Query query = em.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		em.persist(anAccount);
		return null;
	}
	
	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		
		Account accountInDB = em.find(Account.class, id);
		if(accountInDB != null) {
			em.remove(accountInDB);
		}		
		return null;
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		Account accountInDB = em.find(Account.class, id);
		if(accountInDB != null) {
			em.remove(accountInDB);	
			Account anAccount = util.getObjectForJSON(account, Account.class);
			em.persist(anAccount);
	}
	return null;
	}

}
