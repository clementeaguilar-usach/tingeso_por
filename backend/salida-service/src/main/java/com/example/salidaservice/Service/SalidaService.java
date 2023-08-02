package com.example.salidaservice.Service;

import com.example.salidaservice.Repository.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalidaService {
    @Autowired
    SalidaRepository salidaRepository;
}
