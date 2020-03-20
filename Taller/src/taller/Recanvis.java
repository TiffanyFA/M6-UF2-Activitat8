package taller;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recanvis implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
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





	// String Representation:
    @Override
    public String toString() {
    	return fabricant + " | " + descripcio + " | " + preuUnitat;
    }
} 
