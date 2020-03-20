package taller;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Unitats implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private int quantitat;

    // Constructors:
    public Unitats() {
    }

    public Unitats(int quantitat) {
		super();
		this.quantitat = quantitat;
	}



	// String Representation:
    @Override
    public String toString() {
        return String.valueOf(quantitat);
    }
} 
