package pl.edu.swsim.simon_wieczorek;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.*;
import org.hibernate.annotations.MetaValue;

@Entity
@Table(name="stan_magazynowy")
public class Stan_Magazynowy{
	
	@Id
	@GeneratedValue
	private int stan_magazynowy_id;
	
	@ManyToOne
	@JoinColumn(name="produkt_id")
	private Produkt produkt;
	
	@ManyToOne
	@JoinColumn(name="magazyn_id")
	private Magazyn magazyn;

	
}