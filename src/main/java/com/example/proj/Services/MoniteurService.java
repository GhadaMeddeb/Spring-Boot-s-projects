package com.example.proj.Services;

import com.example.proj.enteties.Moniteur;

import java.util.List;

public interface MoniteurService {

    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur(Moniteur moniteur);

    List<Moniteur> findAll() ;

    Moniteur findById(long numMoniteur);

    void  delete(long numMoniteur);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, long numCours);
}
