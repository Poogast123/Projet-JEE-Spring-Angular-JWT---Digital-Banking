package org.example.projetjeespringangularjwtdigitalbanking.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private String id;
    private String name;
    private String email;
    private List<String> bankAccountIds;
}
