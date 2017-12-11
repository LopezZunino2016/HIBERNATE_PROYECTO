package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Coches;
import es.altair.hibernate.bean.Revision;

public class RevisionDAOImplHibernate implements RevisionDAO {

	public void save(Revision r) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory(); 
		Session sesion = sf.openSession(); 
		
		try {
			sesion.beginTransaction(); 
			sesion.save(r);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sesion.close(); 
			sf.close();
		}

	}
	public List<Revision> listarRevisiones() {
		List<Revision> listarRevisiones = new  ArrayList<Revision>();
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction(); 
			listarRevisiones = sesion.createSQLQuery("SELECT * FROM revisiones").addEntity(Revision.class).list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}
		
		return listarRevisiones;
	}
	public Revision get(int id) {
		Revision r = null; 
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			r = sesion.get(Revision.class, id);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		return r;
	}
	public void update(Revision r) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.update(r);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
	}
	public void delete(Revision r) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.delete(r);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		
	}
	
}
