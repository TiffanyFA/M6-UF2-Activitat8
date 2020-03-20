package taller;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Unitats implements Serializable {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue
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

	// String Representation:
	@Override
	public String toString() {
		return String.valueOf(quantitat);
	}
}
