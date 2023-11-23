package com.example.proj.Services;


import com.example.proj.enteties.Skieur;

import java.util.List;

public interface SkieurService {

    Skieur addSkieur(Skieur skieur);

    Skieur updateSkieur(Skieur skieur);


    List<Skieur> findAll();

    Skieur findById(long numSkieur);


    void delete(long numSkieur);


    Skieur assignSkieurToPiste(long numSkieur, long numPiste);

    Skieur addSkierAndAssignToCourse(Skieur skieur, long numCours);
}
