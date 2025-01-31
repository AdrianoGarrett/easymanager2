package com.easy.easymanager2.service;

import com.easy.easymanager2.model.Company;
import com.easy.easymanager2.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findCompaniesByUserId(int userId) {
        return companyRepository.findByUserId(userId);
    }
}
