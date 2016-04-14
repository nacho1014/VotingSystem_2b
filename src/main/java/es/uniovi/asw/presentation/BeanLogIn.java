package es.uniovi.asw.presentation;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.ClosedList;
import es.uniovi.asw.model.Election;
import es.uniovi.asw.model.Referendum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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

            //llamada a Voters para comprar

            //comprobamos la elección que hay ese día

            Election election = Repository.electionR.findActual();

            return reditectToElectionType(election);

        }

        
    }

    private String reditectToElectionType(Election type) {

        if (type == null) {
            return "fallo";
        } else if (type instanceof Referendum)
            return "referendum";
        else if (type instanceof ClosedList)
            return "cerrada";
        else return "abierta";

    }

}
