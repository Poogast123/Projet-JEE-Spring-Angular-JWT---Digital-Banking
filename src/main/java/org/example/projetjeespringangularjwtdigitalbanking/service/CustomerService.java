package org.example.projetjeespringangularjwtdigitalbanking.service;

import org.example.projetjeespringangularjwtdigitalbanking.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomer(String id);
    List<CustomerDTO> listCustomers();
    void deleteCustomer(String id);
}
