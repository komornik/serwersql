package pl.projektDB.beans;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Zamowienie {

	public Zamowienie() {		
	}
	
	public Zamowienie(String nr_zamowienia, Klient klient, List<Faktura> faktura){
		setNr_zamowienia(nr_zamowienia);
		setKlient(klient);
		getFaktura().addAll(faktura);
		
	}
	@Id
	@GeneratedValue
	@Column(name = "zamowienie_id", unique = true, nullable = false)
	private int zamowienie_id;
	
	@Column(name = "nr_zamowienia", nullable = false)
	private String nr_zamowienia;
	
	@ManyToOne
    @JoinColumn(name="klient_id")
	private Klient klient;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="zamowienie_has_faktura", 
                joinColumns={@JoinColumn(name="zamowienie_id")}, 
                inverseJoinColumns={@JoinColumn(name="faktura_id")})
    private Set<Faktura> faktura = new HashSet<Faktura>();

	public int getZamowienie_id() {
		return zamowienie_id;
	}

	public void setZamowienie_id(int zamowienie_id) {
		this.zamowienie_id = zamowienie_id;
	}

	public String getNr_zamowienia() {
		return nr_zamowienia;
	}

	public void setNr_zamowienia(String nr_zamowienia) {
		this.nr_zamowienia = nr_zamowienia;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public Set<Faktura> getFaktura() {
		return faktura;
	}

	public void setFaktura(Set<Faktura> faktura) {
		this.faktura = faktura;
	}

}
