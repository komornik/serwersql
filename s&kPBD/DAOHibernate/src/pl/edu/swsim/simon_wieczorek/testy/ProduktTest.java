package pl.edu.swsim.simon_wieczorek.testy;

import static org.junit.Assert.*;
import java.sql.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.edu.swsim.simon_wieczorek.*;

public class ProduktTest {
	String tekst="";

	@Test
	public void test() {
		Produkt p;
		
		p= new Produkt ("pomidor", new Date(2014,05,17),"szt.",4.5);
		ProduktDAOImp produktDAO = new ProduktDAOImp();
		int size = produktDAO.getProdukt().size();
		try{
		produktDAO.add(p);
		}catch (Exception e){
		tekst=e.toString();	
		}
		System.out.println("B³¹d"+tekst);
		int size2= produktDAO.getProdukt().size();
		assertEquals("hahaha", size, size2); 
		produktDAO.delete(1);
		
		
	}
	
	@Test
	public void testPobierz(){
		Produkt p;
		ProduktDAOImp produktDAO = new ProduktDAOImp();
		produktDAO.getProdukt(1);
		
		
	
	}
	
	@Test
	public void testPobierzAll(){
		List<Produkt> p = null;
		ProduktDAOImp produktDAO = new ProduktDAOImp();
		try{
		p=produktDAO.getProdukt();
		}catch (Exception e){
			System.out.println("B³¹d Pobierania ca³ego "+ e.toString());
		}
	}

}
