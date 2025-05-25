package org.example.projetjeespringangularjwtdigitalbanking.test;

import org.example.projetjeespringangularjwtdigitalbanking.JPA.Customer;
import org.example.projetjeespringangularjwtdigitalbanking.JPA.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveAndFindCustomerById() {
        Customer customer = new Customer();
        customer.setId("1L");
        customer.setName("John Doe");
        customerRepository.save(customer);

        Customer found = customerRepository.findById("1L").orElse(null);
        assertNotNull(found);
        assertEquals("John Doe", found.getName());
    }
}
