package com.example.entradaservice.Service;

import com.example.entradaservice.Repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaService {
    @Autowired
    EntradaRepository entradaRepository;
}
