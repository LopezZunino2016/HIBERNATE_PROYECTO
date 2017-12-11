package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Cliente;
import es.altair.hibernate.bean.Coches;

public class CocheDAOImplHibernate implements CochesDAO {

	public void guardar(Coches c) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion =  sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.save(c);
			
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}

	}
	public List<Coches> listarCoches() {
		List<Coches> listaCoches = new  ArrayList<Coches>();
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction(); 
			listaCoches = sesion.createSQLQuery("SELECT * FROM coches").addEntity(Coches.class).list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}
		
		return listaCoches;
	}
	public Coches get(int id) {
		Coches c = null; 
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			c = sesion.get(Coches.class, id);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		return c; 
	}
	public void delete(Coches c) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.delete(c);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
	}
	public void update(Coches c) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.update(c);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
	}

}
