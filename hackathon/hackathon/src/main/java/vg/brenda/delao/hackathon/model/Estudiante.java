package vg.brenda.delao.hackathon.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Estudiante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstudiante")
    private Integer idEstudiante;

    @Column(name = "dni", nullable = false, length = 8, unique = true)
    private String dni;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")  // Formato para JSON legible
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "correo", nullable = false, length = 100, unique = true)
    private String correo;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "idUbigeo", nullable = false)
    private Ubigeo ubigeo;

    @ManyToOne
    @JoinColumn(name = "idPrograma", nullable = false)
    private Programa programa;

    @Column(name = "estado", columnDefinition = "CHAR(1) DEFAULT 'A'", nullable = false)
    private char estado = 'A';  // 'A' = activo, 'I' = inactivo

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // Formato legible para fecha/hora
    @Column(name = "fechaRegistro", nullable = false)
    private Date fechaRegistro = new Date();
}
