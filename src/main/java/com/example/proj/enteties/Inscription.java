package com.example.proj.enteties;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Inscription {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long numInscription;
    int numSemaine ;

    @ManyToOne
    Cours cours ;

    @ManyToOne
    Skieur skieur ;
}
