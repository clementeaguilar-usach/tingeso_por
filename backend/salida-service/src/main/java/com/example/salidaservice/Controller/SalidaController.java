package com.example.salidaservice.Controller;

import com.example.salidaservice.Service.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salidas")
public class SalidaController {

    @Autowired
    SalidaService salidaService;
}
