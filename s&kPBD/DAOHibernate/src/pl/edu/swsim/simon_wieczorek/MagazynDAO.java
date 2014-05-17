package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface MagazynDAO {

	public void add(Magazyn magazyn);
	public void update(Magazyn magazyn);
	public List<Magazyn> get();
	public Magazyn listId(int magazyn_id);
	public Magazyn getMagazynByNazwaMagazynu(String nazwa_magazynu);
	public void delete(int magazyn_id);
}
