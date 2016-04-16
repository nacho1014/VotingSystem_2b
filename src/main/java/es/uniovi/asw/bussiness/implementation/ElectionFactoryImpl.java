package es.uniovi.asw.bussiness.implementation;

import es.uniovi.asw.bussiness.ElectionFactory;
import es.uniovi.asw.bussiness.implementation.classes.CreateReferendum;
import es.uniovi.asw.model.Referendum;

/**
 * Created by ignaciofernandezalvarez on 16/4/16.
 */
public class ElectionFactoryImpl implements ElectionFactory {


    @Override
    public boolean createReferendum(Referendum referendum) {

        new CreateReferendum(referendum).create();

        return false;
    }

    @Override
    public boolean createCerradas() {
        return false;
    }

    @Override
    public boolean createAbiertas() {
        return false;
    }
}
