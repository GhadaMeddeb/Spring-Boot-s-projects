package com.example.proj.Services;

import com.example.proj.enteties.Cours;
import com.example.proj.reposetories.CoursReposetory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursServiceImp implements CoursService{


    private final CoursReposetory coursReposetory;


    @Override
    public Cours addCours(Cours cours) {
        return coursReposetory.save(cours) ;
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursReposetory.save(cours);
    }

    @Override
    public List<Cours> findAll() {
        return (List<Cours>) coursReposetory.findAll();
    }

    @Override
    public Cours findById(long numCours) {
        return coursReposetory.findById(numCours).orElse(null);
    }

    @Override
    public void delete(long numCours) {
        coursReposetory.deleteById(numCours);

    }
}
