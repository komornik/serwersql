package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface RabatDAO {

	public void add(Rabat rabat);
	public void update(Rabat rabat);
	public List<Rabat> get();
	public Rabat listId(int rabat_id);
	public List<Rabat> listWysokosc(double wysokosc);
	public void delete(int rabat_id);
}
