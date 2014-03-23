import java.util.List;


public interface KlientDAO {

	public void addKlient(Klient klient);
	
	public void updateKlient(Klient klient);
	
	public void deleteKlient(int id_klient);
	
	public List<Klient> findByNazwaFirmy(String nazwa_firmy);
	
	public List<Klient> findByNIP(String nip);
	
	public List<Klient> findByRegon(String regon);
	
	public List<Klient> get();
	
}
