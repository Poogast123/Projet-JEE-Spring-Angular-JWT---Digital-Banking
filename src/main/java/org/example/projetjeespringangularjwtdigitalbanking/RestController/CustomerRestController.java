package org.example.projetjeespringangularjwtdigitalbanking.RestController;

import org.example.projetjeespringangularjwtdigitalbanking.DTO.CustomerDTO;
import org.example.projetjeespringangularjwtdigitalbanking.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    private final CustomerService customerService;

    public CustomerRestController(CustomerService service) {
        this.customerService = service;
    }

    @GetMapping
    public List<CustomerDTO> listCustomers() {
        return customerService.listCustomers();
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomer(customerDTO);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }
}

