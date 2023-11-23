package tn.esprit.spring.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    String idReservation ;
    Date anneeUniversitaire ;
    boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant>etudiants;

    public void setChambre(Chambre chambre) {
    }

    public void setEtudiant(Etudiant etudiant) {
    }

    public void setNumReservation(String s) {
    }
}
