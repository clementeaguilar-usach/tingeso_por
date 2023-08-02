package com.example.entradaservice.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "entrada")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String tipoDocumento;
    private String numDocumento;
    private String motivo;
    private String entidad;
}
