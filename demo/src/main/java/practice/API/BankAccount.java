package practice.API;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class BankAccount {

	@Id
	long accountNumber;
	float balance ;
	String customerName ;
	String email ;
	String phoneNumber;
	
	BankAccount(){
		
	}
	BankAccount(String name, String phoneNumber, String email, float balance){
		
		this.balance = balance;
		this.customerName = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.accountNumber = setAccountNumber();
		
		
	}
	
	public void deposite(float n) {
		this.balance += n;
		setBalance(this.balance);
		System.out.println("The Amount of " + n + " has deposit into you account.");
		
	}
	
	public void withdraw(float n) {
		if(n > this.balance) {
			System.out.println("Balance insufficient");
		}
		else {
			this.balance -= n;
			setBalance(this.balance);
			System.out.println("The Amount of " + n + " has withdraw from you account.");
		}
		
		
	}

	public long getAccountNumber() {
//		System.out.println("Account number : " + this.accountNumber);
		return accountNumber;
	}

	public long setAccountNumber() {
		Random rand = new Random(); //instance of random class
	      int upperbound = 10000;
	        //generate random values from 0-24
	      int int_random = rand.nextInt(upperbound);
		long hash = ((this.phoneNumber.hashCode() & 0xffffffffL) << 14L) 
		          ^ (this.email.hashCode() & 0xffffffffL) + int_random;
		
		this.accountNumber = hash;
		System.out.println("Account number set to " + hash + " -- " + this.customerName);
		return hash;
	}

	public float getBalance() {
		System.out.println("Balance : " + this.balance);
		return this.balance;
	}

	public void setBalance(float balance) {
		
		this.balance = balance;
		System.out.println("Balance changed to " + this.balance);
	}

	public String getCustomerName() {
		System.out.println("Customer Name : " + this.customerName);
		return customerName;
	}

	public void setCustomerName(String customerName) {
		
		this.customerName = customerName;
		System.out.println("Customer name set to " + this.customerName);
	}

	public String getEmail() {
		System.out.println("Email : " + this.email);
		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
		System.out.println("Email set to " + this.email);
	}

	public String getPhoneNumber() {
		System.out.println("Phone number : " + this.phoneNumber);
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		System.out.println("Phone number set to " + this.phoneNumber);
	}
	

	
	
	
	

}
