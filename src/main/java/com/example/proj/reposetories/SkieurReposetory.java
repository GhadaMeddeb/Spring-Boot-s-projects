package com.example.proj.reposetories;

import com.example.proj.enteties.Skieur;
import com.example.proj.enteties.enums.Couleur;
import com.example.proj.enteties.enums.Support;
import com.example.proj.enteties.enums.TypeAbonnement;
import com.example.proj.enteties.enums.TypeCours;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkieurReposetory extends CrudRepository<Skieur,Long> {

       List<Skieur>findByAbonnementTypeAbon(TypeAbonnement abonnement_typeabonnement);

        //List<Skieur>findByAbonnementTypeAbon(TypeAbonnement abonnement_typeAbon);

    // List<Skieur> findByNomSAndAbonnement_TypeAbonAndSetPisteCouleur(String nomS, TypeAbonnement abonnement_typeAbon, Couleur setPiste_couleur);

      //  List<Skieur>findByAbonnementTypeAbonAndSetPisteCouleurAndSetInscriptionCoursTypeCoursAndSetInscriptionCoursSupport(TypeAbonnement abonnement_typeAbon, Couleur setPiste_couleur, TypeCours setInscription_cours_typeCours, Support setInscription_cours_support);

  //  @Query("SELECT s FROM Skieur s order by s.setPiste.size")

    // List<Skieur>getSkieurOrderByPisteNumber();
}
