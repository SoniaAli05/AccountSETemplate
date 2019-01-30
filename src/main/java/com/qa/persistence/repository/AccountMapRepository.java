package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.qa.persistence.domain.Account;
import com.qa.persistence.util.JSONUtil;

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

}