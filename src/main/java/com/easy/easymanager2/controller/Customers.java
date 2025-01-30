package com.easy.easymanager2.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"}) // Permite múltiplas origens
public class Customers { // OU "CustomerController" se o arquivo for CustomerController.java

    @GetMapping
    public List<String> getCustomers() {
        return Arrays.asList("Cliente 1", "Cliente 2", "Cliente 3");
    }
}
