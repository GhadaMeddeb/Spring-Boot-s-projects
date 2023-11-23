package tn.esprit.spring.gestionfoyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.gestionfoyer.entities.Foyer;
import tn.esprit.spring.gestionfoyer.entities.Universite;
import tn.esprit.spring.gestionfoyer.repositories.FoyerRepository;
import tn.esprit.spring.gestionfoyer.repositories.UniversiteRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UniversiteServicesImp implements UniversiteServces{
    private final FoyerRepository foyerRepository;

    @Autowired
    private final UniversiteRepository universiteRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>)universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }


@Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        // Retrieve Foyer by id
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);

        if (foyer == null) {
            // Handle the case where the Foyer is not found
            // You can throw an exception, return null, or handle it based on your application's requirements
            return null;
        }

        // Check if the Universite already exists with the given name
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (universite == null) {
            // If Universite does not exist, create a new one
            universite = new Universite();
            universite.setNomUniversite(nomUniversite);
            // Set the Foyer for the Universite
            universite.setFoyer(foyer);
            // Save the new Universite to the database
            universiteRepository.save(universite);
        } else {
            // If Universite already exists, update its Foyer
            universite.setFoyer(foyer);
            // Save the updated Universite to the database
            universiteRepository.save(universite);
        }

        // Return the updated Universite
        return universite;
    }





    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        // Retrieve Universite by id
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {
            // Set the Foyer for the Universite to null
            universite.setFoyer(null);
            // Save the updated Universite to the database
            universiteRepository.save(universite);
        }

        // Return the updated or null Universite
        return universite;
    }
}
