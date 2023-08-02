package com.example.resumenservice.Controller;

import com.example.resumenservice.Model.ResumenEntity;
import com.example.resumenservice.Service.ResumenService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity saveResumen(@RequestParam("fechaInicio") Date fechaInicio,
                                      @RequestParam("fechaFin") Date fechaFin) {
        resumenService.saveResumen(fechaInicio, fechaFin);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allResumen")
    public ResponseEntity <ArrayList<ResumenEntity>> getAllResumen() {
        ArrayList<ResumenEntity> resumens;
        resumens = resumenService.getAllResumen();
        return ResponseEntity.ok(resumens);
    }
}
