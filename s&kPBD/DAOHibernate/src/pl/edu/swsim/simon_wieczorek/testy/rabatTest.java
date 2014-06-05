package pl.edu.swsim.simon_wieczorek.testy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

import pl.edu.swsim.simon_wieczorek.*;

@RunWith(JUnit4.class)
public class rabatTest{
	
		@Test
		public void testRabat(){
			  Rabat r = new Rabat();
			  r.setWysokosc(0.2);
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