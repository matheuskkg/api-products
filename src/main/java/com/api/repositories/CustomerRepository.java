package com.api.repositories;

import com.api.dtos.response.CustomerResponse;
import com.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select new com.api.dtos.response.CustomerResponse(c.id, c.name, c.email) from Customer c")
    List<CustomerResponse> findAllDTO();
}
