package com.prueba.crud.company_punto_venta.service;

import com.prueba.crud.company.model.Company;
import com.prueba.crud.company_punto_venta.model.CompanyPuntoVenta;
import com.prueba.crud.company_punto_venta.repository.CompanyPuntoVentaRepository;
import com.prueba.crud.punto_venta.model.PuntoVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyPuntoVentaService {
    @Autowired
    CompanyPuntoVentaRepository companyPuntoVentaRepository;

    public CompanyPuntoVenta updateRelation(Integer id, Company company, PuntoVenta puntoVenta){
        Optional<CompanyPuntoVenta> companyPuntoVentaOpt =  companyPuntoVentaRepository.findById(id);
        if(companyPuntoVentaOpt.isPresent()){
            CompanyPuntoVenta companyPuntoVenta = companyPuntoVentaOpt.get();
            companyPuntoVenta.setCompany(company);
            companyPuntoVenta.setPuntoVenta(puntoVenta);
            return companyPuntoVentaRepository.save(companyPuntoVenta);
        }
        return null;
    }

    public Optional<CompanyPuntoVenta> getById(Integer id){
        return companyPuntoVentaRepository.findById(id);
    }

    public CompanyPuntoVenta setPuntoVentaToCompany(Company company, PuntoVenta puntoVenta){
        CompanyPuntoVenta companyPuntoVenta = new CompanyPuntoVenta(company, puntoVenta);
        return companyPuntoVentaRepository.save(companyPuntoVenta);
    }

    public List<CompanyPuntoVenta> getPuntoVentaByCompany(Integer companyId){
        return companyPuntoVentaRepository.findByCompanyId(companyId);
    }

    public List<CompanyPuntoVenta> getCompanyByPuntoVenta(Integer puntoVentaId){
        return companyPuntoVentaRepository.findByPuntoVentaId(puntoVentaId);
    }

    public void deleteRelation(Integer id){
        companyPuntoVentaRepository.deleteById(id);
    }
}
