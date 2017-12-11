package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import es.altair.hibernate.bean.Coches;
import es.altair.hibernate.bean.CochesRevisiones;

public class CochesRevisionDAOImplHibernate implements CochesRevisionDAO {

	public void guardar(CochesRevisiones cR) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion =  sf.openSession();
		
		try {
			sesion.beginTransaction(); 
			sesion.save(cR);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
			sf.close();
		}
	}
	public List<CochesRevisiones> listaCochesRevision() {
		List<CochesRevisiones> listaCochesRevision = new  ArrayList<CochesRevisiones>();
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction(); 
			listaCochesRevision = sesion.createSQLQuery("SELECT * FROM cochesrevisiones").addEntity(CochesRevisiones.class).list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}
		
		return listaCochesRevision;
	}

	public CochesRevisiones get(int id) {
		CochesRevisiones cR = null; 
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			cR  = sesion.get(CochesRevisiones.class, id);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		return cR; 
	}
	public void delete(CochesRevisiones cR) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.delete(cR);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
	}
	public void update(CochesRevisiones cR) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.update(cR);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
	}
}
