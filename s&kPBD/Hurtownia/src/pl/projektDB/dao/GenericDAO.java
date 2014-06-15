package pl.projektDB.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Uniwersalne DAO - dzia³a dla KA¯DEJ encji!
 * @author pawel@kasprowski.pl
 *
 */
public class GenericDAO {

	public <T> T create(T t) {
		Session session = HibFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(t);
		tx.commit();
		session.close();
		return t;
	}
	public <T> T get(Object id, Class<T> type) {
		Session session = HibFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		T t = (T)session.get(type, (Serializable)id);
		tx.commit();
		session.close();
		return t;
	}
	public void delete(Object t) {
		Session session = HibFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Object ref = session.merge(t);
		session.delete(ref);
		tx.commit();
		session.close();

	}
	public <T> T update(T t) {
		Session session = HibFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		T ref = (T)session.merge(t);
		tx.commit();
		session.close();
		return ref;
	}
	public List<Object> getAll(String objName){
		Session session = HibFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Object> list = session.createQuery("from "+objName+" x").list();
		tx.commit();
		session.close();
		return list;
	}
}
