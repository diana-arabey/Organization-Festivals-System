package by.iba.training.project.startprogram;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceReg;
	
	static {
		try {
			Configuration conf = new  Configuration().configure();
			sessionFactory = conf.configure().buildSessionFactory();
		}catch (Throwable e) {
			System.err.println("Error in creating SessionFactory object."
			        + e.getMessage());
		}
	}
	
	public static SessionFactory getSessionFactory() {
	
		    //if (null != sessionFactory)
		    //    return sessionFactory;
		    
		   /* Configuration configuration = new Configuration().configure();

		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		    try {
		        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		    } catch (HibernateException e) {
		        System.err.println("Initial SessionFactory creation failed." + e);
		        throw new ExceptionInInitializerError(e);
		    }
		   */
		/*try {
			 


			 Configuration cfg=new Configuration().configure();
			 StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(
			             cfg.getProperties());
			 sessionFactory= cfg.buildSessionFactory(builder.build());

		   // Session session = sf.openSession();
		}catch (Throwable e) {
			System.err.println("Error in creating SessionFactory object."
			        + e.getMessage());
		}
		*/return sessionFactory;
		
		}
}

