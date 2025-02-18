package com.prueba.crud.user_company.model;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.rol.model.Rol;
import com.prueba.crud.user.model.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios_empresas", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "empresa_id"}))
public class UserCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    public UserCompany(){}

    public UserCompany(User user, Company company, Rol rol){
        this.user = user;
        this.company = company;
        this.rol    = rol;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
