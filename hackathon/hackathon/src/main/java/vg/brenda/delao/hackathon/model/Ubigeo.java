package vg.brenda.delao.hackathon.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ubigeo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ubigeo {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "idUbigeo")
                private Integer idUbigeo;

                    @Column(name = "departamento", nullable = false, length = 50)
                        private String departamento;

                            @Column(name = "provincia", nullable = false, length = 50)
                                private String provincia;

                                    @Column(name = "distrito", nullable = false, length = 50)
                                        private String distrito;
                                        }
                                        