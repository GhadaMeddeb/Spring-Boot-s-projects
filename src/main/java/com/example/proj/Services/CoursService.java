package com.example.proj.Services;

import com.example.proj.enteties.Cours;
import com.example.proj.enteties.Piste;

import java.util.List;

public interface CoursService {


    Cours addCours(Cours cours);

    Cours updateCours(Cours cours);

    List<Cours> findAll();

    Cours findById(long numCours);

    void delete(long numCours);
}
