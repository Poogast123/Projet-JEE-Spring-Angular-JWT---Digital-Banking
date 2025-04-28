package org.example.projetjeespringangularjwtdigitalbanking.JPA;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;

    public void setId(Long id) {
        this.id = String.valueOf(id);
    }

    public Long getId() {
        return Long.valueOf(id);
    }
}
