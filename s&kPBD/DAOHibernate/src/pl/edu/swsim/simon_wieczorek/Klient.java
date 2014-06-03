package pl.edu.swsim.simon_wieczorek;

import javax.persistence.*;

@Entity
public class Klient{
	
	@Id
	@GeneratedValue
	private int	klient_id;
	private String nazwa_firmy;
	
	private String imie;
	private String nazwisko;
	private String nip;
	private String regon;
	private int	telefon;
	private int rabat_id;
	private int ulica_id;
	
	public int getKlient_id() {
		return klient_id;
	}
	public void setKlient_id(int klient_id) {
		this.klient_id = klient_id;
	}
	public String getNazwa_firmy() {
		return nazwa_firmy;
	}
	public void setNazwa_firmy(String nazwa_firmy) {
		this.nazwa_firmy = nazwa_firmy;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getRegon() {
		return regon;
	}
	public void setRegon(String regon) {
		this.regon = regon;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	public int getRabat_id() {
		return rabat_id;
	}
	public void setRabat_id(int rabat_id) {
		this.rabat_id = rabat_id;
	}
	
	public int getUlica_id() {
		return ulica_id;
	}
	public void setUlica_id(int ulica_id) {
		this.ulica_id = ulica_id;
	}	
}