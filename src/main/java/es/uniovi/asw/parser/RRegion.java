package es.uniovi.asw.parser;

import java.util.List;

import es.uniovi.asw.dbupdate.InsertRRegion;
import es.uniovi.asw.dbupdate.InsertRegion;
import es.uniovi.asw.model.Region;

public abstract class RRegion implements ReadRegion{

	private static InsertRegion insertDB = new InsertRRegion();
	
	@Override
	public List<Region> read(String path) {
		
		List<Region> regiones = readFile(path);
		
		List<Region> regionesInsertadas = insertDB.insert(regiones, path);
		
		return regionesInsertadas;
	}
	
	abstract List<Region> readFile(String path);
}
