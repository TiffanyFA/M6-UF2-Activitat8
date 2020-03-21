package taller;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vehicle {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String matricula;
	private String marca;
	private String model;
	private String asseguradora;
	boolean itv;

	@ManyToOne
	private Propietari propietari;

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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Vehicle)) {
			return false;
		}
		Vehicle other = (Vehicle) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	// String Representation:
	@Override
	public String toString() {
		return matricula + " | " + marca + " | " + model + " | " + asseguradora + " | " + itv;
	}
}
