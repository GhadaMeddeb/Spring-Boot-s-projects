package com.example.proj.enteties;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long numSkieur;
    String nomS;
    String prenomS;
    Date dateNaissance;
    String ville;

    @OneToMany(mappedBy = "skieur")
    Set<Inscription> setInscription ;

    @ManyToMany()
    Set<Piste> setPiste ;

    @OneToOne(cascade = CascadeType.ALL)
    Abonnement abonnement;


}
