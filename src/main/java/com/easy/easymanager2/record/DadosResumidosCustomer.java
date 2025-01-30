package com.easy.easymanager2.record;

import com.easy.easymanager2.model.Customer;

public record DadosResumidosCustomer(String firstName, String lastName, String email, String PhoneNumber, String city, String state, String country, String gender) {
    public DadosResumidosCustomer(Customer customer) {
        this(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber().toString(), customer.getCity(), customer.getState(), customer.getCountry(), customer.getGender());
    }
}
