package tn.esprit.spring.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Setter(AccessLevel.NONE)
    long idUniveriste;
    String nomUniversite;
    String adresse;
    @OneToOne
    private Foyer foyer;
}
