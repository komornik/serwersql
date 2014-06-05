package pl.edu.swsim.simon_wieczorek;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.*;

@Entity
@Table(name="stan_magazynowy")
public class StanMagazynowy{
	
	public int getStan_magazynowy_id() {
		return stan_magazynowy_id;
	}

	public void setStan_magazynowy_id(int stan_magazynowy_id) {
		this.stan_magazynowy_id = stan_magazynowy_id;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public Magazyn getMagazyn() {
		return magazyn;
	}

	public void setMagazyn(Magazyn magazyn) {
		this.magazyn = magazyn;
	}

	private int stan_magazynowy_id;
	@ManyToOne
	@JoinColumn(name="produkt_id")
	private Produkt produkt;
	
	@ManyToOne
	@JoinColumn(name="magazyn_id")
	private Magazyn magazyn;
	
	
	
}