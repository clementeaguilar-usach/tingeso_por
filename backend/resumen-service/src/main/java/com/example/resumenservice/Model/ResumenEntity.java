package com.example.resumenservice.Model;

import jakarta.persistence.*;
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
    private Integer saldo;
    private String numDoc;
    private Integer monto;
    private String motivo;
    private String tipoDoc;
    private Date fecha;
}
