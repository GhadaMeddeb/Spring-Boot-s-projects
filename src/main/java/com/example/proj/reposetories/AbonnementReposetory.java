package com.example.proj.reposetories;

import com.example.proj.enteties.Abonnement;
import com.example.proj.enteties.enums.TypeAbonnement;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AbonnementReposetory extends CrudRepository<Abonnement,Long> {
   // List<Abonnement> findByTypeAbon(TypeAbonnement typeAbon);
   // List<Abonnement> findByTypeAbonAndDateDebutBetween(TypeAbonnement typeAbon, Date dateDebut, Date dateDebut2);
}
