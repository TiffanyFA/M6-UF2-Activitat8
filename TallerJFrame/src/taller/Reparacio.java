package taller;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reparacio implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	@Temporal(TemporalType.DATE)
	Date dataInici;
	@Temporal(TemporalType.DATE)
	Date dataFi;
	private String descripcio;
	private double hores;

	@ManyToOne
	private Vehicle vehicle;

	@OneToMany(targetEntity = Unitats.class)
	private List unitats;

	// Constructors:
	public Reparacio() {
	}

	public Reparacio(Date dataFi, String descripcio, double hores) {
		super();
		this.dataInici = new Date(System.currentTimeMillis());
		this.dataFi = dataFi;
		this.descripcio = descripcio;
		this.hores = hores;
	}

	public Long getId() {
		return id;
	}

	public Date getDataInici() {
		return dataInici;
	}

	public void setDataInici(Date dataInici) {
		this.dataInici = dataInici;
	}

	public Date getDataFi() {
		return dataFi;
	}

	public void setDataFi(Date dataFi) {
		this.dataFi = dataFi;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public double getHores() {
		return hores;
	}

	public void setHores(double hores) {
		this.hores = hores;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List getUnitats() {
		return unitats;
	}

	public void setUnitats(List unitats) {
		this.unitats = unitats;
	}

	// String Representation:
	@Override
	public String toString() {
		return dataInici + " | " + dataFi + " | " + descripcio + " | " + hores;
	}
}
