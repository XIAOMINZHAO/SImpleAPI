package practice.API;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface JPABankRepository extends JpaRepository<BankAccount, Long>{

	@Transactional
	@Query(value = "SELECT balance FROM bank_account WHERE CUSTOMER_NAME  = :username", nativeQuery = true)
	float findBalanceByUsername(@Param("username") String username);

	@Transactional
	@Query(value = "SELECT * FROM bank_account WHERE CUSTOMER_NAME  = :username", nativeQuery = true)
	BankAccount findByUser(@Param("username") String username);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM bank_account WHERE ACCOUNT_NUMBER  = :accountNumber", nativeQuery = true)
	Integer deleteUserByaccountNumber(@Param("accountNumber") Long accountNumber);

	@Transactional
	@Modifying
	@Query(value = "UPDATE bank_account SET CUSTOMER_NAME = :newName WHERE ACCOUNT_NUMBER  = :accountNumber", nativeQuery = true)
	void updateName(@Param("accountNumber") Long accountNumber, @Param("newName") String newName);

	@Transactional
	@Modifying
	@Query(value = "UPDATE bank_account SET EMAIL = :email WHERE ACCOUNT_NUMBER  = :accountNumber", nativeQuery = true)
	void updateEmail(@Param("accountNumber") Long accountNumber, @Param("email") String email);

	@Transactional
	@Modifying
	@Query(value = "UPDATE bank_account SET PHONE_NUMBER = :phone WHERE ACCOUNT_NUMBER  = :accountNumber", nativeQuery = true)
	void updatePhoneNumber(@Param("accountNumber") Long accountNumber, @Param("phone") String phone);

	@Transactional
	@Modifying
	@Query(value = "UPDATE bank_account SET BALANCE = BALANCE + :amount WHERE ACCOUNT_NUMBER  = :accountNumber", nativeQuery = true)
	void deposit(@Param("accountNumber") Long accountNumber, @Param("amount") int amount);

	@Transactional
	@Modifying
	@Query(value = "UPDATE bank_account SET BALANCE = IF(BALANCE >= :amount, Balance - :amount , Balance) WHERE ACCOUNT_NUMBER  = :accountNumber", nativeQuery = true)
	void withdraw(@Param("accountNumber") Long accountNumber, @Param("amount") int amount);
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
