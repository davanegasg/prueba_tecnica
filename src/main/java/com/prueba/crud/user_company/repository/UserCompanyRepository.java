package com.prueba.crud.user_company.repository;

import com.prueba.crud.user_company.model.UserCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCompanyRepository extends JpaRepository<UserCompany, Integer> {
    List<UserCompany> findByUserId(Integer userId);
    List<UserCompany> findByCompanyId(Integer companyId);
}
