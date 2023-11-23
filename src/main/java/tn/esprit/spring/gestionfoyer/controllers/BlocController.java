package tn.esprit.spring.gestionfoyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.gestionfoyer.entities.Bloc;
import tn.esprit.spring.gestionfoyer.entities.Etudiant;
import tn.esprit.spring.gestionfoyer.repositories.EtudiantRepository;
import tn.esprit.spring.gestionfoyer.services.BlocServices;


import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    private final BlocServices blocServices;
    @GetMapping
    public List<Bloc> retrieveBlocs()  {
        return blocServices.retrieveBlocs();
    }
    @PostMapping
    public Bloc updateBloc(@RequestBody Bloc bloc)
    {
        return blocServices.updateBloc(bloc);

    }
    @PutMapping
    public Bloc addBloc(@RequestBody Bloc bloc)
    {
        return blocServices.addBloc(bloc);

    }
    @GetMapping("{id}")
    public Bloc retrieveBloc(@PathVariable long idBloc){
        Bloc bloc= blocServices.retrieveBloc(idBloc);
        return bloc;
    }
    @DeleteMapping("{id}")
    public boolean removeBloc(@PathVariable long idBloc){
        blocServices.removeBloc(idBloc);
        return true;
    }
    @PostMapping("affecterChambresABloc/{numChambres}/{idBloc}")
    public Bloc affecterChambresABloc(@PathVariable List<Long> numChambres, @PathVariable long idBloc){
        return blocServices.affecterChambresABloc(numChambres,idBloc);
    }
}
