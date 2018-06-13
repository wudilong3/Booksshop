package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class hibernateUtil {
	private static SessionFactory sessionFactory =null;
	static {
		StandardServiceRegistry registry 
	    = new StandardServiceRegistryBuilder()
	        .configure()
	        .build();
		
		 try {
	            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	        } catch (Exception e) {
	            StandardServiceRegistryBuilder.destroy(registry);
	            e.printStackTrace();
	        }
	}
	public static Session openSession() {
		return sessionFactory.openSession();

	}

}
