package tn.esprit.spring.gestionfoyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyer.entities.Etudiant;
import tn.esprit.spring.gestionfoyer.entities.Foyer;
import tn.esprit.spring.gestionfoyer.services.EtudiantServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    private final EtudiantServices etudiantServices;
    @GetMapping
    public List<Etudiant> retrieveAllEtudiants()  {
        return etudiantServices.retrieveAllEtudiants();
    }
    @PostMapping
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants)
    {
        return etudiantServices.addEtudiants(etudiants);

    }
    @PutMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant)
    {
        return etudiantServices.updateEtudiant(etudiant);

    }
    @GetMapping("{id}")
    public Etudiant retrieveFoyer(@PathVariable long idEtudiant){
        Etudiant etudiant= etudiantServices.retrieveEtudiant(idEtudiant);
        return etudiant;
    }
    @DeleteMapping("{id}")
    public boolean removeEtudiant(@PathVariable long idEtudiant){
        etudiantServices.removeEtudiant(idEtudiant);
        return true;
    }
}
