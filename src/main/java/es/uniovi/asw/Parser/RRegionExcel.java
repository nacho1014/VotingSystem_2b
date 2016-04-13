package es.uniovi.asw.Parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Region;


public class RRegionExcel {

		public List<Region> readFile(String path) {
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
					region.setName(row.getCell(0).toString());
					
					//Row empty, without cells
					if (!region.isEmpty())
						regiones.add(region);
						
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
