package com.prueba.crud.user_company.controller;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.company.service.CompanyService;
import com.prueba.crud.company_punto_venta.controller.CompanyPuntoVentaController;
import com.prueba.crud.company_punto_venta.model.CompanyPuntoVenta;
import com.prueba.crud.punto_venta.model.PuntoVenta;
import com.prueba.crud.rol.model.Rol;
import com.prueba.crud.rol.service.RolService;
import com.prueba.crud.user.model.User;
import com.prueba.crud.user.service.UserService;
import com.prueba.crud.user_company.model.UserCompany;
import com.prueba.crud.user_company.service.UserCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user_company)")
public class UserCompanyController {
    @Autowired
    private UserCompanyService userCompanyService;

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<?> setUserToCompany(@RequestBody UserCompanyRequest request){
        Optional<Company> companyOpt = companyService.getCompanyById(request.getCompanyId());
        Optional<User> userOpt = userService.getUser(request.getUserId());
        Optional<Rol> rolOpt = rolService.getRol(request.getRolId());

        if(companyOpt.isEmpty() || userOpt.isEmpty() || rolOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Usuario, compañia o rol no encontrado");
        }

        UserCompany newRelation = userCompanyService.setUserToCompany(
                userOpt.get(), companyOpt.get(), rolOpt.get()
        );

        return ResponseEntity.ok(newRelation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRelation(@PathVariable Integer id, @RequestBody UserCompanyRequest request){
        Optional<UserCompany> relationOpt = userCompanyService.getRelationById(id);
        if(relationOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Optional<Company> companyOpt = companyService.getCompanyById(request.getCompanyId());
        Optional<User> userOpt = userService.getUser(request.getUserId());
        Optional<Rol> rolOpt = rolService.getRol(request.getRolId());

        if(companyOpt.isEmpty() || userOpt.isEmpty() || rolOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Usuario, compañia o rol no encontrado");
        }

        UserCompany updated = userCompanyService.updateRelation(id, userOpt.get(),companyOpt.get(), rolOpt.get());

        return ResponseEntity.ok(updated);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<UserCompany>> getUserByCompany(@PathVariable Integer companyId){
        return ResponseEntity.ok(userCompanyService.getUsersByCompanyId(companyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserCompany>> getCompanyByUser(@PathVariable Integer userId){
        return ResponseEntity.ok(userCompanyService.getCompanyByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelation(@PathVariable Integer id){
        userCompanyService.deleteRelation(id);
        return ResponseEntity.noContent().build();
    }

    // Esta es una clase interna que vamos a utilizar para recibir los datos del request
    public static class UserCompanyRequest {
        private Integer userId;
        private Integer companyId;
        private Integer rolId;

        public Integer getCompanyId() { return companyId; }
        public void setCompanyId(Integer companyId) { this.companyId = companyId; }

        public Integer getUserId() { return userId; }
        public void setUserId(Integer userId) { this.userId = userId; }

        public Integer getRolId() { return rolId; }
        public void setRolId(Integer rolId) { this.rolId = rolId; }
    }
}
