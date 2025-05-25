package org.example.projetjeespringangularjwtdigitalbanking.test;

import org.example.projetjeespringangularjwtdigitalbanking.JPA.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class OperationRepositoryTest {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndFindOperation() {
        Customer customer = new Customer("CUST03", "bob@example.com", "Bob", null);
        customerRepository.save(customer);

        BankAccount account = new CurrentAccount();
        account.setId("ACC02");
        account.setBalance(2000.0);
        account.setCurrency("EUR");
        account.setStatus(AccountStatus.ACTIVATED);
        account.setCustomer(customer);
        account.setCreatedAt(new Date());
        bankAccountRepository.save(account);

        Operation operation = new Operation();
        operation.setType(OperationType.CREDIT);
        operation.setAmount(150.0);
        operation.setDate(new Date());
        operation.setBankAccount(account);

        operationRepository.save(operation);

        List<Operation> ops = operationRepository.findAll();
        assertEquals(1, ops.size());
        assertEquals(OperationType.CREDIT, ops.get(0).getType());
    }
}
