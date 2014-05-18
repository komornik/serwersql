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

	private int przychod_id;
	private double ilosc;
	/*@ManyToOne
    @JoinColumn(name="department_id")
	private StanMagazynowy stan_magazynowy;
	*/
	public Przychod() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	@Column(name = "przychod_id", unique = true, nullable = false)
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

	
}
