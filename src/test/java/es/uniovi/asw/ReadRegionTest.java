package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import es.uniovi.asw.parser.RRegionExcel;
import es.uniovi.asw.model.Constituency;
import es.uniovi.asw.model.PollingPlace;
import es.uniovi.asw.model.Region;

public class ReadRegionTest {

	@Test
	public void test() {
		List<Region> regiones = new RRegionExcel().readFile("src/test/resources/testRegion.xlsx");
		for(Region r:regiones){
			System.out.println(r.getName());
			Set<Constituency> constituencies = r.getConstituencies();
			for(Constituency c:constituencies){
				System.out.println(c.getName());
				Set<PollingPlace> pollingPlaces = c.getPollingPlaces();
				for(PollingPlace p:pollingPlaces){
					System.out.println(p.getId());
				}
			}

		}
	}

}
