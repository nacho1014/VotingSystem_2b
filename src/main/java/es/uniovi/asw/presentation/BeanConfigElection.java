package es.uniovi.asw.presentation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.Referendum;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;



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
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @PostConstruct
    void init() {

        System.out.println("BeanControllerElecion creado");
        //selectedValue="abierta";

    }



    public UploadedFile getFile() {


        System.out.println("getter");
        return file;
    }

    public void setFile(UploadedFile file) {
        System.out.println("setter");
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

    public void upload() {
        System.out.println("uplodeo");        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    public void creaReferendum(){

        System.out.println("al menos priqui entro");
        System.out.println("name " + electionName);
        System.out.println("date init" + initialDate);
        System.out.println("date expire" + expireDate);
        System.out.println("instructions " +instructions);
        System.out.println("question" +question);


        // 04/15/2016 11:25 AM
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");

        try {

            Date initialDated = formatter.parse(initialDate);
            Date expireDated = formatter.parse(expireDate);

            Referendum referendum = new Referendum();
            referendum.setStartDate(initialDated);
            referendum.setExpiryDate(expireDated);
            referendum.setInstructions(instructions);
            referendum.setName(electionName);
            referendum.setQuestion(question);
            referendum.setNumChoices(1);

            Repository.electionR.save(referendum);


            System.out.println("everything wentWell");



        } catch (ParseException e) {
            e.printStackTrace();
        }



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
