package org.example.projetjeespringangularjwtdigitalbanking.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BankAccountDTO {
    private String id;
    private double balance;
    private String currency;
    private String status;
    private Date createdAt;
    private String customerId;
    private List<Long> operationIds;
}
