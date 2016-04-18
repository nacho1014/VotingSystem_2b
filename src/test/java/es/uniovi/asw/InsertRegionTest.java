package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import es.uniovi.asw.dbupdate.RepositoryConfiguration;
import es.uniovi.asw.model.Region;
import es.uniovi.asw.parser.RRegionExcel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RepositoryConfiguration.class})

public class InsertRegionTest {

	@Test
	public void test() {
		List<Region> regiones = new RRegionExcel().read("src/test/resources/testRegionColegio.xlsx");
		assertEquals(1,regiones.size());
	}

}
