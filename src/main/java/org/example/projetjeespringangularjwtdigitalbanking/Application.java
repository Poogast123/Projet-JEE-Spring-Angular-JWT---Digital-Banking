package org.example.projetjeespringangularjwtdigitalbanking;

import org.example.projetjeespringangularjwtdigitalbanking.JPA.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            BankAccountRepository bankAccountRepository) {
        return args -> {
            Customer customer = new Customer();
            customer.setId(UUID.randomUUID().toString()); // id en String
            customer.setName("Jean Dupont");
            customer.setEmail("jean@gmail.com");
            customerRepository.save(customer);

            CurrentAccount currentAccount = new CurrentAccount();
            currentAccount.setId(UUID.randomUUID().toString()); // id en String
            currentAccount.setBalance(5000);
            currentAccount.setCreatedAt(new Date());
            currentAccount.setStatus(AccountStatus.CREATED);
            currentAccount.setCustomer(customer);
            currentAccount.setCurrency("EUR");
            currentAccount.setOverDraft(1000);
            bankAccountRepository.save(currentAccount);

            SavingAccount savingAccount = new SavingAccount();
            savingAccount.setId(UUID.randomUUID().toString()); // id en String
            savingAccount.setBalance(10000);
            savingAccount.setCreatedAt(new Date());
            savingAccount.setStatus(AccountStatus.CREATED);
            savingAccount.setCustomer(customer);
            savingAccount.setCurrency("EUR");
            savingAccount.setInterestRate(3.5);
            bankAccountRepository.save(savingAccount);
        };
    }

}
