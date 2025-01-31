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
public class Customers {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{companyId}")
    public List<DadosResumidosCustomer> getCustomers(@PathVariable int companyId) {
        return customerRepository.findByCompanyId(companyId).stream().map(DadosResumidosCustomer::new).toList();
    }

    @PostMapping
    public void cadastraCustomer(@RequestBody @Valid DadosCadastroCustomer dados) throws Exception{
        customerRepository.save(new Customer(dados));
    }

}
