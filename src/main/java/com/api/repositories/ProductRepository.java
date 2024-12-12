package com.api.repositories;

import com.api.dtos.response.ProductResponse;
import com.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select new com.api.dtos.response.ProductResponse(p.id, p.name) from Product p")
    List<ProductResponse> findAllDTO();
}
