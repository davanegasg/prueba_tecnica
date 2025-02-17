package com.prueba.crud.punto_venta.controller;

import com.prueba.crud.punto_venta.model.PuntoVenta;
import com.prueba.crud.punto_venta.service.PuntoVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/puntoVenta")
public class PuntoVentaController {
    @Autowired
    private PuntoVentaService puntoVentaService;

    @GetMapping
    public List<PuntoVenta> getAll(){
        return puntoVentaService.getPuntoVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuntoVenta> getPuntoVentaById(@PathVariable("id") Integer id){
        Optional<PuntoVenta> puntoVenta = puntoVentaService.getPuntoVenta(id);
        return puntoVenta.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<PuntoVenta> createPuntoVenta(@RequestBody PuntoVenta puntoVenta){
        PuntoVenta puntoVentaSaved = puntoVentaService.createPuntoVenta(puntoVenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(puntoVentaSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuntoVenta(@PathVariable("id") Integer id){
        puntoVentaService.deletePuntoVenta(id);
        return ResponseEntity.noContent().build();
    }
}
