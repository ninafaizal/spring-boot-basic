package com.bank.repo;

// TODO: SpringBoot: Practical Bonus 1 - Unit Test for AccountRepo
// create unit test for create, delete and get account 
// use CustomerRepoTest as an example

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.bank.entity.AccountEntity;
import com.bank.entity.CustomerEntity;
import com.bank.entity.ProductEntity;

@SpringBootTest
@ActiveProfiles("test") // Uses application-test.properties for H2 setup

class AccountRepoTest {
	
	@Autowired
	private IAccountRepo accountRepo;
	
	@Autowired
    private ICustomerRepo customerRepo;

    @Autowired
    private IProductRepo productRepo;
	
	// Reusable helper method - foreign key
    private CustomerEntity createCustomer() {
        CustomerEntity customer = new CustomerEntity();
        customer.setIcNumber("IC" + System.nanoTime());
        customer.setLastname("Lee");
        customer.setSurname("Min");
        customer.setDescription("Test customer");
        customer.setCreationDate(LocalDateTime.now());
        return customerRepo.save(customer);
    }

    private ProductEntity createProduct() {
        ProductEntity product = new ProductEntity();
        product.setProductName("Savings-" + System.nanoTime());
        product.setDescription("Standard savings account");
        return productRepo.save(product);
    }
	 
	 @Test
	 @Order(1)
	 void testCreateAccount() {
	     AccountEntity account = new AccountEntity();
	     account.setAccountNumber("162109990879");
	     account.setBalance(2989.65);
	     account.setCreationDate(LocalDateTime.now());
	     
	     account.setCustomerEntity(createCustomer());
	     account.setProductEntity(createProduct()); 
	       
	     AccountEntity saved = accountRepo.save(account);

	     assertNotNull(saved.getAccountID());
	     assertEquals("162109990879", saved.getAccountNumber());
	    }
	 
	 @Test
	 @Order(2)
	 void testFindAccountById() {
	     AccountEntity account = new AccountEntity();
	     account.setAccountNumber("162109990879");
	     account.setBalance(2989.65);
	     account.setCreationDate(LocalDateTime.now());
	     
	     //import
	     account.setCustomerEntity(createCustomer());
	     account.setProductEntity(createProduct()); 
	       
	     AccountEntity saved = accountRepo.save(account);
	     
	     Optional<AccountEntity> found = accountRepo.findById(saved.getAccountID());

	     assertTrue(found.isPresent());
	     assertEquals("162109990879", found.get().getAccountNumber());
	    }
	 
	 @Test
	 @Order(3)
	 void testDeleteAccount() {
	     AccountEntity account = new AccountEntity();
	     account.setAccountNumber("162109990879");
	     account.setBalance(2989.65);
	     account.setCreationDate(LocalDateTime.now());
	     
	     account.setCustomerEntity(createCustomer());
	     account.setProductEntity(createProduct());
	       
	     AccountEntity saved = accountRepo.save(account);
	     Long id = saved.getAccountID();
	     
	     accountRepo.deleteById(id);
	     
	     Optional<AccountEntity> deleted = accountRepo.findById(id);
	     assertFalse(deleted.isPresent());
	    
	 }

}
