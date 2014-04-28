package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface Kod_PocztDAO {

	public void add(Kod_Poczt kod_poczt);
	public void delete(int kod_poczt_id);
	public Kod_Poczt get(int kod_poczt_id);
	public List<Kod_Poczt> getZip(String kod_pocztowy);
	public void update(Kod_Poczt kod_poczt);
	public List<Kod_Poczt> getKodPoczt();
	public List<Kod_Poczt> getMiejscowosc(String nazwa_miejscowosci);
}
