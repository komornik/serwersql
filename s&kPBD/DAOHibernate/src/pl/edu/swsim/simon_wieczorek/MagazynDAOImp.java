package pl.edu.swsim.simon_wieczorek;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MagazynDAOImp implements MagazynDAO{

	@Override
	public void add(Magazyn magazyn) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(magazyn);
		
		tx.commit();
		session.close();
	}

	@Override
	public void update(Magazyn magazyn) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(magazyn);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Magazyn> get() {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Magazyn> magazynList = session.createQuery("FROM Magazyn").list();
		
		tx.commit();
		session.close();
		return magazynList;
	}

	@Override
	public Magazyn listId(int magazyn_id) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		Magazyn magazyn = (Magazyn)session.get(Magazyn.class, magazyn_id);
		tx.commit();
		session.close();
				
		return magazyn;
	}

	@Override
	public Magazyn getMagazynByNazwaMagazynu(String nazwa_magazynu) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		org.hibernate.Query query = session.createQuery("FROM Magazyn WHERE nazwa_magazynu = '"+nazwa_magazynu+"'");
		
		Magazyn magazyn = (Magazyn)query.uniqueResult();
		 
		tx.commit();
		session.close();
				
		return magazyn;
	}

	@Override
	public void delete(int magazyn_id) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		
		Transaction tx = session.beginTransaction();
		Magazyn m =(Magazyn) session.get(Magazyn.class, magazyn_id);
		session.delete(m);		
		
		tx.commit();
		session.close();
	}
	
}