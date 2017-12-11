package es.altair.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="revisiones")
public class Revision {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRevisiones;
	private String nombre; 
	private String tipo;
	
	@OneToMany(mappedBy="revision")
	private Set<CochesRevisiones> cochesRevision = new HashSet<CochesRevisiones>();

	public Revision() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Revision(String nombre, String tipo) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public int getIdRevisiones() {
		return idRevisiones;
	}

	public void setIdRevisiones(int idRevisiones) {
		this.idRevisiones = idRevisiones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<CochesRevisiones> getCochesRevision() {
		return cochesRevision;
	}

	public void setCochesRevision(Set<CochesRevisiones> cochesRevision) {
		this.cochesRevision = cochesRevision;
	}

	
	
	
	
}
