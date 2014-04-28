package pl.edu.swsim.simon_wieczorek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ulica{
	
	@Id
	@GeneratedValue
	private int ulica_id;
	public int getUlica_id() {
		return ulica_id;
	}
	public void setUlica_id(int ulica_id) {
		this.ulica_id = ulica_id;
	}
	public String getNazwa_ulicy() {
		return nazwa_ulicy;
	}
	public void setNazwa_ulicy(String nazwa_ulicy) {
		this.nazwa_ulicy = nazwa_ulicy;
	}
	public Kod_Poczt getKod_poczt() {
		return kod_poczt;
	}
	public void setKod_poczt(Kod_Poczt kod_poczt) {
		this.kod_poczt = kod_poczt;
	}
	private String nazwa_ulicy;
	private Kod_Poczt kod_poczt;
	
}