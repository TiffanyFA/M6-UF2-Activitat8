package gui;

import java.awt.BorderLayout;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import taller.Propietari;
import taller.Vehicle;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class JVehicle extends JFrame {

	private JPanel contentPane;
	private JTextField textPropietari;
	private JTextField textVehicle;
	EntityManager em = null;
	EntityManagerFactory emf = null;
	JComboBox cmbPropietari;
	JButton btnSortir;
	JButton btnCancelar;
	JButton btnDesar;
	JList listVehicle;
	JButton btnAfegir;
	JButton btnEditar;
	JButton btnEliminar;
	
	//connexió bd
	private void connectDatabase() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("taller.odb");
        }
        if (em == null) {
            em = emf.createEntityManager();
        }
    }
	
	//mostrar Propietaris
	private void llistaPropietaris() {
		cmbPropietari.removeAllItems();
        try {
            TypedQuery query = em.createQuery("SELECT cu FROM Propietari cu ORDER BY cu.name", Propietari.class);
            List PropietariList = query.getResultList();
            Object[] propietaris = PropietariList.toArray();
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(propietaris);
            cmbPropietari.setModel(dcm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
	
	private void llistaVehicles() {
        DefaultListModel dlm = new DefaultListModel();
        dlm.removeAllElements();
        listVehicle.setModel(dlm);
        try {
            TypedQuery query = em.createQuery("SELECT ci FROM Vehicle ci ORDER BY ci.name" , Vehicle.class);
            List VehicleList = query.getResultList();
            Object[] vehicles = VehicleList.toArray();
            listVehicle.setListData(vehicles);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }
	
	private void netejaDetallsVehicle() {
		textVehicle.setText(null);
        cmbPropietari.setSelectedItem(null);
    }
	
	private void displayVehicleDetails() {
        Vehicle Vehicle = (Vehicle) listVehicle.getSelectedValue();
        if (Vehicle != null) {
        	textVehicle.setText(Vehicle.getMatricula());
            cmbPropietari.setSelectedItem(Vehicle.getPropietari());
        }
    }

	private void setToEdit() {
        btnAfegir.setEnabled(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);

        listVehicle.setEnabled(true);

        btnDesar.setEnabled(true);
        btnCancelar.setEnabled(true);

        textVehicle.setEditable(true);
        cmbPropietari.setEnabled(true);
    }
	
	private void setToSelect() {
        btnAfegir.setEnabled(true);
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);

        listVehicle.setEnabled(true);

        btnDesar.setEnabled(false);
        btnCancelar.setEnabled(false);

        textVehicle.setEditable(false);
        cmbPropietari.setEnabled(false);
    }
	
	private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        connectDatabase();
        llistaPropietaris();
        llistaVehicles();
        setToSelect();
    } 
	
	private void btnAfegirActionPerformed(java.awt.event.ActionEvent evt) {                                       
        netejaDetallsVehicle();
        listVehicle.clearSelection();
        setToEdit();
        textVehicle.requestFocus();
    } 
	
	private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (listVehicle.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "Select one to edit");
            listVehicle.requestFocus();
        } else {
            setToEdit();
            textVehicle.requestFocus();
            textVehicle.selectAll();
        }
    }
	
	private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Vehicle Vehicle = (Vehicle) listVehicle.getSelectedValue();
        if (Vehicle == null) {
            JOptionPane.showMessageDialog(null, "Select one to delete");
            listVehicle.requestFocus();
            return;
        } else {
            em.getTransaction().begin();
            em.remove(Vehicle);
            em.getTransaction().commit();
        }
        llistaVehicles();
        netejaDetallsVehicle();
        setToSelect();
        listVehicle.requestFocus();
    } 
	
	private void btnDesarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        Vehicle Vehicle = (Vehicle) listVehicle.getSelectedValue();
        if (Vehicle == null) {
            Vehicle = new Vehicle();
            Vehicle.setPropietari((Propietari) cmbPropietari.getSelectedItem());
            Vehicle.setMatricula(textVehicle.getText());
            em.getTransaction().begin();
            em.persist(Vehicle);
            em.getTransaction().commit();
        } else {
            em.getTransaction().begin();
            Vehicle.setPropietari((Propietari) cmbPropietari.getSelectedItem());
            Vehicle.setMatricula(textVehicle.getText());
            em.getTransaction().commit();
        }
        llistaVehicles();
        setToSelect();
        listVehicle.requestFocus();
    }
	
	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        netejaDetallsVehicle();
        setToSelect();
    }
	
	private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(1);
    }

	/**
	 * Create the frame.
	 */
	public JVehicle() {
		setTitle("Taller");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVehicles = new JLabel("Vehicles");
		lblVehicles.setBounds(27, 59, 46, 14);
		contentPane.add(lblVehicles);
		
		listVehicle = new JList();
		listVehicle.setBounds(21, 84, 75, 149);
		contentPane.add(listVehicle);
		
		btnAfegir = new JButton("Afegir");
		btnAfegir.setBounds(335, 8, 89, 23);
		contentPane.add(btnAfegir);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(335, 36, 89, 23);
		contentPane.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(335, 62, 89, 23);
		contentPane.add(btnEliminar);
		
		textPropietari = new JTextField();
		textPropietari.setBounds(10, 9, 86, 20);
		contentPane.add(textPropietari);
		textPropietari.setColumns(10);
		
		JButton btnNouPropietari = new JButton("Nou Propietari");
		btnNouPropietari.setBounds(106, 8, 101, 23);
		contentPane.add(btnNouPropietari);
		
		textVehicle = new JTextField();
		textVehicle.setBounds(10, 37, 86, 20);
		contentPane.add(textVehicle);
		textVehicle.setColumns(10);
		
		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setBounds(106, 40, 46, 14);
		contentPane.add(lblVehicle);
		
		cmbPropietari = new JComboBox();
		cmbPropietari.setBounds(106, 82, 101, 23);
		contentPane.add(cmbPropietari);
		
		btnDesar = new JButton("Desa");
		btnDesar.setBounds(335, 146, 89, 23);
		contentPane.add(btnDesar);
		
		btnCancelar = new JButton("Cancel\u00B7la");
		btnCancelar.setBounds(335, 180, 89, 23);
		contentPane.add(btnCancelar);
		
		btnSortir = new JButton("Sortir");
		btnSortir.setBounds(335, 210, 89, 23);
		contentPane.add(btnSortir);
	}
}
