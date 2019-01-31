package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.persistence.util.JSONUtil;

public class AccountServiceImpl implements AccountService{
	JSONUtil util = new JSONUtil();

	@Inject
	private AccountRepository repo;
	
	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		if(anAccount.getAccountNumber() == 9) {
			return "{\"message\": \"Account Number: '" + anAccount.getAccountNumber() + "' is Blocked!\"}";
		}
		return repo.createAccount(account);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);

	}

}
