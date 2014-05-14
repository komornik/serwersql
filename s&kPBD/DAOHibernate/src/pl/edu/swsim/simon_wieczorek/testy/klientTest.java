package pl.edu.swsim.simon_wieczorek.testy;

import java.util.ArrayList;

import pl.edu.swsim.simon_wieczorek.*;

import org.hibernate.HibernateException;
import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class klientTest{
	
	ArrayList<Klient> klientLista;
	RabatDAOImp rabat;
	UlicaDAOImp ulica;
	KlientDAOImp klientImpl;

	
	public klientTest(){
		klientLista = new ArrayList<Klient>();
		rabat = new RabatDAOImp();
		ulica = new UlicaDAOImp();
		klientImpl = new KlientDAOImp();
		
		
	}
	
	/**
	 * Test reakcji na unikaln¹ wartoœæ Nip
	 */
	@Test(expected = HibernateException.class)
	public void addTestUniqueNip(){
		
		klientLista.add(new Klient("Rolmpos", "Jan", "Szemrany", "000000000", "100000", 999999999, ulica.getUlica("Kalwari 2A"), rabat.listId(2)));
		klientLista.add(new Klient("Rolmpos", "Krzysztof", "Szemrany", "000000000", "02000", 999999999, ulica.getUlica("Kalwari 2A"), rabat.listId(2)));		
		
		for(Klient klientx : klientLista){
			klientImpl.add(klientx);
		}		
	}
	
	/*
	 * Test reakcji na unikaln¹ wartoœæ Regon
	 */
	@Test(expected = HibernateException.class)
	public void addTestUniqueRegon(){
		klientLista.add(new Klient("Rolmpos", "Jan", "Szemrany", "030000000", "000000", 999999999, ulica.getUlica("Kalwari 2A"), rabat.listId(2)));
		klientLista.add(new Klient("Rolmpos", "Krzysztof", "Szemrany", "010000000", "000000", 999999999, ulica.getUlica("Kalwari 2A"), rabat.listId(2)));		
		
		for(Klient klientx : klientLista){
			klientImpl.add(klientx);
		}		
	}
	
	@Test
	public void getByNipTest(){
		assertEquals("Rolmpos", klientImpl.getKlientByNip("000000000").getNazwa_firmy());
	}
	
	@Test
	public void updateTest(){
	
		Klient klientx = new Klient("Rolmpos", "Jan", "Szemrany", "060000000", "000001", 999999999, ulica.getUlica("Kalwari 2A"), rabat.listId(2));
		klientx.setKlient_id(klientImpl.getKlientByNip("050000000").getKlient_id());
		klientImpl.update(klientx);
		assertEquals(klientImpl.getKlientByNip("060000000").getNip(), klientx.getNip());
	}
	
}