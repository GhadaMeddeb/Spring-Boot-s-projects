package tn.esprit.spring.gestionfoyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.gestionfoyer.entities.Bloc;
import tn.esprit.spring.gestionfoyer.entities.Foyer;
import tn.esprit.spring.gestionfoyer.entities.Universite;
import tn.esprit.spring.gestionfoyer.repositories.BlocRepository;
import tn.esprit.spring.gestionfoyer.repositories.FoyerRepository;
import tn.esprit.spring.gestionfoyer.repositories.UniversiteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FoyerServicesImp implements FoyerServices{
    @Autowired
    private final FoyerRepository foyerRepository;
    private final UniversiteRepository universiteRepository;
    private final BlocRepository blocRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

@Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        // Retrieve the Universite by ID
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {
            // Set the Universite for the Foyer
            foyer.setUniversite(universite);

            // Save the Foyer to the database to get its ID
            Foyer savedFoyer = foyerRepository.save(foyer);

            // Create and associate Blocs with the Foyer
            Set<Bloc> blocs = createAndAssociateBlocs(savedFoyer);

            // Set the associated Blocs for the Foyer
            savedFoyer.setBlocs(blocs);

            // Save the updated Foyer with associated Blocs to the database
            return foyerRepository.save(savedFoyer);
        }

        // Return null if the Universite with the given ID is not found
        return null;
    }

    private Set<Bloc> createAndAssociateBlocs(Foyer foyer) {
        Set<Bloc> blocs = new HashSet<>();

        // You can customize this logic based on your requirements
        // For example, create three Blocs and associate them with the Foyer
        for (int i = 1; i <= 3; i++) {
            Bloc bloc = new Bloc();
            bloc.setNomBloc("Bloc " + i);
            bloc.setCapaciteBloc(20); // Set the capacity as needed
            bloc.setFoyer(foyer); // Associate the Bloc with the Foyer

            // Save the Bloc to get its ID

            Bloc savedBloc = blocRepository.save(bloc);

            // You may add additional logic for creating and associating Chambres with each Bloc if needed

            // Add the saved Bloc to the Set
            blocs.add(savedBloc);
        }

        return blocs;
    }
}

