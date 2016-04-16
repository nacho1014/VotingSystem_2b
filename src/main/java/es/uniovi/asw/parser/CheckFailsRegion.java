package es.uniovi.asw.parser;

import es.uniovi.asw.model.Constituency;
import es.uniovi.asw.model.PollingPlace;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.reportwriter.WReportR;
import es.uniovi.asw.reportwriter.WriteReport;

public class CheckFailsRegion {

	private static final WriteReport reporter = new WReportR();
	public static String file;
	
	public static boolean comprobarFallosNombre(Region r){
		if (r.getName() == null || r.getName().equals("")) {
			reporter.report(file + " Nombre vacío --- ---");
			return false;
		}
		return true;
	}
	
	public static boolean comprobarFallosConstituency(Constituency c){
		if (c.getName() == null || c.getName().equals("")) {
			reporter.report(file + " Nombre vacío --- ---");
			return false;
		}
		return true;
	}
	
	public static boolean comprobarFallosPollingPlace(PollingPlace p){
		if (p.getId() == null)  {
			reporter.report(file + " PollingPlace vacío --- ---");
			return false;
		} else if (p.getId()<0) {
			reporter.report(file + " PollingPlace no válido --- " + p.getId() + " ---");
			return false;
		}
		return true;
	}
}
