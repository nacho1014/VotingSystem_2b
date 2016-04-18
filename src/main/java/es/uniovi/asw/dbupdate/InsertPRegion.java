package es.uniovi.asw.dbupdate;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Constituency;
import es.uniovi.asw.model.PollingPlace;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.parser.CheckFailsCandidate;
import es.uniovi.asw.parser.CheckFailsRegion;

public class InsertPRegion implements InsertRegion{

	@Override
	public List<Region> insert(List<Region> regiones, String path) {
		CheckFailsCandidate.file=path;
		List<Region> regionesInsertadas = new ArrayList<Region>();
		for(Region r:regiones){
			if(CheckFailsRegion.check(r)){
				
				Repository.regionR.save(r);
				regionesInsertadas.add(r);
				
				for(Constituency c:r.getConstituencies()){
					c.setRegion(r);
					Repository.constituencyR.save(c);
					
					for(PollingPlace p:c.getPollingPlaces()){
						p.setConstituency(c);
						Repository.pollingPlaceR.save(p);
					}
				}
				
			}
		}
		System.out.println(regiones.size() + " filas leídas del fichero");
		
		if (regiones.size() > regionesInsertadas.size())
			System.out.println((regiones.size() - regionesInsertadas.size()) + " filas con errores en el fichero (ver fails.log para más información)");
		
		System.out.println("Se han registrado " + regionesInsertadas.size() + " regiones");
		
		return regionesInsertadas;
	}

}
