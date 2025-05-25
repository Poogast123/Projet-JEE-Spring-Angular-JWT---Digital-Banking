package org.example.projetjeespringangularjwtdigitalbanking.test;

import org.example.projetjeespringangularjwtdigitalbanking.JPA.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class BankAccountRepositoryTest {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndFindBankAccount() {
        Customer customer = new Customer("CUST02", "jane@example.com", "Jane", null);
        customerRepository.save(customer);

        BankAccount account = new SavingAccount();
        account.setId("ACC01");
        account.setBalance(1000.0);
        account.setCurrency("USD");
        account.setStatus(AccountStatus.CREATED);
        account.setCustomer(customer);
        account.setCreatedAt(new Date());

        bankAccountRepository.save(account);

        Optional<BankAccount> result = bankAccountRepository.findById("ACC01");
        assertTrue(result.isPresent());
        assertEquals(1000.0, result.get().getBalance());
    }
}

