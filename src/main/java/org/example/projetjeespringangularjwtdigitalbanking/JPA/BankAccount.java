package org.example.projetjeespringangularjwtdigitalbanking.JPA;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String currency;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "bankAccount")
    private List<Operation> operations;

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public Long getId() {
        return Long.valueOf(id);
    }
}
