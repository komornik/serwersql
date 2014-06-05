package pl.edu.swsim.simon_wieczorek;

import java.util.List;

public interface RozchodDAO {

	public void add(Rozchod rozchod);
	public void update(Rozchod rozchod);
	public List<Rozchod> get();
	public Rozchod get(int rozchod_id);
	public void delete(int rozchod_id);
}
