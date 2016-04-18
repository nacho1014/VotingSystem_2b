package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import es.uniovi.asw.model.Constituency;
import es.uniovi.asw.model.PollingPlace;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.parser.CheckFailsRegion;
import es.uniovi.asw.parser.RRegionExcel;

public class CheckFailsRegionTest {

	@Test
	public void testNombre() {
		List<Region> regiones = new RRegionExcel().readFile("src/test/resources/testRegionNombre.xlsx");
		assertEquals(3, regiones.size());
		assertTrue(CheckFailsRegion.comprobarFallosNombre(regiones.get(0)));
		assertFalse(CheckFailsRegion.comprobarFallosNombre(regiones.get(1)));
		assertTrue(CheckFailsRegion.comprobarFallosNombre(regiones.get(2)));
	}
	
	@Test
	public void testCircunscripcion() {
		List<Region> regiones = new RRegionExcel().readFile("src/test/resources/testRegionCircunscripcion.xlsx");
		assertEquals(3, regiones.size());
		assertTrue(CheckFailsRegion.comprobarFallosConstituency(regiones.get(0)));
		assertTrue(CheckFailsRegion.comprobarFallosConstituency(regiones.get(1)));
		assertFalse(CheckFailsRegion.comprobarFallosConstituency(regiones.get(2)));
	}
	
	@Test
	public void testPollingPlace(){
		List<Region> regiones = new RRegionExcel().readFile("src/test/resources/testRegionColegio.xlsx");
		assertEquals(3, regiones.size());
		assertFalse(CheckFailsRegion.comprobarFallosPollingPlace(regiones.get(0)));
		assertFalse(CheckFailsRegion.comprobarFallosPollingPlace(regiones.get(1)));
		assertTrue(CheckFailsRegion.comprobarFallosPollingPlace(regiones.get(2)));
	}

}
