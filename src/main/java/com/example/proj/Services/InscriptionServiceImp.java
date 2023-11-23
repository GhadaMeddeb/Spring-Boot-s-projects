package com.example.proj.Services;

import com.example.proj.enteties.Cours;
import com.example.proj.enteties.Inscription;
import com.example.proj.enteties.Skieur;
import com.example.proj.reposetories.CoursReposetory;
import com.example.proj.reposetories.InscriptionReposetory;
import com.example.proj.reposetories.SkieurReposetory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class InscriptionServiceImp implements InscriptionService{



    private final InscriptionReposetory inscriptionReposetory;
    private final SkieurReposetory skieurReposetory;
    private  final CoursReposetory coursReposetory;


    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionReposetory.save(inscription);
    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        return inscriptionReposetory.save(inscription);
    }

    @Override
    public List<Inscription> findAll() {
        return (List<Inscription>) inscriptionReposetory.findAll();
    }

    @Override
    public Inscription findById(long numInscription) {
        return inscriptionReposetory.findById(numInscription).orElse(null);
    }

    @Override
    public void delete(long numInscription) {
        inscriptionReposetory.deleteById(numInscription);

    }

    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, long numSkieur) {

        Skieur skieur=skieurReposetory.findById(numSkieur).orElse(null);
        inscription.setSkieur(skieur);

        return inscriptionReposetory.save(inscription);
    }

    @Override
    public Inscription assignInscriptionToCourse(long numInscription, long numCours) {

        Cours cours=coursReposetory.findById(numCours).orElse(null);
        Inscription inscription=inscriptionReposetory.findById(numInscription).orElse(null);
        inscription.setCours(cours);


        return inscriptionReposetory.save(inscription);
    }


}
