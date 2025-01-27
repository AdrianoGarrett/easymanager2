package com.easy.easymanager2.record;

import com.easy.easymanager2.model.Customer;

public record DadosResumidosCustomer(String firstName, String lastName) {
    public DadosResumidosCustomer(Customer customer) {
        this(customer.getFirstName(), customer.getLastName());
    }
}
