package es.altair.hibernate.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cochesrevisiones")
public class CochesRevisiones implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCochesRevisiones; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCoches")
	private Coches coche;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idRevisiones")
	private Revision revision; 
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String kilometros;
	
	public CochesRevisiones() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CochesRevisiones(Coches coche, Revision revision, Date fecha, String kilometros) {
		super();
		this.coche = coche;
		this.revision = revision;
		this.fecha = fecha;
		this.kilometros = kilometros;
	}

	public int getIdCochesRevisiones() {
		return idCochesRevisiones;
	}

	public void setIdCochesRevisiones(int idCochesRevisiones) {
		this.idCochesRevisiones = idCochesRevisiones;
	}

	public Coches getCoche() {
		return coche;
	}

	public void setCoche(Coches coche) {
		this.coche = coche;
	}

	public Revision getRevision() {
		return revision;
	}

	public void setRevision(Revision revision) {
		this.revision = revision;
	}

	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getKilometros() {
		return kilometros;
	}

	public void setKilometros(String kilometros) {
		this.kilometros = kilometros;
	} 
	
	
}
