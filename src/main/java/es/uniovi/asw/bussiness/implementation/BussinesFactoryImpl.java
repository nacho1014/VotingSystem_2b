package es.uniovi.asw.bussiness.implementation;

import es.uniovi.asw.bussiness.BussinesFactory;
import es.uniovi.asw.bussiness.ElectionFactory;
import es.uniovi.asw.bussiness.VoteFactory;
import es.uniovi.asw.bussiness.VoterFactory;

/**
 * Created by ignaciofernandezalvarez on 14/4/16.
 */
public class BussinesFactoryImpl implements BussinesFactory {


    @Override
    public ElectionFactory createElectionFactory() {
        return new ElectionFactoryImpl();
    }

    @Override
    public VoteFactory createVoteFactory() {
        return new VoteFactoryImpl();
    }

    @Override
    public VoterFactory createVoterFactory() {
        return new VoterFactoryImpl();
    }
}
