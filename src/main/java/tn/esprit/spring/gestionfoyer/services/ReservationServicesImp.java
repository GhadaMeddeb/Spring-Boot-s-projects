package tn.esprit.spring.gestionfoyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.gestionfoyer.entities.Chambre;
import tn.esprit.spring.gestionfoyer.entities.Etudiant;
import tn.esprit.spring.gestionfoyer.entities.Reservation;
import tn.esprit.spring.gestionfoyer.repositories.ChambreRepository;
import tn.esprit.spring.gestionfoyer.repositories.EtudiantRepository;
import tn.esprit.spring.gestionfoyer.repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReservationServicesImp implements ReservationServices{
    @Autowired
    private final ReservationRepository reservationRepository;
    private final ChambreRepository chambreRepository;
    private final EtudiantRepository etudiantRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return (List<Reservation> )reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }


   /* public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
        // Retrieve Chambre by ID
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);

        // Retrieve Etudiant by CIN
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        if (chambre != null && etudiant != null) {
            // Check if the room capacity is not reached
            if (!isRoomCapacityReached(chambre)) {
                Reservation reservation = createReservation(chambre, etudiant);

                // Save the reservation to the database
                return reservationRepository.save(reservation);
            }
        }

        return null;
    }

    private boolean isRoomCapacityReached(Chambre chambre) {
        int currentOccupancy = chambre.getReservations().size();

        // You may adjust the logic based on your requirements
        // For example, check if the current occupancy is less than the maximum capacity
        switch (chambre.getTypeC()) {
            case simple:
                return currentOccupancy >= 1;
            case doubles:
                return currentOccupancy >= 2;
            case triple:
                return currentOccupancy >= 3;
            default:
                return true; // Default to true to prevent adding reservations for unknown room types
        }
    }

    private Reservation createReservation(Chambre chambre, Etudiant etudiant) {
        Reservation reservation = new Reservation();
        reservation.setChambre(chambre);
        reservation.setEtudiant(etudiant);
        reservation.setNumReservation(generateReservationNumber(chambre, etudiant));
        reservation.setEstValide(true);
        reservation.setNumReservation(String.valueOf(LocalDate.now())); // Set the current date as the reservation date

        return reservation;
    }

    private String generateReservationNumber(Chambre chambre, Etudiant etudiant) {
        String numChambre = String.valueOf(chambre.getNumeroChambre());
        String nomBloc = chambre.getBloc().getNomBloc();
        String anneeUniversitaire = String.valueOf(LocalDate.now().getYear());

        return numChambre + "-" + nomBloc + "-" + anneeUniversitaire;
    }
    /*public Reservation annulerReservation(long cinEtudiant) {
        // Retrieve Etudiant by CIN
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        if (etudiant != null) {
            Reservation reservation = etudiant.getReservation();

            if (reservation != null) {
                // Update the state of the reservation
                reservation.setEstValide(false);

                // Disassociate the student from the reservation
                reservation.setEtudiant(null);

                // Disassociate the room from the reservation and update its capacity
                Chambre chambre = reservation.getChambre();
                if (chambre != null) {
                    // Update the room capacity
                    chambre.getReservations().remove(reservation);
                    // Save the updated room to the database
                    chambreRepository.save(chambre);
                }

                // Save the updated reservation to the database
                return reservationRepository.save(reservation);
            }
        }

        return null;
    }*/
    @Override
    public Reservation ajouterReservation (long idChambre, long cinEtudiant){
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant).orElseThrow(() ->new IllegalArgumentException("") );
        Chambre chambre = chambreRepository.findById(idChambre).orElseThrow(() -> new IllegalArgumentException(""));
        String id=chambre.get
    }





}

