package es.uniovi.asw.presentation;

import es.uniovi.asw.model.Referendum;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 * Created by ignaciofernandezalvarez on 14/4/16.
 */
@Component("beanReferendum")
@Scope("request")
public class BeanReferendum {


    private Referendum referendum;




    @PostConstruct
    public void init(){

       referendum = (Referendum) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
                .get("eleccion");
        System.out.println(referendum);

    }

    public Referendum getReferendum() {
        return referendum;
    }

    public void setReferendum(Referendum referendum) {
        this.referendum = referendum;
    }
}
