package vg.brenda.delao.hackathon.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Programa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrograma")
    private Integer idPrograma;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
}
