package com.example.resumenservice.Controller;

import com.example.resumenservice.Entity.Entrada;
import com.example.resumenservice.Entity.Salida;
import com.example.resumenservice.Model.ResumenEntity;
import com.example.resumenservice.Service.ResumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/resumen")
public class ResumenController {

    @Autowired
    ResumenService resumenService;

    @PostMapping("/saveResumen")
    public ResponseEntity saveResumen(@RequestParam("fechaInicio") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaInicio,
                                      @RequestParam("fechaFin") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaFin) {
        resumenService.saveResumen(fechaInicio, fechaFin);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allResumen")
    public ResponseEntity <ArrayList<ResumenEntity>> getAllResumen() {
        ArrayList<ResumenEntity> resumens;
        resumens = resumenService.getAllResumen();
        return ResponseEntity.ok(resumens);
    }

    @GetMapping("/test1")
    public ResponseEntity <ArrayList<Entrada>> test1() {
        ArrayList<Entrada> entradas;
        entradas = resumenService.allEntradas();
        return ResponseEntity.ok(entradas);
    }

    @GetMapping("/test2")
    public ResponseEntity <ArrayList<Salida>> test2() {
        ArrayList<Salida> salidas;
        salidas = resumenService.allSalidas();
        return ResponseEntity.ok(salidas);
    }
}
