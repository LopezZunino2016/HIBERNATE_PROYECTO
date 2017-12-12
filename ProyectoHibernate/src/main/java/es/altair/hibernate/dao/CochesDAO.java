package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Coches;

public interface CochesDAO {
	public void guardar(Coches c);
	public List<Coches> listarCoches();
	public Coches get(int id);
	public void delete(Coches c);
	public void update(Coches c);
	public void mostrarCochesPaginacion(int tamayo);
}
