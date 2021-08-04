package practice.API;

import java.util.List;
import java.util.Optional;
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
	private JPABankRepository JPAService;
//	private BankDao bankdao = new BankDao();
	
	@GetMapping("/hello")
	public String hello(){
		return "hello there";
	}
	
	@GetMapping("/getAccounts")
	public List<BankAccount> getAccounts(){
		return JPAService.findAll();
	}
	
	@GetMapping("/getBalance/{accountNumber}")
	public float getBalance(@PathVariable("accountNumber") Long accountNumber) {
		return JPAService.findBalanceById(accountNumber);
		
	}
	@GetMapping("/getAccounts/{accountNumber}")
	public Optional<BankAccount> getAccount(@PathVariable("accountNumber") Long accountNumber) {
		return JPAService.findById(accountNumber);
	}
	
	@PostMapping("/addUser/{name}/{phoneNumber}")
	public String addAccount(@PathVariable("name") String name, @PathVariable("phoneNumber") String phone) {
		BankAccount a = new BankAccount(name, phone, "email not entered.", 100.0f);
		JPAService.save(a);
		return a.getCustomerName() + " added to user-lists";
		
				
	}
	
	@DeleteMapping("/deleteUser/{accountNumber}")
	public void deleteUser(@PathVariable("accountNumber") Long accountNumber) {
		JPAService.deleteById(accountNumber);
	}
	
	@PutMapping("/updateName/{accountNumber}/{newName}")
	public String updateName(@PathVariable("accountNumber") Long accountNumber, @PathVariable("newName") String newName) {
		JPAService.updateName(accountNumber, newName);
		return "New name updated to " + newName;
	}
	
	@PutMapping("/updateEmail/{accountNumber}/{email}")
	public String updateEmail(@PathVariable("accountNumber") Long accountNumber, @PathVariable("email") String email) {
		JPAService.updateEmail(accountNumber, email);
		return "New email updated to " + email;
	}
	
	@PutMapping("/updatePhone/{accountNumber}/{phone}")
	public String updatePhone(@PathVariable("accountNumber") Long accountNumber, @PathVariable("phone") String phone) {
		JPAService.updatePhoneNumber(accountNumber, phone);
		return "New phone updated to " + phone;
	}
	

	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public String deposite(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") int amount) {
		if(amount > 5 && amount < 1000) {
			JPAService.deposit(accountNumber, amount);
		}
		else {
			return "Can not process with this deposite amount.";
		}
		
		return "The amount of " + amount + " deposit.";
		
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public String withdraw(@PathVariable("accountNumber") Long accountNumber, @PathVariable("amount") int amount) {
		
		JPAService.withdraw(accountNumber, amount);
		return "Processed. Please check balance.";

	}
	
	

}
