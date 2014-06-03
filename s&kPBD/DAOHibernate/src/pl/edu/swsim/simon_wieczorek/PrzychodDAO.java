package pl.edu.swsim.simon_wieczorek;



import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


public interface PrzychodDAO {

	public void add(Przychod przychod);
	public void update(Przychod przychod);
	public List<Przychod> getPrzychod(int stan_magazynowy);
	public void delete(int przychod_id);
	
}
