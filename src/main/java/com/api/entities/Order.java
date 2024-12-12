package com.api.entities;

import com.api.dtos.request.OrderRequest;
import com.api.dtos.response.OrderResponse;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(
        name = "orders"
)
public class Order implements IAPIEntity<OrderResponse> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Order() {}

    public Order(OrderRequest request) {
        this.customer = request.customer();
        this.products = request.products();
    }

    @Override
    public OrderResponse buildResponse() {
        return new OrderResponse(
                id,
                customer.buildResponse(),
                products.stream().map(Product::buildResponse).collect(Collectors.toList())
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
