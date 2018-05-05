package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import logic.Particion;

public class JDialogAgregarParticion extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelNombreParticion;
	private JLabel jLabelTamañoPartición;

	private JTextField jTextFieldNombreParticion;
	private JTextField jTextFieldTamañoParticion;

	private JButton jButtonCrear;
	private JButton jButtonSalir;

	public JDialogAgregarParticion(Controlador controlador ) {

		this.setTitle("Agregar Partición");
		this.setSize(250, 250);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints= new GridBagConstraints();

		jLabelNombreParticion = new JLabel("Nombre:");
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jLabelNombreParticion, constraints);

		jTextFieldNombreParticion = new JTextField();
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jTextFieldNombreParticion, constraints);

		jLabelTamañoPartición = new JLabel("Tamaño:");
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(jLabelTamañoPartición, constraints);

		jTextFieldTamañoParticion = new JTextField();
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(jTextFieldTamañoParticion, constraints);

		jButtonCrear = new JButton("Crear");
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.fill=constraints.BOTH;
		jButtonCrear.addActionListener(controlador);
		jButtonCrear.setActionCommand(controlador.CREAR_DIALOG_PARTICION);
		this.add(jButtonCrear, constraints);

		jButtonSalir = new JButton("Salir");
		constraints.gridx=1;
		constraints.gridy=2;
		constraints.fill=constraints.BOTH;
		jButtonSalir.addActionListener(controlador);
		jButtonSalir.setActionCommand(controlador.SALIR_DIALOG_PARTICION);
		this.add(jButtonSalir, constraints);


	}

	public JLabel getjLabelNombreParticion() {
		return jLabelNombreParticion;
	}

	public void setjLabelNombreParticion(JLabel jLabelNombreParticion) {
		this.jLabelNombreParticion = jLabelNombreParticion;
	}

	public JLabel getjLabelTamañoPartición() {
		return jLabelTamañoPartición;
	}

	public void setjLabelTamañoPartición(JLabel jLabelTamañoPartición) {
		this.jLabelTamañoPartición = jLabelTamañoPartición;
	}

	public JTextField getjTextFieldNombreParticion() {
		return jTextFieldNombreParticion;
	}

	public void setjTextFieldNombreParticion(JTextField jTextFieldNombreParticion) {
		this.jTextFieldNombreParticion = jTextFieldNombreParticion;
	}

	public JTextField getjTextFieldTamañoParticion() {
		return jTextFieldTamañoParticion;
	}

	public void setjTextFieldTamañoParticion(JTextField jTextFieldTamañoParticion) {
		this.jTextFieldTamañoParticion = jTextFieldTamañoParticion;
	}



	public String validarDatos(ArrayList<Particion> particions) {
		if (nombreParticionExiste(particions)) {
			return "El nombre de la particion ya existe";
		}else if (jTextFieldNombreParticion.getText().isEmpty()) {
			return "Por favor ingrese un nombre en la particion";
		}else if (jTextFieldTamañoParticion.getText().isEmpty()) {
			return "Por favor ingrese un tamaño";

		}else if (!validarnumero(jTextFieldTamañoParticion.getText())) {
			return "Por favor ingrese un numero";
		}
		return null;

	}

	public boolean validarnumero(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	


	public boolean nombreParticionExiste(ArrayList<Particion> particiones) {
		if (particiones.size()>0) {
			for (int i = 0; i < particiones.size(); i++) {
				if (jTextFieldNombreParticion.getText().equalsIgnoreCase(particiones.get(i).getNombre())) {
					return true;
				}
			}
		}
		return false;
	}

	public void limpiar() {
		jTextFieldNombreParticion.setText("");
		jTextFieldTamañoParticion.setText("");
	}


}
