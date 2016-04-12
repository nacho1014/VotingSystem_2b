package es.uniovi.asw.presentation;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.parser.Part;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * Created by Ignacio Fernandez on 11/04/2016.
 */
@Component("beanConfigElection")
@Scope("view")

public class BeanConfigElection implements Serializable {


    private String selectedValue;
    private String[] values;


    private String electionName;
    private String initialDate;
    private String expireDate;
    private String instructions;
    private UploadedFile file;


    @PostConstruct
    void init() {

        System.out.println("BeanControllerElecion creado");
        //selectedValue="abierta";

    }



    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }


    public void println() {


        System.out.println("YIIIII");

    }

    public boolean listasAbiertas() {

        return "abierta".equals(selectedValue);
    }

    public boolean referendum() {

        return "referendum".equals(selectedValue);
    }

    public boolean listasCerradas() {

        return "cerrada".equals(selectedValue);
    }


    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    public List<String> getValues() {
        return Arrays.asList("abierta", "cerrada", "referendum");
    }

    public void setValues(String[] values) {
        this.values = values;
    }


    public String creaCerradas() {


        System.out.println("al menos priqui entro");
        System.out.println("name " + electionName);
        System.out.println("date init" + initialDate);
        System.out.println("date expire" + expireDate);
        System.out.println("instructions " +instructions);
        System.out.println("file" + file);


        return "exito";
    }

    public String creaAbiertas() {


        System.out.println("al menos priqui entro");
        System.out.println("name " + electionName);
        System.out.println("date init" + initialDate);
        System.out.println("date expire" + expireDate);
        System.out.println("instructions " +instructions);
        System.out.println("file" + file);


        return "exito";
    }


    public void handleFileUpload(FileUploadEvent event) {
        System.out.println("PASO");
        file = event.getFile();
        try {
            InputStream input = file.getInputstream();
            System.out.println(input.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        // ...
    }

    public String getElectionName() {
        return electionName;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }



}
