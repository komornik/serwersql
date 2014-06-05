package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface Stan_MagazynowyDAO {

	public void add(Stan_Magazynowy stan_magazynowy);
	public void delete(int stan_magazynowy_id);
	public Stan_Magazynowy get(int stan_magazynowy_id);
	public void update(Stan_Magazynowy stan_magazynowy);
	public List<Stan_Magazynowy> getStan_Magazynowy();	
}
