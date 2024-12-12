package com.api.entities;

import com.api.dtos.request.CustomerRequest;
import com.api.dtos.response.CustomerResponse;
import jakarta.persistence.*;

@Entity
@Table(
        name = "customers",
        uniqueConstraints =
                @UniqueConstraint(columnNames = {"email"})
)
public class Customer implements IAPIEntity<CustomerResponse> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    public Customer() {}

    public Customer(CustomerRequest request) {
        this.name = request.name().trim();
        this.email = request.email();
    }

    @Override
    public CustomerResponse buildResponse() {
        return new CustomerResponse(id, name, email);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
