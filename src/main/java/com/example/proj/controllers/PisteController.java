package com.example.proj.controllers;


import com.example.proj.Services.PisteService;
import com.example.proj.enteties.Piste;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/piste")
public class PisteController {


    private final PisteService pisteService;

    @PostMapping
    public Piste addPiste(@RequestBody Piste piste){

        return pisteService.addPiste(piste);
    }

    @GetMapping
    public List<Piste> findAll(){

        return pisteService.findAll();
    }

    @GetMapping("{id}")
    public Piste findById(@PathVariable long id){
        Piste piste = pisteService.findById(id);
        return piste;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id){
        pisteService.delete(id);
        return true;
    }

    @PutMapping
    public Piste updatePiste(@RequestBody Piste piste){
        return pisteService.updatePiste(piste);
    }
}

