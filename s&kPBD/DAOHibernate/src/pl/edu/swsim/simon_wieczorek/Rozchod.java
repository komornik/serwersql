package pl.edu.swsim.simon_wieczorek;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Rozchod {

	public Rozchod() {
		// TODO Auto-generated constructor stub
	}
	
	public Rozchod(double ilosc, StanMagazynowy stanMagazynowy, Zamowienie zamowienie){
		setIlosc(ilosc);
		setStanMagazynowy(stanMagazynowy);
		setZamowienie(zamowienie);
	}
	
	@Id
	@GeneratedValue
	@Column(name = "rozchody_id", unique = true, nullable = false)
	private int rozchody_id;
	
	@Column(name = "ilosc", nullable = false)
	private double ilosc;
	
	@ManyToOne
    @JoinColumn(name="zamowienie_id")
	private Zamowienie zamowienie;
	
	@ManyToOne
    @JoinColumn(name="stan_magazynowy_id")
	private StanMagazynowy stanMagazynowy;

	public int getRozchody_id() {
		return rozchody_id;
	}

	public void setRozchody_id(int rozchody_id) {
		this.rozchody_id = rozchody_id;
	}

	public double getIlosc() {
		return ilosc;
	}

	public void setIlosc(double ilosc) {
		this.ilosc = ilosc;
	}

	public Zamowienie getZamowienie() {
		return zamowienie;
	}

	public void setZamowienie(Zamowienie zamowienie) {
		this.zamowienie = zamowienie;
	}

	public StanMagazynowy getStanMagazynowy() {
		return stanMagazynowy;
	}

	public void setStanMagazynowy(StanMagazynowy stanMagazynowy) {
		this.stanMagazynowy = stanMagazynowy;
	}
		

}
