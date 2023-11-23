package tn.esprit.spring.gestionfoyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyer.entities.Universite;
import tn.esprit.spring.gestionfoyer.services.UniversiteServces;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    private final UniversiteServces universiteServces;
    @PostMapping
    public Universite addUniversite (@RequestBody Universite universite) {

        return universiteServces.addUniversite(universite);
    }
    @PostMapping("nomUniversite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite (@PathVariable long idFoyer, @PathVariable String
            nomUniversite) {
        return universiteServces.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }
    @GetMapping
    public List<Universite> findAll() {
        return universiteServces.retrieveAllUniversities();
    }
    @GetMapping("{id}")
    public Universite findById(@PathVariable long id)
    {
        Universite universite = universiteServces.retrieveUniversite(id);
        return universite;
    }
    @PutMapping
    public Universite UpdateUniversite (@RequestBody Universite universite){
        return universiteServces.updateUniversite(universite);
    }
    @DeleteMapping
    public boolean desaffecterFoyerAUniversite(@PathVariable long idUniversite){
        universiteServces.desaffecterFoyerAUniversite(idUniversite);
        return true;
    }
}


