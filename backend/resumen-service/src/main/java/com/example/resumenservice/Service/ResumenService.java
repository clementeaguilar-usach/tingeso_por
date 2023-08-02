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

import java.lang.reflect.Type;
import java.util.ArrayList;
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

    public ArrayList<ResumenEntity> getAllResumenes() {
        return (ArrayList<ResumenEntity>) resumenRepository.findAll();
    }

    public void saveResumen(Date fechaInicio, Date fechaFin) {
        
    }
}
