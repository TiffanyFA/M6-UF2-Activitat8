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
public class Recanvis implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
	Long id;
	private String fabricant;
	private String descripcio;
	private double preuUnitat;

	@OneToMany(targetEntity = Unitats.class)
	private List unitats;

	// Constructors:
	public Recanvis() {
	}

	public Recanvis(String fabricant, String descripcio, double preuUnitat) {
		super();
		this.fabricant = fabricant;
		this.descripcio = descripcio;
		this.preuUnitat = preuUnitat;
	}

	public Long getId() {
		return id;
	}

	public String getFabricant() {
		return fabricant;
	}

	public void setFabricant(String fabricant) {
		this.fabricant = fabricant;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public double getPreuUnitat() {
		return preuUnitat;
	}

	public void setPreuUnitat(double preuUnitat) {
		this.preuUnitat = preuUnitat;
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
		return fabricant + " | " + descripcio + " | " + preuUnitat;
	}
}
