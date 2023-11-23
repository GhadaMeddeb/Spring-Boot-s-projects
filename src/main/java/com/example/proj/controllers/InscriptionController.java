package com.example.proj.controllers;


import com.example.proj.Services.InscriptionService;
import com.example.proj.enteties.Inscription;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inscription")
public class InscriptionController {

    private final InscriptionService inscriptionService  ;


    @PostMapping
     public Inscription addInscription(@RequestBody Inscription inscription) {
        return inscriptionService.addInscription(inscription);
    }

    @GetMapping
    public List<Inscription> findAll() {
        return inscriptionService.findAll();
    }

    @GetMapping("{id}")
    public Inscription findById(@PathVariable long id) {
        Inscription inscription = inscriptionService.findById(id);
        return inscription;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id) {

        inscriptionService.delete(id);
        return true;
    }

    @PutMapping
    public Inscription updateInscription(@RequestBody Inscription inscription) {
        return inscriptionService.updateInscription(inscription);
    }





    @PostMapping("/{numSkieur}")
    public Inscription addInscriptionAndAssignToSkieur(@RequestBody Inscription inscription, @PathVariable long numSkieur) {

        return inscriptionService.addInscriptionAndAssignToSkieur(inscription, numSkieur);

    }

@PostMapping("/{numInscription}/{numCours}")
    public Inscription assignInscriptionToCourse(@PathVariable long numInscription, @PathVariable long numCours){

      return inscriptionService.assignInscriptionToCourse(numInscription, numCours);



    }


}
