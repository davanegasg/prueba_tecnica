package com.prueba.crud.punto_venta.service;

import com.prueba.crud.punto_venta.model.PuntoVenta;
import com.prueba.crud.punto_venta.repository.PuntoVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuntoVentaService {
    @Autowired
    PuntoVentaRepository puntoVentaRepository;

    public List<PuntoVenta> getPuntoVentas(){
        return puntoVentaRepository.findAll();
    }

    public Optional<PuntoVenta> getPuntoVenta(Integer id){
        return puntoVentaRepository.findById(id);
    }

    public PuntoVenta createPuntoVenta(PuntoVenta puntoVenta){
        return puntoVentaRepository.save(puntoVenta);
    }

    public void deletePuntoVenta(Integer id){
        puntoVentaRepository.deleteById(id);
    }
}
