package pl.edu.swsim.simon_wieczorek.testy;

import java.util.ArrayList;

import pl.edu.swsim.simon_wieczorek.*;

import org.hibernate.Session;
import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ulicaTest{
	
	ArrayList<Ulica> ulica;
	Kod_PocztDAOImp kodImp;
	UlicaDAOImp ulicaImp;
	
	public ulicaTest(){
		//Aby test dzia�a nale�y mie� dodany kod pocztowy 
		ulica = new ArrayList<Ulica>();
		kodImp = new Kod_PocztDAOImp();
		ulica.add(new Ulica("Karawan�w 82", kodImp.getMiejscowosc("Tarnowskie G�ry")));
		ulica.add(new Ulica("M�czenik�w O�wie�cimia 83/1", kodImp.getMiejscowosc("Tarnowskie G�ry")));
		ulica.add(new Ulica("Kalwari 2A", kodImp.getMiejscowosc("Tarnowskie G�ry")));
		ulica.add(new Ulica("Drogowskaz�w 1/1", kodImp.getMiejscowosc("Tarnowskie G�ry")));
		ulicaImp = new UlicaDAOImp();
	}
	
	@Test
	public void addTest(){		
		
		for(Ulica ulicaa : ulica ){
			ulicaImp.add(ulicaa);
		}
		
		assertEquals(ulicaImp.get().size(), 4);		
	}	
	
	@Test
	public void getUlicaTest(){
		//Poprawno�� dodania ulicy
		for(Ulica ulicaa : ulica){
			assertEquals(ulicaa.getNazwa_ulicy(), ulicaImp.getUlica(ulicaa.getNazwa_ulicy()).getNazwa_ulicy());
		}
	}
	

	@Test
	public void deleteTest(){
		
		//Czy�czenie po te�cie.
		for(Ulica ulicaa : ulica){
			ulicaImp.delete(ulicaImp.getUlica(ulicaa.getNazwa_ulicy()).getUlica_id());
		}
	
		for(Ulica ulicaa : ulica){
			assertEquals(0, ulicaImp.get(ulicaa.getNazwa_ulicy()).size());
		}
	
	}
	

		
}