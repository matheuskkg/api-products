package com.api.entities;

import com.api.dtos.request.ProductRequest;
import com.api.dtos.response.ProductResponse;
import jakarta.persistence.*;

@Entity
@Table(
        name = "products",
        uniqueConstraints =
                @UniqueConstraint(columnNames = {"name"})
)
public class Product implements IAPIEntity<ProductResponse> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Product() {}

    public Product(ProductRequest request) {
        this.name = request.name().trim();
    }

    @Override
    public ProductResponse buildResponse() {
        return new ProductResponse(id, name);
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
}
