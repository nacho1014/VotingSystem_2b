package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.Parser.RRegionExcel;
import es.uniovi.asw.model.Region;

public class ReadRegionTest {

	@Test
	public void test() {
		List<Region> regiones = new RRegionExcel().readFile("src/test/resources/testRegion.xlsx");
		for(Region r:regiones){
			System.out.println(r.getName());
		}
	}

}
