package es.uniovi.asw.presentation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ignaciofernandezalvarez on 16/4/16.
 */

@Component("beanPolling")
@Scope("view")
public class BeanPollingPlaces {

    public static boolean excelUploaded;

    public String configurePollingPlaces(){


        System.out.println("sii");
        return "exito";

    }

    public static boolean isExcelUploaded() {
        return excelUploaded;
    }

    public static void setExcelUploaded(boolean excelUploaded) {
        BeanPollingPlaces.excelUploaded = excelUploaded;
    }
}
