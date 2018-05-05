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
	private JLabel jLabelTama�oPartici�n;

	private JTextField jTextFieldNombreParticion;
	private JTextField jTextFieldTama�oParticion;

	private JButton jButtonCrear;
	private JButton jButtonSalir;

	public JDialogAgregarParticion(Controlador controlador ) {

		this.setTitle("Agregar Partici�n");
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

		jLabelTama�oPartici�n = new JLabel("Tama�o:");
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(jLabelTama�oPartici�n, constraints);

		jTextFieldTama�oParticion = new JTextField();
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(jTextFieldTama�oParticion, constraints);

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

	public JLabel getjLabelTama�oPartici�n() {
		return jLabelTama�oPartici�n;
	}

	public void setjLabelTama�oPartici�n(JLabel jLabelTama�oPartici�n) {
		this.jLabelTama�oPartici�n = jLabelTama�oPartici�n;
	}

	public JTextField getjTextFieldNombreParticion() {
		return jTextFieldNombreParticion;
	}

	public void setjTextFieldNombreParticion(JTextField jTextFieldNombreParticion) {
		this.jTextFieldNombreParticion = jTextFieldNombreParticion;
	}

	public JTextField getjTextFieldTama�oParticion() {
		return jTextFieldTama�oParticion;
	}

	public void setjTextFieldTama�oParticion(JTextField jTextFieldTama�oParticion) {
		this.jTextFieldTama�oParticion = jTextFieldTama�oParticion;
	}



	public String validarDatos(ArrayList<Particion> particions) {
		if (nombreParticionExiste(particions)) {
			return "El nombre de la particion ya existe";
		}else if (jTextFieldNombreParticion.getText().isEmpty()) {
			return "Por favor ingrese un nombre en la particion";
		}else if (jTextFieldTama�oParticion.getText().isEmpty()) {
			return "Por favor ingrese un tama�o";

		}else if (!validarnumero(jTextFieldTama�oParticion.getText())) {
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
		jTextFieldTama�oParticion.setText("");
	}


}
