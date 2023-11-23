package com.example.proj.controllers;


import com.example.proj.Services.CoursService;
import com.example.proj.enteties.Cours;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cours")
public class CoursController {

    private final CoursService coursService;

    @PostMapping
    public Cours addCours(@RequestBody Cours cours) {

        return coursService.addCours(cours);
    }

    @GetMapping
    public List<Cours> findAll() {
        return coursService.findAll();
    }

    @GetMapping("{id}")
    public Cours findById(@PathVariable long id) {
        Cours cours = coursService.findById(id);
        return cours;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable long id) {
        coursService.delete(id);
        return true;
    }

    @PutMapping
    public Cours updateCours( @RequestBody Cours cours) {


        return coursService.updateCours(cours);
    }

}


