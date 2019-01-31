package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtil;

@Alternative

public class AccountMapRepository implements AccountRepository {

	public Map<Long, Account> accounts = new HashMap<>();
	JSONUtil util = new JSONUtil();

	public String getAllAccounts() {
		String result = " ";
		for (int i = 0; i < accounts.size(); i++) {

			result += util.getJSONForObject(accounts.get(i));
		}
		return result;

	}


	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		accounts.put((long) accounts.size(), anAccount);
		return "account created";
	}

	public String deleteAccount(Long id) {
		accounts.remove(id);
		return "account deleted";
	}

	public String updateAccount(Long id, String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		accounts.replace(id, anAccount);
		return "account updated";
	}

	public int getCountForFirstName(String firstName) {
		int countName = 0;
		for (Account anAccount : accounts.values())
		{
			if(anAccount.getFirstName().contains(firstName))
			{countName++;
			}
			}
			return countName;
	}

	
}

