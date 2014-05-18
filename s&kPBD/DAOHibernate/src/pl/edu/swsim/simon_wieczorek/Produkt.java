package pl.edu.swsim.simon_wieczorek;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "produkt", uniqueConstraints = {
		@UniqueConstraint(columnNames = "nazwa_produktu"),
		})
public class Produkt {

	private int produkt_id;
	private String nazwa_produktu;
	private Date data_dodania;
	private String miara;
	private double cena;
	private Date data_modyfikacji;
	
	public Produkt() {
		// TODO Auto-generated constructor stub
	}
	
	public Produkt(String nazwa_produktu, Date data_dodania, String miara, double cena, Date data_modyfikacji){
		this.nazwa_produktu=nazwa_produktu;
		this.data_dodania=data_dodania;
		this.miara=miara;
		this.cena=cena;
		this.data_modyfikacji=data_modyfikacji;
	}
	
	public Produkt(String nazwa_produktu, Date data_dodania, String miara, double cena){
		this.nazwa_produktu=nazwa_produktu;
		this.data_dodania=data_dodania;
		this.miara=miara;
		this.cena=cena;
		this.data_modyfikacji= null;
	}

	
	@Id
	@GeneratedValue
	@Column(name = "produkt_id", unique = true, nullable = false)
	public int getProdukt_id() {
		return produkt_id;
	}

	public void setProdukt_id(int produkt_id) {
		this.produkt_id = produkt_id;
	}
	
	@Column(name = "nazwa_produktu",unique = true, nullable = false)
	public String getNazwa_produktu() {
		return nazwa_produktu;
	}

	public void setNazwa_produktu(String nazwa_produktu) {
		this.nazwa_produktu = nazwa_produktu;
	}

	@Column(name = "data_dodania", nullable = false)
	public Date getData_dodania() {
		return data_dodania;
	}

	public void setData_dodania(Date data_dodania) {
		this.data_dodania = data_dodania;
	}

	@Column(name = "miara", nullable = false)
	public String getMiara() {
		return miara;
	}

	public void setMiara(String miara) {
		this.miara = miara;
	}

	@Column(name = "cena", nullable = false)
	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	@Column(name = "data_modyfikacji", nullable = true)
	public Date getData_modyfikacji() {
		return data_modyfikacji;
	}

	public void setData_modyfikacji(Date data_modyfikacji) {
		this.data_modyfikacji = data_modyfikacji;
	}

	
	

}
