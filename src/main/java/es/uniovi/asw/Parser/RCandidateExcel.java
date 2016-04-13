package es.uniovi.asw.Parser;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Candidate;
import es.uniovi.asw.model.Candidature;


public class RCandidateExcel implements ReadCandidates{

	@Override
	public List<Candidate> readFile(String path) {
		XSSFWorkbook wb;
		XSSFSheet sheet;
		Iterator<Row> rows;
		Row row = null;
		Candidate candidate;
		
		List<Candidate> candidatos = new ArrayList<Candidate>();
		
		try {

			wb = new XSSFWorkbook(new File(path));
			System.out.println("Leyendo fichero " + path);
			sheet = wb.getSheetAt(0);
			rows = sheet.iterator();
				
			//First line (headers in excel file)
			rows.next();
				
			while (rows.hasNext()) {
				row = rows.next();
					
				candidate = new Candidate();
				candidate.setName(row.getCell(0).toString());
				candidate.setCandidature((Candidature) row.getCell(1));
				candidate.setDNI(row.getCell(2).toString());
				
				//Row empty, without cells
				if (!candidate.isEmpty())
					candidatos.add(candidate);
					
			}
								
		} catch (InvalidFormatException e) {
			System.out.println("El fichero no es un .xlsx");
		} catch (Exception e) {
			String[] fileName = path.split("/");
			System.out.println("El fichero " + fileName[fileName.length - 1] + " no existe");
		}
		
		return candidatos;
	}
}
