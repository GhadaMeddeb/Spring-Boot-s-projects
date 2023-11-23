package tn.esprit.spring.gestionfoyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.gestionfoyer.entities.Bloc;
import tn.esprit.spring.gestionfoyer.entities.Chambre;
import tn.esprit.spring.gestionfoyer.repositories.BlocRepository;
import tn.esprit.spring.gestionfoyer.repositories.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlocServicesImp implements BlocServices{
    @Autowired
    private final BlocRepository blocRepository;
    private final ChambreRepository chambreRepository;
    @Override
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>)blocRepository.findAll() ;
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        // Retrieve the Bloc by ID
        Optional<Bloc> optionalBloc = blocRepository.findById(idBloc);

        if (optionalBloc.isPresent()) {
            Bloc bloc = optionalBloc.get();

            // Retrieve the Chambres by their numbers
            List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambres);

            // Set the Bloc for each Chambre
            chambres.forEach(chambre -> chambre.setBloc(bloc));

            // Save the updated Chambres to the database
            chambreRepository.saveAll(chambres);

            // Return the updated Bloc
            return bloc;
        }

        // Return null if the Bloc with the given ID is not found
        return null;
    }
}
