package com.prueba.crud.company.controller;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.company.service.CompanyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Integer id){
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        Company companySaved = companyService.createCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(companySaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") Integer id){
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
