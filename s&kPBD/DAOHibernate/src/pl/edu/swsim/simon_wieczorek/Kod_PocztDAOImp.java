package pl.edu.swsim.simon_wieczorek;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Kod_PocztDAOImp implements Kod_PocztDAO{

	@Override
	public void add(Kod_Poczt kod_poczt) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(kod_poczt);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int kod_poczt_id) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		Kod_Poczt kp = (Kod_Poczt)session.get(Kod_Poczt.class, kod_poczt_id);
		session.delete(kp);
		
		tx.commit();
		session.close();
	}

	@Override
	public Kod_Poczt get(int kod_poczt_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Kod_Poczt objKod = (Kod_Poczt)session.get(Kod_Poczt.class, kod_poczt_id);
		tx.commit();
		session.close();
		return objKod;
	}

	@Override
	public Kod_Poczt getZip(String kod_pocztowy) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		org.hibernate.Query query = session.createQuery("FROM Kod_Poczt WHERE kod_poczt = '"+kod_pocztowy+"'");
		Kod_Poczt kodLista = (Kod_Poczt) query.uniqueResult();
		tx.commit();
		session.close();
	return kodLista;
	}

	@Override
	public void update(Kod_Poczt kod_poczt) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(kod_poczt);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Kod_Poczt> getKodPoczt() {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Kod_Poczt> daneKod = session.createQuery("from Kod_Poczt").list();
		
		tx.commit();
		session.close();
		
		return daneKod;
	}

	@Override
	public Kod_Poczt getMiejscowosc(String nazwa_miejscowosci) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		org.hibernate.Query query = session.createQuery("FROM Kod_Poczt WHERE nazwa_miejscowosci = '"+nazwa_miejscowosci+"'");
		Kod_Poczt kodLista = (Kod_Poczt) query.uniqueResult();
		
		tx.commit();
		session.close();
	return kodLista;
	}

}
