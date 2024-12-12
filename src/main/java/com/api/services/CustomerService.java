package com.api.services;

import com.api.dtos.response.CustomerResponse;
import com.api.entities.Customer;
import com.api.exceptions.UniqueConstraintViolation;
import com.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("customerService")
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void save(Customer request) {
        try {
            customerRepository.save(request);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueConstraintViolation("E-mail address already in use.", Customer.class);
        }
    }

    public List<CustomerResponse> findAll() {
        return customerRepository.findAllDTO();
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

}
