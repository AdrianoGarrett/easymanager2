package com.easy.easymanager2.record;

import com.easy.easymanager2.model.Company;

public record DadosCompany(int id, String companyName) {
    public DadosCompany(Company company){
        this(company.getId(), company.getName());
    }
}
