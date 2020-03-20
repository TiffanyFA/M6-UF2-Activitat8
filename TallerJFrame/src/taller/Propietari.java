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
public class Propietari implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	private String dni;
	private String nom;
	private String direccio;
	private String tel;

	@OneToMany(targetEntity = Vehicle.class)
	private List vehicles;

	// Constructors:
	public Propietari() {
	}

	public Propietari(String dni, String nom, String direccio, String tel) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.direccio = direccio;
		this.tel = tel;
	}

	public Long getId() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDireccio() {
		return direccio;
	}

	public void setDireccio(String direccio) {
		this.direccio = direccio;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List getVehicles() {
		return vehicles;
	}

	public void setVehicles(List vehicles) {
		this.vehicles = vehicles;
	}

	// String Representation:
	@Override
	public String toString() {
		return dni + " | " + nom + " | " + direccio + " | " + tel;
	}
}
