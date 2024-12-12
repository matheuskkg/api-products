package com.api.controllers;

import com.api.dtos.request.OrderRequest;
import com.api.entities.Order;
import com.api.services.OrderService;
import com.api.dtos.response.ErrorResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid OrderRequest request, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse.buildErrors(errors));
        }

        orderService.save(new Order(request));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getAll(@PathVariable(required = false) Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findAllByCustomerId(id));
    }
}
