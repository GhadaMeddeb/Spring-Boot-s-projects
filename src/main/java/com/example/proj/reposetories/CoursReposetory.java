package com.example.proj.reposetories;

import com.example.proj.enteties.Cours;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursReposetory extends CrudRepository<Cours,Long> {

  //  @Query(value = "SELECT * \n" +
         //   "FROM cours c \n" +
        //    "JOIN moniteur_cour_set mc ON c.num_cours = mc.cour_set_num_cours \n" +
         //   "JOIN moniteur m ON m.num_moniteur=mc.moniteur_num_moniteur \n" +
         //   "\n" +
         //   "WHERE m.nomm=?1 and m.prenomm= :prenomM",    nativeQuery = true)
   // List<Cours>findByMoniteurNomMSQL(String nomM,@Param("prenomM") String prenomM);



   // @Query( "SELECT c  " +
    //        "FROM Cours c " +
     //       "JOIN Moniteur m ON c member m.courSet " +
     //       "WHERE m.nomM=?1 and m.prenomM= :prenomM")
   // List<Cours>findByMoniteurNomM(String nomM,@Param("prenomM") String prenomM);

}
