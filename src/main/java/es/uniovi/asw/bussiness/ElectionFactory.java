package es.uniovi.asw.bussiness;

import es.uniovi.asw.model.Referendum;

/**
 * Created by ignaciofernandezalvarez on 14/4/16.
 */
public interface ElectionFactory {


    boolean createReferendum(Referendum referendum);

    boolean createCerradas();

    boolean createAbiertas();




}
