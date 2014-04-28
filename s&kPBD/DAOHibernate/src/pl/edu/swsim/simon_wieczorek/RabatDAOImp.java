package pl.edu.swsim.simon_wieczorek;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RabatDAOImp implements RabatDAO{

	@Override
	public void add(Rabat rabat) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(rabat);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(Rabat rabat) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(rabat);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Rabat> get() {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Rabat> rabatList =session.createQuery("FROM Rabat").list();
		
		tx.commit();
		session.close();
		return rabatList;
	}

	@Override
	public Rabat listId(int rabat_id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		Rabat rabatList = (Rabat)session.get(Rabat.class, rabat_id);
		tx.commit();
		session.close();
				
		return rabatList;
	}

	@Override
	public List<Rabat> listWysokosc(double wysokosc) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Rabat> rabatList = session.createQuery("FROM Rabat WHERE wysokosc = "+wysokosc).list();
		
		tx.commit();
		session.close();
				
		return rabatList;
	}

	@Override
	public void delete(int rabat_id) {
		Session session = HibernateFactor.getInstance().openSession();
		
		Transaction tx = session.beginTransaction();
		Rabat r =(Rabat) session.get(Rabat.class, rabat_id);
		session.delete(r);
		
		
		tx.commit();
		session.close();
	}
	
}