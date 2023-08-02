package com.example.resumenservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Salida {
    private Date fecha;
    private String tipoDocumento;
    private String numDocumento;
    private String motivo;
    private Integer monto;
    private String entidad;
}