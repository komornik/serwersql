package pl.edu.swsim.simon_wieczorek;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "przychod"
		)
public class Przychod {

	@Id
	@GeneratedValue
	@Column(name = "przychod_id", unique = true, nullable = false)
	private int przychod_id;
	
	@Column(name = "ilosc", nullable = false)
	private double ilosc;
	
	@ManyToOne
    @JoinColumn(name="stan_magazynowy_id")
	private StanMagazynowy stan_magazynowy;
	
	public Przychod() {
		// TODO Auto-generated constructor stub
	}
	
	public Przychod(double ilosc, StanMagazynowy stanMagazynowy){
		this.ilosc=ilosc;
		this.stan_magazynowy=stanMagazynowy;
	}
	
	
	public int getPrzychod_id() {
		return przychod_id;
	}

	public void setPrzychod_id(int przychod_id) {
		this.przychod_id = przychod_id;
	}

	
	public double getIlosc() {
		return ilosc;
	}

	public void setIlosc(double ilosc) {
		this.ilosc = ilosc;
	}

	public StanMagazynowy getStan_magazynowy() {
		return stan_magazynowy;
	}

	public void setStan_magazynowy(StanMagazynowy stan_magazynowy) {
		this.stan_magazynowy = stan_magazynowy;
	}
	

	
}
