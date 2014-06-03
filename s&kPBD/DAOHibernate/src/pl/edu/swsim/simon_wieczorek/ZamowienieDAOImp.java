package pl.edu.swsim.simon_wieczorek;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ZamowienieDAOImp implements ZamowienieDAO {

	@Override
	public void add(Zamowienie zamowienie) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(zamowienie);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(Zamowienie zamowienie) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.update(zamowienie);
		tx.commit();
		session.close();
	}

	@Override
	public List<Zamowienie> get() {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		List<Zamowienie> zamowienie = session.createQuery("FROM Zamowienie ").list();
		tx.commit();
		session.close();
		return zamowienie;
	}

	@Override
	public Zamowienie get(int zamowienie_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Zamowienie zamowienie= (Zamowienie)session.get(Zamowienie.class, zamowienie_id);
		tx.commit();
		session.close();
		return zamowienie;
	}

	@Override
	public void delete(int zamowienie_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Zamowienie zamowienie = (Zamowienie)session.get(Zamowienie.class, zamowienie_id);
		session.delete(zamowienie);
		tx.commit();
		session.close();
	}

}
