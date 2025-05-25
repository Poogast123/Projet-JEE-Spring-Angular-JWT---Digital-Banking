package org.example.projetjeespringangularjwtdigitalbanking.service;

import org.example.projetjeespringangularjwtdigitalbanking.DTO.CustomerDTO;
import org.example.projetjeespringangularjwtdigitalbanking.JPA.Customer;
import org.example.projetjeespringangularjwtdigitalbanking.JPA.CustomerRepository;
import org.example.projetjeespringangularjwtdigitalbanking.Mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.customerRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO dto) {
        Customer customer = mapper.fromDTO(dto);
        return mapper.toDTO(customerRepository.save(customer));
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return mapper.toDTO(customer);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(String id) {
        // Check if customer exists before deleting
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}