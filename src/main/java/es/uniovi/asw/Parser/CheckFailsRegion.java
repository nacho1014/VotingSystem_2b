package es.uniovi.asw.Parser;

import es.uniovi.asw.model.Constituency;
import es.uniovi.asw.model.PollingPlace;
import es.uniovi.asw.model.Region;

public class CheckFailsRegion {

	public static boolean comprobarFallosNombre(Region r){
		if (r.getName() == null || r.getName().equals("")) {
			System.out.println(" Nombre vacío --- ---");
			return false;
		}
		return true;
	}
	
	public static boolean comprobarFallosConstituency(Constituency c){
		if (c.getName() == null || c.getName().equals("")) {
			System.out.println(" Nombre vacío --- ---");
			return false;
		}
		return true;
	}
	
	public static boolean comprobarFallosPollingPlace(PollingPlace p){
		if (p.getId() == null)  {
			System.out.println(" PollingPlace vacío --- ---");
			return false;
		} else if (p.getId()<0) {
			System.out.println(" PollingPlace no válido --- " + p.getId() + " ---");
			return false;
		}
		return true;
	}
}
