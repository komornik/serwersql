package pl.edu.swsim.simon_wieczorek;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "faktura", uniqueConstraints = {
		@UniqueConstraint(columnNames = "nr_faktury"),
		@UniqueConstraint(columnNames= "sciezka"),
		})
public class Faktura {

	
	
	public Faktura() {
		// TODO Auto-generated constructor stub
	}
	public Faktura(String nr_faktury, String sciezka, Date data_wystawienia, int klient_id){
		this.setNr_faktury(nr_faktury);
		this.setSciezka(sciezka);
		this.setData_wystawienia(data_wystawienia);	
		this.setKlient_id(klient_id);
		
	}
	
	private int faktura_id;
	private String nr_faktury;
	private String sciezka;
	private Date data_wystawienia;
	private int klient_id;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="zamowienie_has_faktura", 
                joinColumns={@JoinColumn(name="faktura_id")}, 
                inverseJoinColumns={@JoinColumn(name="zamowienie_id")})
    private Set<Zamowienie> zamowienie = new HashSet<Zamowienie>();
	
	@Id
	@GeneratedValue
	@Column(name = "faktura_id", unique = true, nullable = false)
	public int getFaktura_id(){
		return this.faktura_id;
	}
	
	public void setFaktura_id(int faktura_id){
		this.faktura_id=faktura_id;
		
	}
	
	@Column(name = "nr_faktury",unique = true, nullable = false)
	public String getNr_faktury() {
		return nr_faktury;
	}
	
	public void setNr_faktury(String nr_faktury) {
		this.nr_faktury = nr_faktury;
	}
	
	@Column(name = "sciezka", unique = true, nullable = false)
	public String getSciezka() {
		return sciezka;
	}
	
	public void setSciezka(String sciezka) {
		this.sciezka = sciezka;
	}

	@Column(name = "data_wystawienia",  nullable = false)
	public Date getData_wystawienia() {
		return data_wystawienia;
	}
	public void setData_wystawienia(Date data_wystawienia) {
		this.data_wystawienia = data_wystawienia;
	}
	public int getKlient_id() {
		return klient_id;
	}
	public void setKlient_id(int klient_id) {
		this.klient_id = klient_id;
	}
	public Set<Zamowienie> getZamowienie() {
		return zamowienie;
	}
	public void setZamowienie(Set<Zamowienie> zamowienie) {
		this.zamowienie = zamowienie;
	}

	
}
