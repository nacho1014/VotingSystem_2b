package es.uniovi.asw.presentation;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    }

    public void votar() {






        Map<String, Object> session = FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap();
        Voter v = (Voter) session.get("LOGGEDIN_VOTER");

        VoteReferendum voteReferendum = Repository.voteR.findVoteReferendumByElectionAndPollingPlace(referendum, v.getPollingPlace());

        System.out.println(voteReferendum);

        if (voteReferendum == null) {


            voteReferendum = new VoteReferendum();
            voteReferendum.setElection(referendum);
            voteReferendum.setPollingPlace(v.getPollingPlace());


        }

        if ("Si".equals(selectedValue)) {


            voteReferendum.setYeses(voteReferendum.getYeses() + 1);

        } else {
            voteReferendum.setNoes(voteReferendum.getNoes() + 1);

        }

        if (hasAlreadyVoted(v, referendum)) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ya ha votado"));
            return;
        }
        System.out.println(v);


        Repository.voteR.save(voteReferendum);


        saveTurnout(v);

    }

    private void saveTurnout(Voter v) {
        referendum = (Referendum) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .get("eleccion");
        Turnout turnout = new Turnout();
        turnout.setElection(referendum);
        turnout.setVoter(v);
        Repository.turnoutR.merge(turnout);
    }


    private boolean hasAlreadyVoted(Voter v, Election election) {


        Turnout t = Repository.turnoutR.findByVoterAndElection(v, election);

        if (t == null) {

            return true;
        }
        return false;

    }

    public Referendum getReferendum() {
        return referendum;
    }

    public void setReferendum(Referendum referendum) {
        this.referendum = referendum;
    }
}
