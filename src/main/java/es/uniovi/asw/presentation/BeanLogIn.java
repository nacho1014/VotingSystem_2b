package es.uniovi.asw.presentation;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by Ignacio Fernandez on 11/04/2016.
 */
@Component("beanLogIn")
@Scope("request")
public class BeanLogIn {


    public String user;
    public String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String login() {


        System.out.println(user + " pass: " + password);

        if ("admin".equals(getUser()) && "admin".equals(getPassword())) {
            return "exito";
        } else {

            Voter voter = Repository.voterR.findByNif(user);

            if (voter == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "No existe el usuario o la contraseña es erronea"));
                return "fallo";
            }

            Election election = Repository.electionR.findActual();

            if(hasAlreadyVoted(voter,election)){

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ya has votado caradura"));

                return "fallo";

            }

            if (voter.getPassword().equals(password)) {
                putUserInSession(voter);
                return reditectToElectionType(election);

            } else {
                password = "";
            }

        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "No existe el usuario o la contraseña es erronea"));
        return "fallo";
    }

    private void putUserInSession(Voter user) {
        Map<String, Object> session = FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap();
        session.put("LOGGEDIN_VOTER", user);
    }


    private boolean hasAlreadyVoted(Voter v, Election election) {


        Turnout t = Repository.turnoutR.findByVoterAndElection(v, election);

        if (t == null) {

            return false;
        }


        return true;

    }


    private String reditectToElectionType(Election type) {

        if (type == null) {
            return "fallo";
        } else {

            FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                    .put("eleccion", type);
            if (type instanceof Referendum)
                return "referendum";
            else if (type instanceof ClosedList)
                return "cerrada";
            else return "abierta";
        }

    }

}
