package tn.esprit.spring.gestionfoyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyer.entities.Reservation;
import tn.esprit.spring.gestionfoyer.entities.Universite;
import tn.esprit.spring.gestionfoyer.services.ReservationServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationServices reservationServices;
    @GetMapping
    public List<Reservation> retrieveAllReservation() { return reservationServices.retrieveAllReservation();}

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationServices.updateReservation(reservation);
    }
    @GetMapping("{id}")
    public Reservation retrieveReservation(@PathVariable String idReservation){
        Reservation reservation= reservationServices.retrieveReservation(idReservation);
        return reservation;
    }

}
