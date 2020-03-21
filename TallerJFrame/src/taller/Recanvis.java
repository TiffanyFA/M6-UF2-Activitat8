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
public class Recanvis {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String fabricant;
	private String descripcio;
	private double preuUnitat;

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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Recanvis)) {
			return false;
		}
		Recanvis other = (Recanvis) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	// String Representation:
	@Override
	public String toString() {
		return fabricant + " | " + descripcio + " | " + preuUnitat;
	}
}
