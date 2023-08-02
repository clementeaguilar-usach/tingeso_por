package com.example.entradaservice.Controller;

import com.example.entradaservice.Model.EntradaEntity;
import com.example.entradaservice.Service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/entrada")
public class EntradaController {

    @Autowired
    EntradaService entradaService;

    @PostMapping("/saveEntrada")
    public ResponseEntity saveEntrada(@RequestParam("fecha") Date fecha,
                                      @RequestParam("tipoDocumento") String tipoDocumento,
                                      @RequestParam("numDocumento") String numDocumento,
                                      @RequestParam("motivo") String motivo,
                                      @RequestParam("monto") Integer monto) {
        entradaService.saveEntrada(fecha, tipoDocumento, numDocumento, motivo, monto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allEntradas")
    public ResponseEntity <ArrayList<EntradaEntity>> getAllEntradas() {
        ArrayList<EntradaEntity> entradas;
        entradas = entradaService.getAllEntradas();
        return ResponseEntity.ok(entradas);
    }
}
