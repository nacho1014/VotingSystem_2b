package es.uniovi.asw.bussiness.implementation.classes;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.OpenList;
import es.uniovi.asw.parser.RCandidateExcel;

import java.util.List;

/**
 * Created by ignaciofernandezalvarez on 20/4/16.
 */
public class CreateAbiertas {
    private OpenList openList;

    public CreateAbiertas(OpenList openList) {
        this.openList = openList;
    }

    public boolean create() {


        try {

            List<Candidate> candidatos = new RCandidateExcel().readFile("src/main/test/resourceselecciones.xlsx");

            for (Candidate candidate : candidatos) {
                openList.addCandidate(candidate);
            }
            Repository.electionR.save(openList);


        } catch (Exception e) {
            return false;
        }


        return true;


    }
}


