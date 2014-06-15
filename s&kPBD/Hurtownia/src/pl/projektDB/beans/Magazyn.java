package pl.projektDB.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Magazyn{
	
	public Magazyn(){ ;}
	
	public Magazyn(String nazwa_magazynu, Ulica ulica){
		setNazwa_magazynu(nazwa_magazynu);
		setUlica(ulica);		
	}
	
	@Id
	@GeneratedValue
	private int magazyn_id;
	public int getMagazyn_id() {
		return magazyn_id;
	}

	public void setMagazyn_id(int magazyn_id) {
		this.magazyn_id = magazyn_id;
	}

	public String getNazwa_magazynu() {
		return nazwa_magazynu;
	}

	public void setNazwa_magazynu(String nazwa_magazynu) {
		this.nazwa_magazynu = nazwa_magazynu;
	}

	public Ulica getUlica() {
		return ulica;
	}

	public void setUlica(Ulica ulica) {
		this.ulica = ulica;
	}

	private String nazwa_magazynu;
	
	@ManyToOne
	@JoinColumn(name="ulica_id")
	private Ulica ulica;
	
	
	
}