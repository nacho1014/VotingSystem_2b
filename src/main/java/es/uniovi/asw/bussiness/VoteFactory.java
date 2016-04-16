package es.uniovi.asw.bussiness;

import es.uniovi.asw.model.Referendum;
import es.uniovi.asw.model.Voter;

/**
 * Created by ignaciofernandezalvarez on 16/4/16.
 */
public interface VoteFactory {


    boolean voteInReferendum(Referendum referendum, String selectedValue, Voter v);

}
