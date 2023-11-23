package com.example.proj.controllers;


import com.example.proj.Services.AbonnementService;
import com.example.proj.enteties.Abonnement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/abonnement")
public class AbonnementController {

    private final AbonnementService abonnementService;

    @PostMapping
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement) {

        return abonnementService.addAbonnement(abonnement);
    }

    @GetMapping
    public List<Abonnement> findAll() {

        return abonnementService.findAll();
    }

    @GetMapping("{id}")
    public Abonnement findById(@PathVariable long id) {
        Abonnement abonnement = abonnementService.findById(id);
        return abonnement;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id) {

               abonnementService.delete(id);
        return true;
    }

    @PutMapping
     public Abonnement updateAbonnement( @RequestBody Abonnement abonnement) {


        return abonnementService.updateAbonnement(abonnement);
    }

}
