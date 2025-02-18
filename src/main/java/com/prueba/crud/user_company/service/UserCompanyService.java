package com.prueba.crud.user_company.service;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.rol.model.Rol;
import com.prueba.crud.user.model.User;
import com.prueba.crud.user_company.model.UserCompany;
import com.prueba.crud.user_company.repository.UserCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCompanyService {
    @Autowired
    private UserCompanyRepository userCompanyRepository;

    public UserCompany setUserToCompany(User user, Company company, Rol rol){
        UserCompany userCompany = new UserCompany(user, company, rol);
        return userCompanyRepository.save(userCompany);
    }

    public UserCompany updateRelation(Integer id, User user, Company company, Rol rol){
        Optional<UserCompany> relationExist = userCompanyRepository.findById(id);
        if (relationExist.isPresent()){
            UserCompany relation = relationExist.get();
            relation.setUser(user);
            relation.setCompany(company);
            relation.setRol(rol);
            return userCompanyRepository.save(relation);
        }
        return null;
    }

    public Optional<UserCompany> getRelationById(Integer id){
        return userCompanyRepository.findById(id);
    }

    public List<UserCompany> getUsersByCompanyId(Integer companyId){
        return userCompanyRepository.findByCompanyId(companyId);
    }

    public List<UserCompany> getCompanyByUserId(Integer userId){
        return userCompanyRepository.findByUserId(userId);
    }

    public void deleteRelation(Integer id){
        userCompanyRepository.deleteById(id);
    }
}
