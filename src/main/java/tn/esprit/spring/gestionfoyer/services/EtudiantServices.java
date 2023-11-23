package tn.esprit.spring.gestionfoyer.services;

import tn.esprit.spring.gestionfoyer.entities.Etudiant;

import java.util.List;

public interface EtudiantServices {
    List<Etudiant> retrieveAllEtudiants();

   public List<Etudiant> addEtudiants (List<Etudiant> etudiants);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(long idEtudiant);

    void removeEtudiant(long idEtudiant);
}
