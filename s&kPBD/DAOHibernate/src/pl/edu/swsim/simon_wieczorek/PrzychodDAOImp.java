package pl.edu.swsim.simon_wieczorek;



import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class PrzychodDAOImp implements PrzychodDAO {

	@Override
	public void add(Przychod przychod) {
		// TODO Auto-generated method stub
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(przychod);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(Przychod przychod) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		session.update(przychod);
		
		tx.commit();
		session.close();
		
	}

	@Override
	public List<Przychod> getPrzychod(int stan_magazynowy) {
		Session session = HibernateFactor.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		
		List<Przychod> przychodList = session.createQuery("from Przychod where "+stan_magazynowy).list();
		
		tx.commit();
		session.close();
		
		return przychodList;
	}

	@Override
	public void delete(int przychod_id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
