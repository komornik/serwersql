package pl.edu.swsim.simon_wieczorek;

import java.util.List;
import java.sql.Date;


public interface ProduktDAO {
	public void add(Produkt produkt);
	public void update(Produkt produkt);
	public List<Produkt> getProdukt();
	public Produkt getProdukt(int produkt_id);
	public Produkt getProdukt(String nazwa_produktu);
	public List<Produkt> getProdukt(Date data, boolean data_dodania );
	public void delete(int produkt_id);
}
