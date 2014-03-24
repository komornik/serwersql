package pl.edu.swsim.simon_wieczorek;

import java.util.List;


public class Main{
	
	static Klient klient = new Klient();
	
	static KlientDAOImp klientIm = new KlientDAOImp();
	
	public static void main(String args[]){	
		
		
		Main main = new Main();
		
		//main.addKlient("Jan", "Kowalski", "Staromiejskia", "123", "35", 000);
		main.listKlients(klientIm.getKlient());
		
		//Usuwanie klienta o ID 6
	    //klientIm.delete(6);
	    
	    main.listKlients(klientIm.getKlient());
		
	} 
	
	
	/** dodawanie klienta */
	public void addKlient(String imie, String nazwisko, String nazwa_firmy, String nip, String regon, int telefon){
		klient.setImie(imie);
		klient.setNazwa_firmy(nazwa_firmy);
		klient.setNazwisko(nazwisko);
		/** Wartoœæ unikalna */
		klient.setNip(nip);
		/** Wartoœæ unikalna */
		klient.setRegon(regon);
		klient.setTelefon(telefon);
		
		klientIm.add(klient);
	}
	
	/** Wyœwietlenie wszystkich klientów w bazie danych */
	public void listKlients(List<Klient> dane){
		for(Klient dana : dane){
			System.out.println("-----------------------------------------------------");
			System.out.println("\n"+dana.getKlient_id()+" | "+dana.getImie()+" | "+dana.getNazwa_firmy()+" | "+dana.getNip()+" | "+dana.getRegon()+" | "+dana.getTelefon());
		}
	}
	
}