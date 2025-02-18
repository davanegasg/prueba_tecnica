package com.prueba.crud.rol.service;

import com.prueba.crud.rol.model.Rol;
import com.prueba.crud.rol.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public List<Rol> getRoles(){
        return rolRepository.findAll();
    }

    public Optional<Rol> getRol(Integer id){
        return rolRepository.findById(id);
    }

    public Rol createRol(Rol rol){
        return rolRepository.save(rol);
    }

    public void deleteRol(Integer id){
        rolRepository.deleteById(id);
    }
}
