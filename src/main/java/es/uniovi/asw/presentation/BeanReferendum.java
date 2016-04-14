package es.uniovi.asw.presentation;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ignaciofernandezalvarez on 14/4/16.
 */
@Component("beanReferendum")
@Scope("view")
public class BeanReferendum {


    private Referendum referendum;
    private String selectedValue;


    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public List<String> getValues() {
        return Arrays.asList("Si", "No");
    }

    @PostConstruct
    public void init() {

        referendum = (Referendum) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .get("eleccion");
        System.out.println(referendum);

    }

    public void votar() {




       // Buscamos el referendum   // hacemos un region consituencia polling place
        PollingPlace pp = new PollingPlace();
        pp.setId(1L);
        Constituency c = new Constituency();
        c.setName("La corredoria");
        Region r = new Region();
        r.setName("Oviedo");
        c.setRegion(r);
        pp.setConstituency(c);

        //GUARDAR LA REGION
        //Guardar
        //GUARDAR EL POLLING place
        VoteReferendum  voteReferendum  = Repository.voteR.findVoteReferendumByElectionAndPollingPlace(referendum,pp);

        if(voteReferendum==null){

            voteReferendum = new VoteReferendum();
            voteReferendum.setElection(referendum);
            voteReferendum.setPollingPlace(pp);


        }

        System.out.println(selectedValue);
        if("Si".equals(selectedValue)){


            voteReferendum.setYeses(voteReferendum.getYeses()+1);

        }
        else {
            voteReferendum.setNoes(voteReferendum.getNoes()+1);

        }

        Repository.voteR.save(voteReferendum);

    }

    public Referendum getReferendum() {
        return referendum;
    }

    public void setReferendum(Referendum referendum) {
        this.referendum = referendum;
    }
}
