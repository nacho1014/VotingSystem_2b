package es.uniovi.asw.presentation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ignacio Fernandez on 11/04/2016.
 */
@Component("beanConfigElection")
@ViewScoped
public class BeanConfigElection implements Serializable {


    private String selectedValue ;
    private String[] values;
    private String choice;


    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @PostConstruct
    void init() {

        System.out.println("BeanControllerElecion creado");

    }


    public  void println(){

        System.out.println(choice);
        System.out.println("SAP");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this error is not ok...
        }


        System.out.println(selectedValue);

    }

    public boolean listasAbiertas(){

        return  "abierta".equals(selectedValue);
    }

    public boolean referendum(){

        return  "referendum".equals(selectedValue);
    }

    public boolean listasCerradas(){

        return  "cerrada".equals(selectedValue);
    }


    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
