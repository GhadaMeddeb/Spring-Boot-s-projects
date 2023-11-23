package tn.esprit.spring.gestionfoyer.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.gestionfoyer.entities.Chambre;

import java.util.List;

public interface ChambreRepository extends CrudRepository<Chambre,Long> {
    List<Chambre> findByNumeroChambreIn(List<Long> numChambres);
}
