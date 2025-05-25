package org.example.projetjeespringangularjwtdigitalbanking.Mapper;

import org.example.projetjeespringangularjwtdigitalbanking.DTO.CustomerDTO;
import org.example.projetjeespringangularjwtdigitalbanking.JPA.BankAccount;
import org.example.projetjeespringangularjwtdigitalbanking.JPA.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setBankAccountIds(
                customer.getBankAccounts().stream().map(BankAccount::getId).collect(Collectors.toList())
        );
        return dto;
    }

    public Customer fromDTO(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        // don't set bank accounts here unless mapped later
        return customer;
    }
}
