package com.example.proj.Services;

import com.example.proj.enteties.Abonnement;
import java.util.List;

public interface AbonnementService {


    Abonnement addAbonnement(Abonnement abonnement);

    Abonnement updateAbonnement(Abonnement abonnement);

    List<Abonnement> findAll();

    Abonnement findById(long numAbon);

    void delete(long numAbon);
}
