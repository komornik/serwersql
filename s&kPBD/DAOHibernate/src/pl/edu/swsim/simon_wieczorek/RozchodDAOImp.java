package pl.edu.swsim.simon_wieczorek;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RozchodDAOImp implements RozchodDAO {

	@Override
	public void add(Rozchod rozchod) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(rozchod);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Rozchod rozchod) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.update(rozchod);
		tx.commit();
		session.close();
	}

	@Override
	public List<Rozchod> get() {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		List<Rozchod> rozchod = session.createQuery("FROM Rozchod ").list();
		tx.commit();
		session.close();
		return rozchod;
	
	}

	@Override
	public Rozchod get(int rozchod_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Rozchod rozchod = (Rozchod)session.get(Rozchod.class, rozchod_id);
		tx.commit();
		session.close();
		return rozchod;
	}

	@Override
	public void delete(int rozchod_id) {
		// TODO Auto-generated method stub
				Session session = HibernateFactor.getInstance().openSession();
				Transaction tx = session.beginTransaction();
				Rozchod rozchod = (Rozchod)session.get(Rozchod.class, rozchod_id);
				session.delete(rozchod);
				tx.commit();
				session.close();
	}
	

}
