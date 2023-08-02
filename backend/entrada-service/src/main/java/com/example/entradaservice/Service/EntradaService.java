package com.example.entradaservice.Service;

import com.example.entradaservice.Model.EntradaEntity;
import com.example.entradaservice.Repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class EntradaService {
    @Autowired
    EntradaRepository entradaRepository;

    public void saveEntrada(Date fecha, String tipoDocumento, String numDocumento, String motivo) {
        EntradaEntity nuevaEntrada = new EntradaEntity();
        nuevaEntrada.setFecha(fecha);
        nuevaEntrada.setTipoDocumento(tipoDocumento);
        nuevaEntrada.setNumDocumento(numDocumento);
        nuevaEntrada.setMotivo(motivo);
        nuevaEntrada.setEntidad("entrada");
        entradaRepository.save(nuevaEntrada);
    }

    public ArrayList<EntradaEntity> getAllEntradas() {
        return (ArrayList<EntradaEntity>) entradaRepository.getAllEntradas();
    }
}
