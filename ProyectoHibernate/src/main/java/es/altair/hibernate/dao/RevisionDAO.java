package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Revision;

public interface RevisionDAO {
	public void save(Revision r);
	public List<Revision> listarRevisiones();
	public Revision get(int id); 
	public void update(Revision r);
	public void delete(Revision r);
}
