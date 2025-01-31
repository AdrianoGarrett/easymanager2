package com.easy.easymanager2.controller;

import com.easy.easymanager2.record.DadosCompany;
import com.easy.easymanager2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DadosCompany>> getUserCompanies(@PathVariable int userId) {
        List<DadosCompany> dadosCompanies = companyService.findCompaniesByUserId(userId).stream().map(DadosCompany::new).toList();
        return ResponseEntity.ok(dadosCompanies);
    }
}
