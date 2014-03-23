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
		
		/** "Delete Klient where klient_id = " wa�na wielko�� liter z klient - nie zadzia�a  */
		session.createQuery("Delete Klient where klient_id = "+klient_id).executeUpdate();
		tx.commit();
		session.close();
	}

	@Override
	public Klient get(int klient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Klient getNip(String nip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Klient klient) {
		// TODO Auto-generated method stub
		
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