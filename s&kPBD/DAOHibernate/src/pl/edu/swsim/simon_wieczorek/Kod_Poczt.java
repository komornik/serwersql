package pl.edu.swsim.simon_wieczorek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kod_Poczt {

	@Id
	@GeneratedValue
	private int kod_poczt_id;
	
	public int getKod_poczt_id() {
		return kod_poczt_id;
	}
	
	public void setKod_poczt_id(int kod_poczt_id) {
		this.kod_poczt_id = kod_poczt_id;
	}
	
	public String getKod_poczt() {
		return kod_poczt;
	}
	
	public void setKod_poczt(String kod_poczt) {
		this.kod_poczt = kod_poczt;
	}
	
	public String getNazwa_miejscowosci() {
		return nazwa_miejscowosci;
	}
	
	public void setNazwa_miejscowosci(String nazwa_miejscowosci) {
		this.nazwa_miejscowosci = nazwa_miejscowosci;
	}
	private String kod_poczt;
	private String nazwa_miejscowosci;
}
