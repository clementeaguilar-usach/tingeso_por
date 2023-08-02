package com.example.salidaservice.Controller;

import com.example.salidaservice.Model.SalidaEntity;
import com.example.salidaservice.Service.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/salida")
public class SalidaController {

    @Autowired
    SalidaService salidaService;

    @PostMapping("/saveSalida")
    public ResponseEntity saveSalida(@RequestParam("fecha") Date fecha,
                                     @RequestParam("tipoDocumento") String tipoDocumento,
                                     @RequestParam("numDocumento") String numDocumento,
                                     @RequestParam("motivo") String motivo,
                                     @RequestParam("monto") Integer monto) {
        salidaService.saveSalida(fecha, tipoDocumento, numDocumento, motivo, monto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allSalidas")
    public ResponseEntity <ArrayList<SalidaEntity>> getAllSalidas() {
        ArrayList<SalidaEntity> salidas;
        salidas = salidaService.getAllSalidas();
        return ResponseEntity.ok(salidas);
    }
}
