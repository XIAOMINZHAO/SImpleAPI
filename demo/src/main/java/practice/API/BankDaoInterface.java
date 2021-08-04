package practice.API;

import java.util.List;
import java.util.Set;

public interface BankDaoInterface {
	
	public void addCustomer(BankAccount a); //complete
	public void updateName(String username, String newName); //complete
	public void updateEmail(String username, String email); //complete
	public void updatePhoneNumber(String username, String phoneNumber); //complete
	public Set<String> getAccount(); //complete
	public BankAccount getAccount(String name);//complete
	public void deposit(String username, int amount);
	public void withdraw(String username, int amount);
	public float getBalance(String name);//complete
	public String deleteUser(Long accountnumber); //complete
	
	
	

}
