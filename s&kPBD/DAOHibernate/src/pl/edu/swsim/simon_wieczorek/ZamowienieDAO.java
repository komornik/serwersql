package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface ZamowienieDAO {
	public void add(Zamowienie zamowienie);
	public void update(Zamowienie zamowienie);
	public List<Zamowienie> get();
	public Zamowienie get(int zamowienie_id);
	public void delete(int zamowienie_id);

}
