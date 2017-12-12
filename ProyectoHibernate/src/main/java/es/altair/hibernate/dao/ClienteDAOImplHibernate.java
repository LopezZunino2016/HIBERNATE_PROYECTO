package es.altair.hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.altair.hibernate.bean.Cliente;

public class ClienteDAOImplHibernate implements ClienteDAO {

	public void guardar(Cliente c) {
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
	public List<Cliente> listarClientes() {
		List<Cliente> listaClientes = new ArrayList<Cliente>(); 

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction(); 
			listaClientes = sesion.createSQLQuery("SELECT * FROM clientes").addEntity(Cliente.class).list();
			sesion.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
			sf.close();
		}
		
		return listaClientes;
	}
	public Cliente get(int id) {
		Cliente c = null; 
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			
			c = sesion.get(Cliente.class,id);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
		return c;
	}
	public void update(Cliente id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.update(id);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
	}
	public void delete(Cliente id) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		try {
			sesion.beginTransaction();
			
			sesion.delete(id);
			
			sesion.getTransaction().commit();
		} catch (Exception ex) {
			
		} finally {
			sesion.close();
			sf.close();
		}
		
	}
	public void mostrarClientesPaginacion(int tamayo) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sesion = sf.openSession();
		
		long numClientes = (Long)  sesion.createQuery("SELECT count(*) FROM Cliente").uniqueResult();
		
		int numPaginas = (int) Math.ceil(numClientes/tamayo); 
		
		Query query = (Query) sesion.createQuery("FROM Cliente").setMaxResults(tamayo);
		
		for (int i = 0; i < numPaginas; i++) {
			System.out.println("\t\t\t\t------------------ Página " + (i+1) + "-----------------");
			query.setFirstResult(i*tamayo);
			List<Cliente> clientes = query.list(); 
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
			}
			System.out.println("\t\t\t\t---------------------------------------------");

		}
		 
	}
	
}
