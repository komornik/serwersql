package pl.edu.swsim.simon_wieczorek.testy;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.edu.swsim.simon_wieczorek.Faktura;
import pl.edu.swsim.simon_wieczorek.FakturaDAOImp;
import pl.edu.swsim.simon_wieczorek.Rabat;
import pl.edu.swsim.simon_wieczorek.RabatDAOImp;

public class FakturaTest {
	

	@Test
	public void test() {
		Faktura f;
		f= new Faktura("11/05/2014","sasagss", new Date(2014,06,13),1);
		FakturaDAOImp fakturaDAO = new FakturaDAOImp();
		
		fakturaDAO.add(f);
		//fakturaDAO.delete(1);
		//assertEquals("Test ", size1+1, size2);
		//System.out.print("size1 "+ size1 + " size2 "+ size2);
		
	}

}
