package com.api.services;

import com.api.dtos.response.ProductResponse;
import com.api.entities.Product;
import com.api.exceptions.UniqueConstraintViolation;
import com.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void save(Product request) {
        try {
            productRepository.save(request);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueConstraintViolation("There is already a product with this name.", Product.class);
        }
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAllDTO();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
