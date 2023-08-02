package com.example.resumenservice.Service;

import com.example.resumenservice.Entity.Entrada;
import com.example.resumenservice.Entity.Salida;
import com.example.resumenservice.Model.ResumenEntity;
import com.example.resumenservice.Repository.ResumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

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
        ArrayList<Entrada> entradas = new ArrayList<>();
        ArrayList<Salida> salidas = new ArrayList<>();
        resumenRepository.deleteAll();

        for (Entrada entrada : allEntradas()) {
            if (entrada.getFecha().after(fechaInicio) && entrada.getFecha().before(fechaFin)) {
                entradas.add(entrada);
            }
        }
        for (Salida salida : allSalidas()) {
            if (salida.getFecha().after(fechaInicio) && salida.getFecha().before(fechaFin)) {
                salidas.add(salida);
            }
        }
        entradas.sort(Comparator.comparing(Entrada::getFecha));
        salidas.sort(Comparator.comparing(Salida::getFecha));
        int iEntrada = 0;
        int iSalida = 0;
        int saldo = 0;
        while (iEntrada < entradas.size() || iSalida < salidas.size()) {
            ResumenEntity nuevoResumen = new ResumenEntity();
            if (iEntrada < entradas.size() && (iSalida == salidas.size()
                    || entradas.get(iEntrada).getFecha().before(salidas.get(iSalida).getFecha()))) {
                Entrada entradaActual = entradas.get(iEntrada);
                saldo += entradaActual.getMonto();
                nuevoResumen.setFecha(entradaActual.getFecha());
                nuevoResumen.setTipoDocumento(entradaActual.getTipoDocumento());
                nuevoResumen.setNumDocumento(entradaActual.getNumDocumento());
                nuevoResumen.setMotivo(entradaActual.getMotivo());
                nuevoResumen.setMonto(entradaActual.getMonto());
                nuevoResumen.setSaldo(saldo);
                resumenRepository.save(nuevoResumen);
                iEntrada++;
            }
            else {
                Salida salidaActual = salidas.get(iSalida);
                saldo -= salidaActual.getMonto();
                nuevoResumen.setFecha(salidaActual.getFecha());
                nuevoResumen.setTipoDocumento(salidaActual.getTipoDocumento());
                nuevoResumen.setNumDocumento(salidaActual.getNumDocumento());
                nuevoResumen.setMotivo(salidaActual.getMotivo());
                nuevoResumen.setMonto(salidaActual.getMonto());
                nuevoResumen.setSaldo(saldo);
                resumenRepository.save(nuevoResumen);
                iSalida++;
            }
        }
    }
}
