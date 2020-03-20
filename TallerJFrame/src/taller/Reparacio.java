package taller;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reparacio implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private Date dataInici;
    private Date dataFi;
    private String descripcio;
    private double hores;
    
    @ManyToOne
    private Unitats unitats;

    // Constructors:
    public Reparacio() {
    }

    public Reparacio(Date dataFi, String descripcio, double hores) {
		super();
		this.dataInici = new Date(System.currentTimeMillis());
		this.dataFi = dataFi;
		this.descripcio = descripcio;
		this.hores = hores;
	}



	// String Representation:
    @Override
    public String toString() {
    	return dataInici + " | " + dataFi + " | " + descripcio + " | " + hores;
    }
} 
