package tn.esprit.spring.gestionfoyer.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.gestionfoyer.entities.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {
    Optional <Etudiant> findByCin(long cinEtudiant);

}
