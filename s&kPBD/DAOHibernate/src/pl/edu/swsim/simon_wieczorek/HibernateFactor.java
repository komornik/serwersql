package pl.edu.swsim.simon_wieczorek;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateFactor {
	private static SessionFactory factory;
	
	public static SessionFactory getInstance() {
		if(factory==null) {
			
			Configuration cfg = new	AnnotationConfiguration().configure();
			factory	= cfg.buildSessionFactory();
		}
		return factory;
	}
}