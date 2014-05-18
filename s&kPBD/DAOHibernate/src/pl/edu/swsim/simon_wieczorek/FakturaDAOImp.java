package pl.edu.swsim.simon_wieczorek;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class FakturaDAOImp implements FakturaDAO {


	@Override
	public void add(Faktura faktura) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(faktura);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Faktura faktura) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(faktura);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Faktura> getFaktura() {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Faktura> fakturaList =session.createQuery("FROM faktura").list();
		
		tx.commit();
		session.close();
		return fakturaList;
		
	}

	@Override
	public Faktura getFaktura(int faktura_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Faktura objFaktura = (Faktura)session.get(Faktura.class, faktura_id);
		tx.commit();
		session.close();
		return objFaktura;
	}

	@Override
	public Faktura getFaktura(String nr_faktury) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Faktura objFaktura = (Faktura)session.get(Faktura.class, nr_faktury);
		tx.commit();
		session.close();
		return objFaktura;
	}

	@Override
	public void delete(int faktura_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Faktura faktura =(Faktura) session.get(Faktura.class, faktura_id);
		session.delete(faktura);
		tx.commit();
		session.close();
	}

}
