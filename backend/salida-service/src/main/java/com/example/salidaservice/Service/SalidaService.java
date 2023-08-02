package com.example.salidaservice.Service;

import com.example.salidaservice.Model.SalidaEntity;
import com.example.salidaservice.Repository.SalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class SalidaService {
    @Autowired
    SalidaRepository salidaRepository;

    public void saveSalida(Date fecha, String tipoDocumento, String numDocumento, String motivo) {
        SalidaEntity nuevaSalida = new SalidaEntity();
        nuevaSalida.setFecha(fecha);
        nuevaSalida.setTipoDocumento(tipoDocumento);
        nuevaSalida.setNumDocumento(numDocumento);
        nuevaSalida.setMotivo(motivo);
        nuevaSalida.setEntidad("salida");
        salidaRepository.save(nuevaSalida);
    }

    public ArrayList<SalidaEntity> getAllSalidas() {
        return (ArrayList<SalidaEntity>) salidaRepository.getAllSalidas();
    }
}
