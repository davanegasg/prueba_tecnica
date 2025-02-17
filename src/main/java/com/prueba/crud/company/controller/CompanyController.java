package com.prueba.crud.company.controller;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAll(){
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompanyById(@PathVariable("id") Integer id){
        return companyService.getCompanyById(id);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return company;
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") Integer id){
        companyService.deleteCompany(id);
    }
}
