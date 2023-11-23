package com.example.proj.controllers;

import com.example.proj.Services.MoniteurService;
import com.example.proj.enteties.Moniteur;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moniteur")
public class MoniteurController {


    private final MoniteurService  moniteurService;



    @PostMapping
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur){
        return moniteurService.addMoniteur(moniteur);

    }

    @GetMapping
    public List<Moniteur> findAll(){
        return moniteurService.findAll();
    }

    @GetMapping("{id}")
    public Moniteur findById(@PathVariable long id){
        Moniteur moniteur = moniteurService.findById(id);
        return moniteur;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id){
        moniteurService.delete(id);
        return true;
    }

    @PutMapping
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur){
        return moniteurService.updateMoniteur(moniteur);
    }



    @PostMapping("/{numCours}")
   public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur,@PathVariable long numCours){
        return moniteurService.addInstructorAndAssignToCourse(moniteur,numCours);


   }






}
