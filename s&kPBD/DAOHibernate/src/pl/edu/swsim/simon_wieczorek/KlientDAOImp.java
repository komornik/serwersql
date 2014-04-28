package pl.edu.swsim.simon_wieczorek;

import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class KlientDAOImp implements KlientDAO{

	@Override
	public void add(Klient klient) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(klient);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(int klient_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		
		Klient k = (Klient)session.get(Klient.class, klient_id);
		session.delete(k);
		tx.commit();
		session.close();
	}

	@Override
	public Klient get(int klient_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Klient objKlient = (Klient)session.get(Klient.class, klient_id);
		tx.commit();
		session.close();
		return objKlient;
	}

	@Override
	public List<Klient> getNip(String nip) {
			Session session = HibernateFactor.getInstance().openSession();
			Transaction tx = session.beginTransaction();
			
			List<Klient> klientLista = session.createQuery("FROM Klient WHERE nip = "+nip).list();
			
			tx.commit();
			session.close();
		return klientLista;
	}

	@Override
	public void update(Klient klient) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(klient);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Klient> getKlient() {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Klient> daneKlient = session.createQuery("from Klient").list();
		
		tx.commit();
		session.close();
		
		return daneKlient;
	}
	
}