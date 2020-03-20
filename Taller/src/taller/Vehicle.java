package taller;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String matricula;
    private String marca;
    private String model;
    private String asseguradora;
    boolean itv;

    // Constructors:
    public Vehicle() {
    }

    public Vehicle(String matricula, String marca, String model, String asseguradora, boolean itv) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.model = model;
		this.asseguradora = asseguradora;
		this.itv = itv;
	}



	// String Representation:
    @Override
    public String toString() {
    	return matricula + " | " + marca + " | " + model + " | " + asseguradora + " | " + itv;
    }
} 
