package com.example.proj.Services;

import com.example.proj.enteties.Cours;
import com.example.proj.enteties.Inscription;
import com.example.proj.enteties.Piste;
import com.example.proj.enteties.Skieur;
import com.example.proj.reposetories.CoursReposetory;
import com.example.proj.reposetories.InscriptionReposetory;
import com.example.proj.reposetories.PisteReposetory;
import com.example.proj.reposetories.SkieurReposetory;
import io.micrometer.common.util.internal.logging.InternalLogger;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SkieurServiceImp implements SkieurService {



    private final SkieurReposetory skieurReposetory;
    private final PisteReposetory pisteReposetory;
    private final CoursReposetory coursReposetory;
    private final InscriptionReposetory inscriptionReposetory;
    @Override
    public Skieur addSkieur(Skieur skieur) {


        return skieurReposetory.save(skieur)  ;
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurReposetory.save(skieur);
    }

    @Override
    public List<Skieur> findAll() {
        return (List<Skieur>) skieurReposetory.findAll();
    }

    @Override
    public Skieur findById(long numSkieur) {
        return skieurReposetory.findById(numSkieur).orElse(null);
    }

    @Override
    public void delete(long numSkieur) {
        skieurReposetory.deleteById(numSkieur);
    }


    @Transactional
    @Override
    public Skieur assignSkieurToPiste(long numSkieur, long numPiste) {

        Skieur skieur = skieurReposetory.findById(numSkieur).orElse(null);
        Piste piste = pisteReposetory.findById(numPiste).orElse(null);

        //jebna les pistes l9dom w zedna lil liste jdida
        skieur.getSetPiste().add(piste);

        //les 3 lignes y3awthou ligne eli 9bal
        //Set<Piste> pisteSet = skieur.getPisteSet();
        //pisteSet.add(piste);
        //skieur.setPisteSet(pisteSet);


        //@transactional t3aweth return skieurRepo.save(skieur);
        return skieur;
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, long numCours) {


                   //* ajout de l'abonnement
                   // *bech naamlou verif eli abonnement mawjoud wale
        Assert.notNull(skieur.getAbonnement(), "abonnement cannot be null");

        skieurReposetory.save(skieur);

        Inscription inscription = skieur.getSetInscription()
               .stream().findFirst().orElseThrow( () ->
               new IllegalArgumentException("skieur must have at least one inscription"));

        inscription.setSkieur(skieur);

      Cours cours = coursReposetory.findById(numCours).orElseThrow( () ->
               new IllegalArgumentException("No course found with this id "+ numCours));

         inscription.setCours(cours);

         inscriptionReposetory.save(inscription);


        return skieur;
    }



    //@Scheduled(fixedRate = 60000)
    @Scheduled(fixedDelay = 60000)  //  on doit ajouter  @enableScheduling fl classe main (projapplication) pour l'activer
    public void testScheduler(){


        log.info("  test   Scheduler") ;

    }
  //  @Scheduled(cron = 1000)  //
    public void testSchedulerCron(){


        log.info("  test   Scheduler") ;

    }

}
