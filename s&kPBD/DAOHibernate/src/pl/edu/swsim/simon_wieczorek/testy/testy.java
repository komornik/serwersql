package pl.edu.swsim.simon_wieczorek.testy;
import static org.junit.Assert.assertEquals;
import pl.edu.swsim.simon_wieczorek.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;



import org.hibernate.AssertionFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class testy {
	
	  @Test
	  public void testMultiplyException() {
	  }
	  
	  @Test
	  public void testRabat(){
		  Rabat r = new Rabat();
		  r.setWysokosc(0.3);
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
		  
		  
		  
		  
		  
		  
	  }
	

	
}
