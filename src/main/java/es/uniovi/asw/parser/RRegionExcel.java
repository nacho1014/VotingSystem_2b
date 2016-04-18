package es.uniovi.asw.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Constituency;
import es.uniovi.asw.model.PollingPlace;
import es.uniovi.asw.model.Region;


public class RRegionExcel {

		public List<Region> readFile(String path){
			XSSFWorkbook wb;
			XSSFSheet sheet;
			Iterator<Row> rows;
			Row row = null;
			Region region;
			
			List<Region> regiones = new ArrayList<Region>();
			
			try {

				wb = new XSSFWorkbook(new File(path));
				System.out.println("Leyendo fichero " + path);
				sheet = wb.getSheetAt(0);
				rows = sheet.iterator();
					
				//First line (headers in excel file)
				rows.next();
					
				while (rows.hasNext()) {
					row = rows.next();
						
					region = new Region();
					region.setName(row.getCell(0) != null ? row.getCell(0).toString():null);
					
					Constituency cons = new Constituency();
					cons.setName(row.getCell(1)!=null?row.getCell(1).toString():null);
					
					PollingPlace p = new PollingPlace();
					
					//Row empty, without cells
					if (row.getCell(0)!=null || row.getCell(1)!=null || row.getCell(2)!=null){
						p.setConstituency(cons);
						cons.setRegion(region);
						Double id = row.getCell(2)!=null?Double.parseDouble(row.getCell(2).toString()):null;
						if(id!=null){
							p.setId(id.longValue());
						}
						regiones.add(region);
						
					}
						
				}
									
			} catch (InvalidFormatException e) {
				System.out.println("El fichero no es un .xlsx");
			} catch (Exception e) {
				String[] fileName = path.split("/");
				System.out.println("El fichero " + fileName[fileName.length - 1] + " no existe");
			}
			
			return regiones;
		}
}
