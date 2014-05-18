package pl.edu.swsim.simon_wieczorek;

import java.util.List;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProduktDAOImp implements ProduktDAO {

	@Override
	public void add(Produkt produkt) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(produkt);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Produkt produkt) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(produkt);
		
		tx.commit();
		session.close();
	}

	@Override
	public List<Produkt> getProdukt() {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Produkt> produktList =session.createQuery("FROM Produkt").list();
		
		tx.commit();
		session.close();
		return produktList;
	}

	@Override
	public Produkt getProdukt(int produkt_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Produkt objProdukt = (Produkt)session.get(Produkt.class, produkt_id);
		tx.commit();
		session.close();
		return objProdukt;
	}

	@Override
	public Produkt getProdukt(String nazwa_produktu) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Produkt objProdukt = (Produkt)session.get(Produkt.class, nazwa_produktu);
		tx.commit();
		session.close();
		return objProdukt;
	}

	@Override
	public List<Produkt> getProdukt(Date data, boolean data_dodania) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		List<Produkt> produktList;
		if (data_dodania){
			produktList =session.createQuery("FROM produkt where data_dodania="+data).list();
		}else{
			produktList =session.createQuery("FROM produkt where data_dodania="+data).list();	
		}
		tx.commit();
		session.close();
		return produktList;
	}

	@Override
	public void delete(int produkt_id) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Produkt produkt=(Produkt) session.get(Produkt.class, produkt_id);
		session.delete(produkt);
		tx.commit();
		session.close();
	}
	
}
