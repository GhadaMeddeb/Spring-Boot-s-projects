package tn.esprit.spring.gestionfoyer.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.gestionfoyer.entities.Universite;

public interface UniversiteRepository extends CrudRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);
}
