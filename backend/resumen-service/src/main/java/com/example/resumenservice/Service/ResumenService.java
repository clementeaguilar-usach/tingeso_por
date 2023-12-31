package com.example.resumenservice.Service;

import com.example.resumenservice.Entity.Entrada;
import com.example.resumenservice.Entity.Movimiento;
import com.example.resumenservice.Entity.Salida;
import com.example.resumenservice.Model.ResumenEntity;
import com.example.resumenservice.Repository.ResumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ResumenService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private ResumenRepository resumenRepository;

    public ArrayList<Entrada> allEntradas() {
        ResponseEntity<ArrayList<Entrada>> response = restTemplate.exchange(
                "http://localhost:8080/entrada/allEntradas/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public ArrayList<Salida> allSalidas() {
        ResponseEntity<ArrayList<Salida>> response = restTemplate.exchange(
                "http://localhost:8080/salida/allSalidas/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response.getBody();
    }

    public ArrayList<ResumenEntity> getAllResumen() {
        return (ArrayList<ResumenEntity>) resumenRepository.findAll();
    }

    public void saveResumen(Date fechaInicio, Date fechaFin) {
        resumenRepository.deleteAll();

        ArrayList<Movimiento> movimientos = new ArrayList<>();
        for (Entrada entrada : allEntradas()) {
            if (!entrada.getFecha().before(fechaInicio) && !entrada.getFecha().after(fechaFin)) {
                movimientos.add(new Movimiento(
                        entrada.getFecha(),
                        entrada.getTipoDocumento(),
                        entrada.getNumDocumento(),
                        entrada.getMotivo(),
                        entrada.getMonto(),
                        "entrada"));
            }
        }
        for (Salida salida : allSalidas()) {
            if (!salida.getFecha().before(fechaInicio) && !salida.getFecha().after(fechaFin)) {
                movimientos.add(new Movimiento(
                        salida.getFecha(),
                        salida.getTipoDocumento(),
                        salida.getNumDocumento(),
                        salida.getMotivo(),
                        -salida.getMonto(),
                        "salida"));
            }
        }
        movimientos.sort(Comparator.comparing(Movimiento::getFecha));
        int saldo = 0;
        for (Movimiento movimiento : movimientos) {
            saldo += movimiento.getMonto();
            ResumenEntity nuevoResumen = new ResumenEntity();
            nuevoResumen.setFecha(movimiento.getFecha());
            nuevoResumen.setTipoDocumento(movimiento.getTipoDocumento());
            nuevoResumen.setNumDocumento(movimiento.getNumDocumento());
            nuevoResumen.setMotivo(movimiento.getMotivo());
            nuevoResumen.setMonto(movimiento.getMonto());
            nuevoResumen.setSaldo(saldo);
            nuevoResumen.setTipoMov(movimiento.getEntidad());
            resumenRepository.save(nuevoResumen);
        }
    }
}
