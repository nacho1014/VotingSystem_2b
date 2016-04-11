package es.uniovi.asw.presentation;

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
        }

        System.out.println("deberia haber cambiado pero no lo he echo");
        return "fallo";
    }

}
