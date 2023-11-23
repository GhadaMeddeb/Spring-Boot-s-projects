package com.example.proj.enteties;


import com.example.proj.enteties.enums.Support;
import com.example.proj.enteties.enums.TypeCours;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Cours {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Setter(AccessLevel.NONE)
    long numCours;
    int niveau ;
    @Enumerated(EnumType.STRING)
    TypeCours typeCours ;
    @Enumerated(EnumType.STRING)
    Support support ;
    float prix ;
    int creneau;

    @OneToMany(mappedBy = "cours")
    Set<Inscription> SetInscriptions ;

}
