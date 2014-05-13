package pl.edu.swsim.simon_wieczorek.testy;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import pl.edu.swsim.simon_wieczorek.*;


import java.util.Map;

import org.hibernate.AssertionFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class kod_pocztTest {
	
	  @Test
	  public void testKodPoczt(){
		  Kod_Poczt kod = new Kod_Poczt();
		  ArrayList<Kod_Poczt> kody = new ArrayList<Kod_Poczt>();
		  
		  kody.add(new Kod_Poczt("41-922", "Radzionków"));
		  kody.add(new Kod_Poczt("42-960", "Tarnowskie Góry"));
		  kody.add(new Kod_Poczt("43-221", "Poznañ"));
		  kody.add(new Kod_Poczt("43-121", "œæ¹Ÿæ³óñê¿"));
		  kody.add(new Kod_Poczt("43-321", "Kraków"));
		  
		  Kod_PocztDAOImp kodyImp = new Kod_PocztDAOImp();
		  for (Kod_Poczt kk : kody){
			  kodyImp.add(kk);
		  }
	
		  //Test Nazwa Miejscowosci
		  for(Kod_Poczt mapa : kody){
			  assertEquals(mapa.getNazwa_miejscowosci(), kodyImp.getMiejscowosc(mapa.getNazwa_miejscowosci()).getNazwa_miejscowosci());
		  }
		  
		  //Test kod pocztowy
		  for(Kod_Poczt mapa : kody){
			  assertEquals(mapa.getKod_poczt(), kodyImp.getZip(mapa.getKod_poczt()).getKod_poczt());
		  }
		  
		  //Czyszczenie testownia danych
		  for(Kod_Poczt mapa : kody){
			  kodyImp.delete(kodyImp.getZip(mapa.getKod_poczt()).getKod_poczt_id());
		  }		  
		  
	  }
}
	

