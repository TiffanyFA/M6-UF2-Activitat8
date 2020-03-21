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
public class Propietari {
	private static final long serialVersionUID = 1L;

	// Persistent Fields:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String dni;
	private String nom;
	private String direccio;
	private String tel;

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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Propietari)) {
			return false;
		}
		Propietari other = (Propietari) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	// String Representation:
	@Override
	public String toString() {
		return dni + " | " + nom + " | " + direccio + " | " + tel;
	}
}
