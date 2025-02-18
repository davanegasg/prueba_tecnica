package com.prueba.crud.punto_venta.repository;

import com.prueba.crud.punto_venta.model.PuntoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntoVentaRepository extends JpaRepository<PuntoVenta, Integer> {
}
