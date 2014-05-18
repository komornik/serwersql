package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface KlientDAO {
	
	public void add(Klient klient);
	public void delete(int klient_id);
<<<<<<< HEAD
	public Klient get(int klient_id);
	public Klient getKlientByNip(String nip);
=======
	public List<Klient> get(int klient_id);
	public List<Klient> getNip(String nip);
>>>>>>> origin/krzysztof.simon
	public void update(Klient klient);
	public List<Klient> getKlient();
}
