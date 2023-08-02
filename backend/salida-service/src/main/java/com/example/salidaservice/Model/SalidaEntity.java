package com.example.salidaservice.Model;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "salida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String tipoDocumento;
    private String numDocumento;
    private String motivo;
    private Integer monto;
    private String entidad;
}
