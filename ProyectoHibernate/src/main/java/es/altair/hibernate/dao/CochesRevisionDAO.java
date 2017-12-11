package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.CochesRevisiones;

public interface CochesRevisionDAO {
	public void guardar(CochesRevisiones cR);
	public List<CochesRevisiones> listaCochesRevision();
	public CochesRevisiones get(int id);
	public void delete(CochesRevisiones cR);
	public void update(CochesRevisiones cR);
	
}
