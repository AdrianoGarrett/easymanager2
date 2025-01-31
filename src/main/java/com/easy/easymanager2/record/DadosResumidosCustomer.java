package com.easy.easymanager2.record;

import com.easy.easymanager2.model.Customer;

public record DadosResumidosCustomer(int id,String firstName, String lastName, String email, String phoneNumber, String city, String state, String country, String gender) {
    public DadosResumidosCustomer(Customer customer) {
        this(customer.getId(),customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber().toString(), customer.getCity(), customer.getState(), customer.getCountry(), customer.getGender());
    }
}
