package com.example.resumenservice.Model;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "resumen")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResumenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String tipoDocumento;
    private String numDocumento;
    private String motivo;
    private Integer monto;
    private Integer saldo;
    private String tipoMov;
}
