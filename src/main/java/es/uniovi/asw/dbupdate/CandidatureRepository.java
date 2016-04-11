package es.uniovi.asw.dbupdate;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Candidature;

/**
 * Created by ignaciofernandezalvarez on 9/4/16.
 */
public interface CandidatureRepository extends CrudRepository<Candidature,Long> {

    Candidature findByName(String name);



}
