package tn.esprit.spring.gestionfoyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyer.entities.Foyer;
import tn.esprit.spring.gestionfoyer.entities.Universite;
import tn.esprit.spring.gestionfoyer.repositories.FoyerRepository;
import tn.esprit.spring.gestionfoyer.services.FoyerServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    private final FoyerServices foyerServices;
    @GetMapping
    public List<Foyer> retrieveAllFoyers()  {
        return foyerServices.retrieveAllFoyers();
    }
@PostMapping
    public Foyer addFoyer(@RequestBody Foyer foyer)
{
    return foyerServices.addFoyer(foyer);

}
    @PutMapping
    public Foyer updateFoyer(@RequestBody Foyer foyer)
    {
        return foyerServices.updateFoyer(foyer);

    }
    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite)
    {
        return this.foyerServices.ajouterFoyerEtAffecterAUniversite(foyer , idUniversite) ;
    }
    @GetMapping("{id}")
    public Foyer retrieveFoyer(@PathVariable long idFoyer){
        Foyer foyer= foyerServices.retrieveFoyer(idFoyer);
        return foyer;
    }
@DeleteMapping("{id}")
    public boolean removeFoyer(@PathVariable long idFoyer){
        foyerServices.removeFoyer(idFoyer);
        return true;
}
}
