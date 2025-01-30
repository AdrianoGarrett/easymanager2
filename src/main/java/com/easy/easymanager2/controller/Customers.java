package com.easy.easymanager2.controller;

import com.easy.easymanager2.model.Customer;
import com.easy.easymanager2.record.DadosCadastroCustomer;
import com.easy.easymanager2.record.DadosResumidosCustomer;
import com.easy.easymanager2.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/api/customers")
public class Customers { // OU "CustomerController" se o arquivo for CustomerController.java

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<DadosResumidosCustomer> getCustomers() {
        return customerRepository.findAll().stream().map(DadosResumidosCustomer::new).toList();
    }

    @PostMapping
    public void cadastraCustomer(@RequestBody @Valid DadosCadastroCustomer dados) throws Exception{
        customerRepository.save(new Customer(dados));
    }

}
