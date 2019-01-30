package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.util.JSONUtil;

public class AccountServiceTest {

	AccountMapRepository rep = new AccountMapRepository();
	
	@Before
	public void setup() {
	}
	
	@Test
	public void addAccountTest() {
	int mapSize = rep.accounts.size();
	Account newAccount = new Account("Sali", "Ali", 2222);
	rep.createAccount(JSONUtil.getJSONForObject(newAccount));
	assertEquals("Didnt increase", mapSize + 1, rep.accounts.size());
	}
	
	@Test
	public void add2AccountTest() {
	int mapSize = rep.accounts.size();
	Account newAccount = new Account("Sali", "Ali", 2222);
	Account newAccount1 = new Account("Jasper", "Smith", 2332);
	rep.createAccount(JSONUtil.getJSONForObject(newAccount));
	rep.createAccount(JSONUtil.getJSONForObject(newAccount1));
	assertEquals("Didnt increase", mapSize + 2, rep.accounts.size());	
	}

	@Test
	public void removeAccountTest() {
	Account newAccount = new Account("Sali", "Ali", 2222);
	rep.createAccount(JSONUtil.getJSONForObject(newAccount));
	int mapSize = rep.accounts.size();
	rep.deleteAccount((long) mapSize - 1);	
	assertEquals("Didnt decrease", mapSize - 1 , rep.accounts.size());	
		}
	 
	
	@Test
	public void remove2AccountTest() {
	Account newAccount = new Account("Sali", "Ali", 2222);
	Account newAccount1 = new Account("Jasper", "Smith", 2332);
	rep.createAccount(JSONUtil.getJSONForObject(newAccount));
	rep.createAccount(JSONUtil.getJSONForObject(newAccount1));
	int mapSize = rep.accounts.size();
	rep.deleteAccount((long) mapSize - 1);	
	rep.deleteAccount((long) mapSize - 2);	
	assertEquals("Didnt decrease", mapSize - 2 , rep.accounts.size());			
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
	Account newAccount = new Account("Sali", "Ali", 2222);
	Account newAccount1 = new Account("Jasper", "Smith", 2332);
	rep.createAccount(JSONUtil.getJSONForObject(newAccount));
	rep.createAccount(JSONUtil.getJSONForObject(newAccount1));
	int mapSize = rep.accounts.size();
	rep.deleteAccount((long) mapSize - 1);	
	rep.deleteAccount((long) mapSize - 2);	
	rep.deleteAccount((long) mapSize - 3);	
	assertEquals("Didnt decrease", mapSize - 2 , rep.accounts.size());		
	}
	
	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
	
	}
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
	
	}

	@Test
	public void accountConversionToJSONTest() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		
	}

}
