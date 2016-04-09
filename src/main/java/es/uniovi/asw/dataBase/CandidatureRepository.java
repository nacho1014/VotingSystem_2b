package es.uniovi.asw.dataBase;

import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by ignaciofernandezalvarez on 9/4/16.
 */
public interface CandidatureRepository extends CrudRepository<Candidature,Long> {

    Candidature findByName(String name);



}
