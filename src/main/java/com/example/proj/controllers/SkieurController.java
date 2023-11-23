package com.example.proj.controllers;

import com.example.proj.Services.SkieurService;
import com.example.proj.enteties.Cours;
import com.example.proj.enteties.Inscription;
import com.example.proj.enteties.Skieur;
import com.example.proj.reposetories.CoursReposetory;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/skieur")
public class SkieurController {

    private final SkieurService skieurService; // couplage faible

    // void addSkieur(Skieur skieur)
    //{

    //   this.skieurService.addSkieur(skieur);
    // }
    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur) {

        return skieurService.addSkieur(skieur);
    }


    @GetMapping
    public List<Skieur> findAll() {
        return skieurService.findAll();
    }

    @GetMapping("{id}")
    public Skieur findById(@PathVariable int id) {
        Skieur skieur = skieurService.findById(id);
        return skieur;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable int id) {
        Skieur skieur = skieurService.findById(id);
        skieurService.delete(id);
        return true;

    }

    @PutMapping
    public Skieur updateSkieur( @RequestBody Skieur skieurr) {


        return skieurService.updateSkieur(skieurr);
    }


    @PostMapping("/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable long numSkieur, @PathVariable long numPiste){

     return skieurService.assignSkieurToPiste(numSkieur,numPiste);
    }

@PostMapping("/{numCours}")
   public Skieur addSkierAndAssignToCourse(Skieur skieur, long numCours){

       return skieurService.addSkierAndAssignToCourse(skieur,numCours);
    }



}









