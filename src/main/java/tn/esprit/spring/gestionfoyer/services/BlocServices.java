package tn.esprit.spring.gestionfoyer.services;

import tn.esprit.spring.gestionfoyer.entities.Bloc;

import java.util.List;

public interface BlocServices {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc (Bloc bloc);

    Bloc addBloc (Bloc bloc);

    Bloc retrieveBloc (long idBloc);

    void removeBloc (long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambres, long idBloc);
}
