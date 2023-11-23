package com.example.proj.Services;

import com.example.proj.enteties.Inscription;
import java.util.List;

public interface InscriptionService {

    Inscription addInscription(Inscription inscription);

    Inscription updateInscription(Inscription inscription);

    List<Inscription> findAll();

    Inscription findById(long numInscription);

    void delete(long numInscription);

    Inscription addInscriptionAndAssignToSkieur(Inscription inscription, long numSkieur);

    Inscription assignInscriptionToCourse(long numInscription, long numCours);
}
