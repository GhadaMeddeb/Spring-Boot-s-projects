package com.example.proj.Services;

import com.example.proj.enteties.Piste;
import com.example.proj.reposetories.PisteReposetory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PisteServiceImpl implements PisteService{


    public final PisteReposetory pisteReposetory;

    @Override
   public Piste addPiste(Piste piste) {


        return pisteReposetory.save(piste);
   }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteReposetory.save(piste);
    }

    @Override
    public List<Piste> findAll() {
        return (List<Piste>) pisteReposetory.findAll();
    }

    @Override
    public Piste findById(long numPiste) {
        return pisteReposetory.findById(numPiste).orElse(null);
      //  return pisteReposetory.findById(numPiste).orElseThrow() -> new IllegalAccessError()
    }

    @Override
    public void delete(long numPiste) {
        pisteReposetory.deleteById(numPiste);

    }
}
