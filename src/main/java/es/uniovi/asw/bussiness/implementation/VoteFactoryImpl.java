package es.uniovi.asw.bussiness.implementation;

import es.uniovi.asw.bussiness.VoteFactory;
import es.uniovi.asw.bussiness.implementation.classes.VoteInReferendum;
import es.uniovi.asw.model.Referendum;
import es.uniovi.asw.model.Voter;

/**
 * Created by ignaciofernandezalvarez on 16/4/16.
 */
public class VoteFactoryImpl implements VoteFactory {


    @Override
    public boolean voteInReferendum(Referendum referendum,String selectedValue, Voter v) {
        return new VoteInReferendum(referendum,selectedValue,v).vote();
    }
}
