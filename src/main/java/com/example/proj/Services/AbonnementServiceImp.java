package com.example.proj.Services;

import com.example.proj.enteties.Abonnement;
import com.example.proj.reposetories.AbonnementReposetory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AbonnementServiceImp implements AbonnementService{



   private final AbonnementReposetory abonnementReposetory;
    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementReposetory.save(abonnement);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        return abonnementReposetory.save(abonnement);
    }

    @Override
    public List<Abonnement> findAll() {
        return (List<Abonnement>) abonnementReposetory.findAll();
    }

    @Override
    public Abonnement findById(long numAbon) {
        return abonnementReposetory.findById(numAbon).orElse(null);
    }

    @Override
    public void delete(long numAbon) {
        abonnementReposetory.deleteById(numAbon);

    }
}
