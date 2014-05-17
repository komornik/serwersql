package pl.edu.swsim.simon_wieczorek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ulica{
	
	
	public Ulica(){
		
	}
	
	public Ulica(String nazwa_ulicy, Kod_Poczt kod_poczt){
		setNazwa_ulicy(nazwa_ulicy);
		setKod_poczt(kod_poczt);
	}
	
	@Id
	@GeneratedValue
	private int ulica_id;
	public int getUlica_id() {
		return ulica_id;
	}
	public void setUlica_id(int ulica_id) {
		this.ulica_id = ulica_id;
	}
	
	private String nazwa_ulicy;
	
	public String getNazwa_ulicy() {
		return nazwa_ulicy;
	}
	public void setNazwa_ulicy(String nazwa_ulicy) {
		this.nazwa_ulicy = nazwa_ulicy;
	}	
	
	@ManyToOne
	@JoinColumn(name="kod_poczt_id")
	private Kod_Poczt kod_poczt;
	
	public Kod_Poczt getKod_poczt() {
		return kod_poczt;
	}
	public void setKod_poczt(Kod_Poczt kod_poczt) {
		this.kod_poczt = kod_poczt;
	}
	
	
	

	
}