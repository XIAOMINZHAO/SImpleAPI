package practice.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import practice.demo.BankAccount;

@Component
public class BankDao implements BankDaoInterface{
//	List <BankAccount> customers;
	
	
	HashMap<String, BankAccount> customerMap
    = new HashMap<String, BankAccount>();
	
	public BankDao() {
//
		this.customerMap = new HashMap<String, BankAccount>();
		
		BankAccount a = new BankAccount("mina", "5201197770", "xiaomingmail", 100.0f);
		this.customerMap.put("Mina", a);
		
		BankAccount a1 = new BankAccount("jason", "5201197770", "xiaomingmail", 100.0f);
		this.customerMap.put("jason", a1);
		
			
	}
	
	public void addCustomer(BankAccount a) {
		customerMap.put(a.getCustomerName(), a);
		
	}
	
	public void updateName(String username, String newName) {
		
		
		BankAccount a = customerMap.get(username);
		
		a.setCustomerName(newName);
		customerMap.remove(username);
		customerMap.put(newName,a);
		
		
	}
	
	public void updateEmail(String username, String newEmail) {
		BankAccount a = customerMap.get(username);
		
		a.setEmail(newEmail);
		
	}
	
	public void updatePhoneNumber(String username, String newPhoneNumber) {
		BankAccount a = customerMap.get(username);
		
		a.setPhoneNumber(newPhoneNumber);
		
	}
	
	public void updateAccountNumber(String username) {
		BankAccount a = customerMap.get(username);
		a.setAccountNumber();
		
	}
	
	public Set<String> getAccount() {
		System.out.println(customerMap.keySet());
		return customerMap.keySet();
	
	}
	
	public BankAccount getAccount(String name) {
		BankAccount a = customerMap.get(name);
		a.getAccountNumber();
		a.getBalance();
		a.getCustomerName();
		a.getEmail();
		a.getPhoneNumber();
		return a;
		
		
		
	}
	
	public void deposit(String username, int amount) {
		
		BankAccount a = customerMap.get(username);
		if(amount < 5 || amount > 10000) {
			System.out.println("insufficient deposit amount");
		}
		else {
			
			a.deposite(amount);
		}
	
		
	}
	
	public float getBalance(String username) {
		BankAccount a = customerMap.get(username);
		return a.getBalance();
		
	}

	@Override
	public void withdraw(String username, int amount) {
		BankAccount a = customerMap.get(username);
		a.withdraw(amount);
		
	}

	@Override
	public String deleteUser(Long accountnumber) {
		
		// TODO Auto-generated method stub
		
		for(BankAccount b : customerMap.values()) {
			if(b.getAccountNumber() == accountnumber ) {
				customerMap.remove(b.getCustomerName());
				return "user deleted.";
				
			}
		}
		return "Non user deleted.";
		
//		System.out.println("The account of " + accountnumber + " has been deleted.");
		 
	}
 
	


}
