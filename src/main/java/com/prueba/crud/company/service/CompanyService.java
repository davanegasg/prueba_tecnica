package com.prueba.crud.company.service;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.company.repository.CompanyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    CompanyRespository companyRespository;

    public List<Company> getCompanies(){
        return companyRespository.findAll();
    }

    public Optional<Company> getCompanyById(Integer id){
        return companyRespository.findById(id);
    }

    public Company createCompany(Company company){
        return companyRespository.save(company);
    }

    public void deleteCompany(Integer id){
        companyRespository.deleteById(id);
    }

}
