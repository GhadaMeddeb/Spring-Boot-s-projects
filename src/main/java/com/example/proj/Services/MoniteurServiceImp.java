package com.example.proj.Services;


import com.example.proj.enteties.Cours;
import com.example.proj.enteties.Moniteur;
import com.example.proj.reposetories.CoursReposetory;
import com.example.proj.reposetories.MoniteurReposetory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MoniteurServiceImp implements MoniteurService{




    private final MoniteurReposetory moniteurReposetory;
    private final CoursReposetory coursReposetory;


    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurReposetory.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurReposetory.save(moniteur);
    }

    @Override
    public List<Moniteur> findAll() {
        return (List<Moniteur>) moniteurReposetory.findAll();
    }

    @Override
    public Moniteur findById(long numMoniteur) {
        return moniteurReposetory.findById(numMoniteur).orElse(null);
    }

    @Override
    public void delete(long numMoniteur) {
        moniteurReposetory.deleteById(numMoniteur);

    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, long numCours) {

        Cours cours =coursReposetory.findById(numCours).orElse(null);

        //moniteur.getCourSet().add(cours);  !!!!!!!!


        //namel intialisation lil set w baed n3abi bil cours
        //les 3 ligne suivants sont pour l'affectation de cours lil moniteur
        Set<Cours> coursSet=new HashSet<>();
        coursSet.add(cours);
        moniteur.setCourSet(coursSet);

        //ajout de moniteur donc il va etre managed-entity
        return moniteurReposetory.save(moniteur);
    }




}
