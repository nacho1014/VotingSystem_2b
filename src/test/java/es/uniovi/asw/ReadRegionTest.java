package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import es.uniovi.asw.model.Constituency;
import es.uniovi.asw.model.PollingPlace;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.parser.RRegionExcel;

public class ReadRegionTest {

	@Test
	public void test() {
		List<Region> regiones = new RRegionExcel().readFile("src/test/resources/testRegion.xlsx");
		assertEquals("Asturias",regiones.get(0).getName());
		assertEquals("Madrid",regiones.get(1).getName());
		assertEquals("Extremadura",regiones.get(2).getName());

	}

}
