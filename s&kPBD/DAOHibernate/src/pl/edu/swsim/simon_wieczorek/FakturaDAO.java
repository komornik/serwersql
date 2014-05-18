package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface FakturaDAO {

	public void add(Faktura faktura);
	public void update(Faktura faktura);
	public List<Faktura> getFaktura();
	public Faktura getFaktura(int faktura_id);
	public Faktura getFaktura(String nr_faktury);
	public void delete(int faktura_id);

}
