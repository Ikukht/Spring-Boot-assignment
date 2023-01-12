package com.example.CapgeminiREST;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.CapgeminiREST.model.Account;
import com.example.CapgeminiREST.model.Customer;
import com.example.CapgeminiREST.model.Transaction;
import com.example.CapgeminiREST.repository.AccountRepository;
import com.example.CapgeminiREST.repository.CustomerRepository;
import com.example.CapgeminiREST.repository.TransactionRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  public CommandLineRunner initDatabase(TransactionRepository trasactionRep,
		  AccountRepository accountRep, CustomerRepository customerRep) {
    return args -> {
		Customer customer = new Customer("John", "Wick");
		customerRep.save(customer);
		log.info("Preloading " + customer);
		
		Account account = new Account();
		account.setCustomer(customer);
		accountRep.save(account);
		log.info("Preloading " + account);
		
		Transaction trasaction1 = new Transaction(new BigDecimal(12.11));
		trasaction1.setAccount(account);
		trasactionRep.save(trasaction1);
		log.info("Preloading " + trasaction1);
    };
  }
}
