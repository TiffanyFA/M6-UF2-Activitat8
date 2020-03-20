package taller;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	private String matricula;
	private String marca;
	private String model;
	private String asseguradora;
	boolean itv;

	@ManyToOne
	private Propietari propietari;

	@OneToMany(targetEntity = Reparacio.class)
	private List reparacions;

	// Constructors:
	public Vehicle() {
	}

	public Vehicle(String matricula, String marca, String model, String asseguradora, boolean itv) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.model = model;
		this.asseguradora = asseguradora;
		this.itv = itv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAsseguradora() {
		return asseguradora;
	}

	public void setAsseguradora(String asseguradora) {
		this.asseguradora = asseguradora;
	}

	public boolean isItv() {
		return itv;
	}

	public void setItv(boolean itv) {
		this.itv = itv;
	}

	public Propietari getPropietari() {
		return propietari;
	}

	public void setPropietari(Propietari propietari) {
		this.propietari = propietari;
	}

	public List getReparacions() {
		return reparacions;
	}

	public void setReparacions(List reparacions) {
		this.reparacions = reparacions;
	}

	// String Representation:
	@Override
	public String toString() {
		return matricula + " | " + marca + " | " + model + " | " + asseguradora + " | " + itv;
	}
}
