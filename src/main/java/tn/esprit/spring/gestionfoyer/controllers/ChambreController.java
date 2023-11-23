package tn.esprit.spring.gestionfoyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyer.entities.Chambre;
import tn.esprit.spring.gestionfoyer.entities.Etudiant;
import tn.esprit.spring.gestionfoyer.services.ChambreServices;
import tn.esprit.spring.gestionfoyer.services.EtudiantServices;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/chambre")
public class ChambreController {
    private final ChambreServices chambreServices;
    @GetMapping
    public List<Chambre> retrieveAllChambres()  {
        return chambreServices.retrieveAllChambres();
    }
    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre)
    {
        return chambreServices.addChambre(chambre);

    }
    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre chambre)
    {
        return chambreServices.updateChambre(chambre);

    }
    @GetMapping("{id}")
    public Chambre retrieveChambre(@PathVariable long idChambre){
        Chambre chambre= chambreServices.retrieveChambre(idChambre);
        return chambre;
    }
}
