package tn.esprit.spring.gestionfoyer.services;

import tn.esprit.spring.gestionfoyer.entities.Reservation;

import java.util.List;

public interface ReservationServices {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation (Reservation res);

    Reservation retrieveReservation (String idReservation);
}
