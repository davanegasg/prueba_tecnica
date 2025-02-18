package com.prueba.crud.rol.controller;

import com.prueba.crud.rol.model.Rol;
import com.prueba.crud.rol.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getAllRoles(){
        return rolService.getRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable("id") Integer id){
        Optional<Rol> user = rolService.getRol(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Rol> createUser(@RequestBody Rol rol){
        Rol roleSaved = rolService.createRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(roleSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id){
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}
