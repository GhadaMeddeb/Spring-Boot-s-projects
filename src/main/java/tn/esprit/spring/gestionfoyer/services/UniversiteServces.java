package tn.esprit.spring.gestionfoyer.services;

import tn.esprit.spring.gestionfoyer.entities.Universite;
import tn.esprit.spring.gestionfoyer.repositories.FoyerRepository;
import tn.esprit.spring.gestionfoyer.repositories.UniversiteRepository;

import java.util.List;

public interface UniversiteServces {
    List<Universite> retrieveAllUniversities();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (long idUniversite);

    public Universite affecterFoyerAUniversite (long idFoyer, String
            nomUniversite) ;
    public Universite desaffecterFoyerAUniversite(long idUniversite);
}
