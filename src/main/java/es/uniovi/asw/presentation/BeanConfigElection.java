package es.uniovi.asw.presentation;

import es.uniovi.asw.dbupdate.Repository;
import es.uniovi.asw.model.Referendum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by Ignacio Fernandez on 11/04/2016.
 */
@Component("beanConfigElection")
@Scope("application")

public class BeanConfigElection implements Serializable {


    private String selectedValue;
    private String[] values;


    private String electionName;
    private String initialDate;
    private String expireDate;
    private String instructions;
    private File file;
    private String question;
    private boolean excel;
    private static boolean excelUploaded = false;


    private String url;


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


    public File getFile() {


        System.out.println("getter");
        return file;
    }

    public void setFile(File file) {
        System.out.println("setter");
        this.file = file;
    }


    public void println() {

        excelUploaded=false;


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
        System.out.println("instructions " + instructions);
        System.out.println("file" + file);


        return "exito";
    }


    public String creaAbiertas() {


        System.out.println("al menos priqui entro");
        System.out.println("name " + electionName);
        System.out.println("date init" + initialDate);
        System.out.println("date expire" + expireDate);
        System.out.println("instructions " + instructions);


        return "exito";
    }


    public void creaReferendum() {

        System.out.println("I try");
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
            //MENSAJE DE LOG
        }


    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public static boolean isExcelUploaded() {
        return excelUploaded;
    }

    public static void setExcelUploaded(boolean excelUploaded) {
        BeanConfigElection.excelUploaded = excelUploaded;
    }




}
