package tn.esprit.spring.gestionfoyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.gestionfoyer.entities.Etudiant;
import tn.esprit.spring.gestionfoyer.repositories.EtudiantRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public abstract class EtudiantServicesImp implements EtudiantServices{
    @Autowired
    private final EtudiantRepository etudiantRepository;



    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll() ;
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
         etudiants= etudiantRepository.saveAll(List<Etudiant> etudiants);
        return etudiants;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
