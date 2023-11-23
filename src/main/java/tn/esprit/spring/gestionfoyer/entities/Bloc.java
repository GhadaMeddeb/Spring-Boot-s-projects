package tn.esprit.spring.gestionfoyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long idBloc ;
    String nomBloc;
    long capaciteBloc;
    @ManyToOne(cascade = CascadeType.ALL)
    private Foyer foyer;
    @OneToMany(mappedBy = "bloc",cascade = CascadeType.ALL)
    private Set<Chambre>chambres;
}
