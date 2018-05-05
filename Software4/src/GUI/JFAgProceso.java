package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

import logic.Particion;

public class JFAgProceso extends JDialog {

	private JLabel lblNombre;
	private JLabel lblTiempo;
	private JLabel lblParticion;
	private JLabel lblTamanio;

	private JTextField txtNombre;
	private JTextField txtTiempo;
	private JComboBox<Particion> bxParticion;
	private JTextField txtTamanio;

	private JButton btnAceptar;
	private JButton btnCancelar;


	public JFAgProceso() {
		this.setTitle("Agregar Proceso");
		this.setUndecorated(true);

		this.setSize(250, 250);
		this.setLocationRelativeTo(null);

		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints= new GridBagConstraints();

		lblNombre= new JLabel("Nombre: ");
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(lblNombre,constraints);

		txtNombre= new JTextField();
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(txtNombre, constraints);

		lblTiempo= new JLabel("Tiempo (seg): ");
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(lblTiempo, constraints);

		txtTiempo= new JTextField();
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(txtTiempo, constraints);


		lblParticion= new JLabel("Particion: ");
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.fill=constraints.BOTH;

		this.add(lblParticion, constraints);

		bxParticion= new JComboBox<>();
		constraints.gridx=1;
		constraints.gridy=2;
		constraints.fill=constraints.BOTH;
		this.add(bxParticion, constraints);

		lblTamanio= new JLabel("Tamaño: ");
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.fill=constraints.BOTH;
		this.add(lblTamanio, constraints);

		txtTamanio= new JTextField();
		constraints.gridx=1;
		constraints.gridy=3;
		constraints.fill=constraints.BOTH;
		this.add(txtTamanio, constraints);

		btnAceptar= new JButton("Aceptar");
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.fill=constraints.BOTH;
		this.add(btnAceptar, constraints);

		btnCancelar= new JButton("Cancelar");
		constraints.gridx=1;
		constraints.gridy=4;
		constraints.fill=constraints.BOTH;
		this.add(btnCancelar, constraints);

	}

}
