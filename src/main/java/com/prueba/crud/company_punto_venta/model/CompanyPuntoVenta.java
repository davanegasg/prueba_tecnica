package com.prueba.crud.company_punto_venta.model;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.punto_venta.model.PuntoVenta;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empresas_puntos_de_venta")
public class CompanyPuntoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "punto_de_venta_id", nullable = false)
    private PuntoVenta puntoVenta;

    public CompanyPuntoVenta() {}

    public CompanyPuntoVenta(Company company, PuntoVenta puntoVenta) {
        this.company = company;
        this.puntoVenta = puntoVenta;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }
}
