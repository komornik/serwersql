package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface UlicaDAO {	
	public void add(Ulica ulica);
	public void delete(int ulica_id);
	public Ulica get(int ulica_id);
	public Ulica getUlica(String ulica);
	public List<Ulica> get(String ulica);
	public void update(Ulica ulica);
	public List<Ulica> get();
}
