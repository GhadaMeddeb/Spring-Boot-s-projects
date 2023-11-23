package tn.esprit.spring.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.spring.gestionfoyer.entities.enums.TypeChambre;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idChambre ;
    long numeroChambre;
TypeChambre typeC;
@ManyToOne(cascade = CascadeType.ALL)
    private Bloc bloc;
@OneToMany( cascade = CascadeType.ALL)
    private Set<Reservation>Reservations;
}
