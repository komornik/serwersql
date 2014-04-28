package pl.edu.swsim.simon_wieczorek;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;



import org.hibernate.AssertionFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class testy {
	
	
	  public void testMultiplyException() {
		KlientDAOImp klientDAOImp = new KlientDAOImp();
	    Klient k = new Klient();
	    k.setImie("Krzysztof");
	    k.setNazwisko("Simon");
	    k.setNazwa_firmy("Jakaœ Nazwa");
	    k.setNip("6660110005");
	    k.setRegon("123456789");
	    k.setTelefon(321234565);
	    List<Klient> a= klientDAOImp.getKlient();
	    a.size();
	    klientDAOImp.add(k);
	    List<Klient> b= klientDAOImp.getKlient();
	    
	    assertEquals("Result",a.size()+1 ,b);
	  }
	  
	  @Test
	  public void testRabat(){
		  Rabat r = new Rabat();
		  r.setWysokosc(0.6);
		  RabatDAOImp tImp = new RabatDAOImp();
		  List<Rabat> r1= tImp.get();
		  tImp.add(r);
		  List<Rabat> r2 = tImp.get();
		  assertEquals("Test ", r1.size()+1, r2.size());
		  int id=-1;
		  for  (Rabat rabat : r2) {
			  System.out.println("rabat wysoksæ"+ rabat.getWysokosc()+ " rabatid "+ rabat.getRabat_id());
			  try{
				  Thread.sleep(1000);
				  
			  }catch (Exception e){}
			  if( rabat.getWysokosc()==r.getWysokosc()){
				  id= rabat.getRabat_id();
				  tImp.delete(id);
				 
			  }
			
		}
		  
		  r2 = tImp.get();
		  assertEquals("Wynik", (r1.size()),r2.size());
		  
		  
		  
	  }
	

	
}
