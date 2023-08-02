package com.example.entradaservice.Controller;

import com.example.entradaservice.Service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entradas")
public class EntradaController {

    @Autowired
    EntradaService entradaService;
}
