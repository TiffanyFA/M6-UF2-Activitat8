package taller;

import javax.persistence.*;

import gui.JVehicle;

import java.awt.EventQueue;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    	
    	/**
    	 * Launch the application.
    	 */
    	
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					JVehicle frame = new JVehicle();
    					frame.setVisible(true);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
    	
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/taller.odb");
        EntityManager em = emf.createEntityManager();

        // Store 1000 Point objects in the database:
        em.getTransaction().begin();
        
        Propietari p = new Propietari("1234", "Maria","Carrer S", "97745615");
		Vehicle v = new Vehicle("1234ABC","opel","corsa","z",true, p );
        em.persist(v);
        
        Vehicle v2 = new Vehicle("4321LKM","opel","mokka","z",true,p);
        em.persist(v2);
        
        Vehicle v3 = new Vehicle("8524GHY","seat","ibiza","o",true,
        		new Propietari("6548", "Olga","Carrer J", "97754894"));
        em.persist(v3);
        em.getTransaction().commit();

//        // Find the number of Point objects in the database:
//        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
//        System.out.println("Total Points: " + q1.getSingleResult());
//
//        // Find the average X value:
//        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
//        System.out.println("Average X: " + q2.getSingleResult());
//
//        // Retrieve all the Point objects from the database:
//        TypedQuery<Point> query =
//            em.createQuery("SELECT p FROM Point p", Point.class);
//        List<Point> results = query.getResultList();
//        for (Point p : results) {
//            System.out.println(p);
//        }

        // Close the database connection:
        em.close();
        emf.close();
        
    }
}
