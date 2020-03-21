package taller;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Unitats {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	private int quantitat;

	@ManyToOne
	private Reparacio reparacio;

	@ManyToOne
	private Recanvis recanvis;

	// Constructors:
	public Unitats() {
	}

	public Unitats(int quantitat) {
		super();
		this.quantitat = quantitat;
	}

	public Long getId() {
		return id;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public Reparacio getReparacio() {
		return reparacio;
	}

	public void setReparacio(Reparacio reparacio) {
		this.reparacio = reparacio;
	}

	public Recanvis getRecanvis() {
		return recanvis;
	}

	public void setRecanvis(Recanvis recanvis) {
		this.recanvis = recanvis;
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
		if (!(object instanceof Unitats)) {
			return false;
		}
		Unitats other = (Unitats) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	// String Representation:
	@Override
	public String toString() {
		return String.valueOf(quantitat);
	}
}
