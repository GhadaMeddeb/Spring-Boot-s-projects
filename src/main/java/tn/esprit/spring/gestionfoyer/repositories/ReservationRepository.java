package tn.esprit.spring.gestionfoyer.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.gestionfoyer.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation,String> {
}
