package com.example.proj.Services;

import com.example.proj.enteties.Piste;

import java.util.List;

public interface PisteService {

    Piste addPiste(Piste piste);

    Piste updatePiste(Piste piste);

    List<Piste> findAll();

    Piste findById(long numPiste);

    void delete(long numPiste);


}
