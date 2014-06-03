package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface KlientDAO {
	
	public void add(Klient klient);
	public void delete(int klient_id);
	public List<Klient> get(int klient_id);
	public List<Klient> getNip(String nip);
	public void update(Klient klient);
	public List<Klient> getKlient();
}
