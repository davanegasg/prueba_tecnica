package com.prueba.crud.company_punto_venta.repository;

import com.prueba.crud.company_punto_venta.model.CompanyPuntoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyPuntoVentaRepository extends JpaRepository<CompanyPuntoVenta, Integer> {
    List<CompanyPuntoVenta> findByCompanyId(Integer companyId);
    List<CompanyPuntoVenta> findByPuntoVentaId(Integer puntoVentaId);
}
