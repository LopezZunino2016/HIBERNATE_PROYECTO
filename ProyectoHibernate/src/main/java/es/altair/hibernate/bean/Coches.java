package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="coches")
public class Coches implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCoches; 
	private String matricula; 
	
	@ManyToOne
	@JoinColumn(name="idClientes")
	private Cliente clientes;
	
	@OneToMany(mappedBy="coche")
	private Set<CochesRevisiones> cochesRevision = new HashSet<CochesRevisiones>();
	
	public Coches() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coches(String matricula, Cliente cliente) {
		super();
		this.matricula = matricula;
		this.clientes = cliente;
		
	}

	public int getIdCoches() {
		return idCoches;
	}

	public void setIdCoches(int idCoches) {
		this.idCoches = idCoches;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente cliente) {
		this.clientes = cliente;
	}

	public Set<CochesRevisiones> getCochesRevision() {
		return cochesRevision;
	}

	public void setCochesRevision(Set<CochesRevisiones> cochesRevision) {
		this.cochesRevision = cochesRevision;
	}

	

	
	
	
}
