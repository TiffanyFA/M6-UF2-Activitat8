package taller;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Propietari implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String dni;
    private String nom;
    private String direccio;
    private String tel;

    @ManyToOne
    private Vehicle vehicle;
    
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



	// String Representation:
    @Override
    public String toString() {
        return dni + " | " + nom + " | " + direccio + " | " + tel;
    }
} 
