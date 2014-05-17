package pl.edu.swsim.simon_wieczorek;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UlicaDAOImp implements UlicaDAO{

	@Override
	public void add(Ulica ulica) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(ulica);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int ulica_id) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		Ulica ulica = (Ulica)session.get(Ulica.class, ulica_id);
		session.delete(ulica);
		
		tx.commit();
		session.close();
	}

	@Override
	public Ulica get(int ulica_id) {
		// TODO Auto-generated method stub
			Session session = HibernateFactor.getInstance().openSession();
			Transaction tx = session.beginTransaction();
			Ulica ulica = (Ulica)session.get(Ulica.class, ulica_id);
			tx.commit();
			session.close();
		return ulica;
	}

	@Override
	public List<Ulica> get(String ulica) {
		// TODO Auto-generated method stub
			Session session = HibernateFactor.getInstance().openSession();
			Transaction tx = session.beginTransaction();
			
			List<Ulica> ulica_lista = session.createQuery("FROM Ulica WHERE nazwa_ulicy = '"+ulica+"'").list();
			
			tx.commit();
			session.close();
		return ulica_lista;
	}

	@Override
	public void update(Ulica ulica) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(ulica);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Ulica> get() {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Ulica> ulica_lista = session.createQuery("from Ulica").list();
		
		tx.commit();
		session.close();
		
		return ulica_lista;
	}

	@Override
	public Ulica getUlica(String ulica) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		org.hibernate.Query query = session.createQuery("FROM Ulica WHERE nazwa_ulicy = '"+ulica+"'");
		
		 Ulica ulicaObj = (Ulica)query.uniqueResult();
		 
		tx.commit();
		session.close();
	return ulicaObj;
	}

}
