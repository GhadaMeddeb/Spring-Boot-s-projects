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
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idEtudiant ;
    String nomEt;
    String prenomEt;
    long cin;
    String ecole ;
    Date dateNaissance;
    @ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
     private Set<Reservation> reservations;
}
