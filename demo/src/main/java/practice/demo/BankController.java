package practice.demo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class BankController {
	
	@Autowired
	private BankDao bankdao = new BankDao();
	
	@GetMapping("/hello")
	public String hello(){
		return "hello there";
	}
	
	@GetMapping("/getAccounts")
	public Set<String> getAccounts(){
		return bankdao.getAccount();
	}
	
	@GetMapping("/getBalance/{name}")
	public float getBalance(@PathVariable("name") String username) {
		return bankdao.getBalance(username);
//		return 0;
		
	}
	@GetMapping("/getAccounts/{name}")
	public BankAccount getAccount(@PathVariable("name") String name) {
		return bankdao.getAccount(name);
	}
	
	@PostMapping("/addUser/{name}/{phoneNumber}")
	public String addAccount(@PathVariable("name") String name, @PathVariable("phoneNumber") String phone) {
		BankAccount a = new BankAccount(name, phone, "email not entered.", 100.0f);
		bankdao.addCustomer(a);
		return a.getCustomerName() + " added to user-lists";
		
				
	}
	
	@DeleteMapping("/deleteUser/{accountNumber}")
	public String deleteUser(@PathVariable("accountNumber") Long accountNumber) {
		return bankdao.deleteUser(accountNumber);
	}
	
	@PutMapping("/updateName/{oldName}/{newName}")
	public String updateName(@PathVariable("oldName") String username, @PathVariable("newName") String newName) {
		bankdao.updateName(username, newName);
		return "New name updated to " + newName;
	}
	
	@PutMapping("/updateEmail/{name}/{email}")
	public String updateEmail(@PathVariable("name") String username, @PathVariable("email") String email) {
		bankdao.updateEmail(username, email);
		return "New email updated to " + email;
	}
	
	@PutMapping("/updatePhone/{name}/{phone}")
	public String updatePhone(@PathVariable("name") String username, @PathVariable("phone") String phone) {
		bankdao.updatePhoneNumber(username, phone);
		return "New phone updated to " + phone;
	}
	

	
	@PutMapping("/deposit/{name}/{amount}")
	public String deposite(@PathVariable("name") String username, @PathVariable("amount") int amount) {
		
		bankdao.deposit(username, amount);
		
		float s = bankdao.getAccount(username).getBalance();
		return "The amount of " + amount + "deposit. New balance is " + s;
	}
	
	@PutMapping("/withdraw/{name}/{amount}")
	public String withdraw(@PathVariable("name") String username, @PathVariable("amount") int amount) {
		
		bankdao.withdraw(username, amount);
		
		float s = bankdao.getAccount(username).getBalance();
		return "The amount of " + amount + "withdrawed. New balance is " + s;
	}
	
	

}
