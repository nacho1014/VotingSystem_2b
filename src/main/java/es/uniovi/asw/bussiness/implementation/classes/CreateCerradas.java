package es.uniovi.asw.bussiness.implementation.classes;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.Candidature;
import es.uniovi.asw.model.ClosedList;
import es.uniovi.asw.parser.RCandidatureExcel;
import es.uniovi.asw.parser.ReadCandidature;

import java.util.List;

/**
 * Created by ignaciofernandezalvarez on 20/4/16.
 */
public class CreateCerradas {

    private ClosedList closedList;


    public CreateCerradas(ClosedList closedList) {

        this.closedList = closedList;

    }


    public boolean create() {

        boolean result = true;

        try {

            ReadCandidature readCandidature = new RCandidatureExcel();

            List<Candidature> candidatures = readCandidature.read("src/main/test/resourceselecciones.xlsx");


            Repository.electionR.save(closedList);


            for (Candidature candidature : candidatures) {

                candidature.addElection(closedList);
                Repository.candidatureR.save(candidature);

            }


        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
        return true;

    }
}
