package pl.edu.swsim.simon_wieczorek.testy;
import java.util.ArrayList;

import pl.edu.swsim.simon_wieczorek.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class magazynTest{
	
	ArrayList<Magazyn> magazynLista;
	UlicaDAOImp ulica;
	MagazynDAOImp magazyn;
	
	public magazynTest(){
		magazynLista = new ArrayList<Magazyn>();
		ulica = new UlicaDAOImp();
		magazyn = new MagazynDAOImp();
	}
	
	@Test
	public void addTest(){
		magazynLista.add(new Magazyn("Rolmopsy", ulica.getUlica("Kalwari 2A")));
		magazynLista.add(new Magazyn("Rolmopsy2", ulica.getUlica("Drogowskazów 1/1")));
		magazynLista.add(new Magazyn("Rolmopsy3", ulica.getUlica("Karawanów 82")));
		
		for(Magazyn magazynx : magazynLista){
			magazyn.add(magazynx);
		}

		for(Magazyn magazynx : magazynLista){
			assertEquals(magazynx.getNazwa_magazynu(), magazyn.getMagazynByNazwaMagazynu(magazynx.getNazwa_magazynu()).getNazwa_magazynu());
		}				
	}
	
	@Test
	public void updateTest(){
		Magazyn m = new Magazyn("Rolmopsyzx", ulica.getUlica("Kalwari 2A"));
		m.setMagazyn_id(magazyn.getMagazynByNazwaMagazynu("Rolmopsy").getMagazyn_id());
		
		magazyn.update(m);
		assertEquals(m.getNazwa_magazynu(), magazyn.getMagazynByNazwaMagazynu("Rolmopsyzx").getNazwa_magazynu());
	}
	
	@Test
	public void deleteTest(){
		
		//Czyœczenie po teœcie.
		for(Magazyn magazynx : magazynLista){
			magazyn.delete(magazyn.getMagazynByNazwaMagazynu(magazynx.getNazwa_magazynu()).getMagazyn_id());
		}
	
		for(Magazyn magazynx : magazynLista){
			assertEquals(0, magazyn.get().size());
		}
	
	}
	
}