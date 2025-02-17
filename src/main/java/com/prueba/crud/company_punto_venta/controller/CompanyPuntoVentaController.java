package com.prueba.crud.company_punto_venta.controller;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.company.service.CompanyService;
import com.prueba.crud.company_punto_venta.model.CompanyPuntoVenta;
import com.prueba.crud.company_punto_venta.service.CompanyPuntoVentaService;
import com.prueba.crud.punto_venta.model.PuntoVenta;
import com.prueba.crud.punto_venta.service.PuntoVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/company_punto_venta")
public class CompanyPuntoVentaController {

    @Autowired
    private CompanyPuntoVentaService companyPuntoVentaService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PuntoVentaService puntoVentaService;

    @PostMapping
    public ResponseEntity<?> linkPuntoVentaToCompany(@RequestBody CompanyPuntoVentaRequest request){
        Optional<Company> companyOpt = companyService.getCompanyById(request.getCompanyId());
        Optional<PuntoVenta> puntoVentaOpt =  puntoVentaService.getPuntoVenta(request.getPuntoVentaId());

        if(companyOpt.isEmpty() || puntoVentaOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Empresa o punto de venta no encontrado");
        }

        CompanyPuntoVenta newRelation = companyPuntoVentaService.setPuntoVentaToCompany(
                companyOpt.get(), puntoVentaOpt.get()
        );

        return ResponseEntity.ok(newRelation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRelation(@PathVariable Integer id, @RequestBody CompanyPuntoVentaRequest request){
        Optional<CompanyPuntoVenta> relationOpt = companyPuntoVentaService.getById(id);
        if(relationOpt.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Optional<Company> companyOpt = companyService.getCompanyById(request.getCompanyId());
        Optional<PuntoVenta> puntoVentaOpt =  puntoVentaService.getPuntoVenta(request.getPuntoVentaId());

        if(companyOpt.isEmpty() || puntoVentaOpt.isEmpty()){
            return ResponseEntity.badRequest().body("Empresa o punto de venta no encontrado");
        }

        CompanyPuntoVenta updated = companyPuntoVentaService.updateRelation(id, companyOpt.get(), puntoVentaOpt.get());

        return ResponseEntity.ok(updated);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<CompanyPuntoVenta>> getPuntoVentaByCompany(@PathVariable Integer companyId){
        return ResponseEntity.ok(companyPuntoVentaService.getPuntoVentaByCompany(companyId));
    }

    @GetMapping("/punto_de_venta/{puntoVentaId}")
    public ResponseEntity<List<CompanyPuntoVenta>> getCompanyByPuntoVenta(@PathVariable Integer puntoVentaId){
        return ResponseEntity.ok(companyPuntoVentaService.getCompanyByPuntoVenta(puntoVentaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelation(@PathVariable Integer id){
        companyPuntoVentaService.deleteRelation(id);
        return ResponseEntity.noContent().build();
    }

    // Esta es una clase interna que vamos a utilizar para recibir los datos del request
    public static class CompanyPuntoVentaRequest {
        private Integer companyId;
        private Integer puntoVentaId;

        public Integer getCompanyId() { return companyId; }
        public void setCompanyId(Integer companyId) { this.companyId = companyId; }

        public Integer getPuntoVentaId() { return puntoVentaId; }
        public void setPuntoVentaId(Integer puntoVentaId) { this.puntoVentaId = puntoVentaId; }
    }
}
