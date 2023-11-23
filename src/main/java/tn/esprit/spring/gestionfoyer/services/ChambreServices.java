package tn.esprit.spring.gestionfoyer.services;

import tn.esprit.spring.gestionfoyer.entities.Chambre;

import java.util.List;

public interface ChambreServices {
    List<Chambre> retrieveAllChambres();

    Chambre addChambre(Chambre c);

    Chambre updateChambre (Chambre c);

    Chambre retrieveChambre (long idChambre);
}
