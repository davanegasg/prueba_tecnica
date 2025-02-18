package com.prueba.crud.company.repository;

import com.prueba.crud.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRespository extends JpaRepository<Company, Integer> {
}
