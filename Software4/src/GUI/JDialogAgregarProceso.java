package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import logic.Particion;
import logic.Proceso;

public class JDialogAgregarProceso extends JDialog {

	private JLabel lblNombre;
	private JLabel lblTiempo;
	private JLabel lblParticion;
	private JLabel lblTamanio;

	private JTextField txtNombre;
	private JTextField txtTiempo;
	private JComboBox<String> bxParticion;
	private JTextField txtTamanio;

	private JButton btnAceptar;
	private JButton btnCancelar;

	public JDialogAgregarProceso(Controlador controlador) {
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
		btnAceptar.addActionListener(controlador);
		btnAceptar.setActionCommand(controlador.CREAR_DIALOG_AGR_PROCESO);
		this.add(btnAceptar, constraints);

		btnCancelar= new JButton("Cancelar");
		constraints.gridx=1;
		constraints.gridy=4;
		constraints.fill=constraints.BOTH;
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(controlador.SALIR_DIALOG_AGR_PROCESO);
		this.add(btnCancelar, constraints);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtTiempo() {
		return txtTiempo;
	}

	public void setTxtTiempo(JTextField txtTiempo) {
		this.txtTiempo = txtTiempo;
	}

	public JComboBox<String> getBxParticion() {
		return bxParticion;
	}

	public void setBxParticion(JComboBox<String> bxParticion) {
		this.bxParticion = bxParticion;
	}

	public JTextField getTxtTamanio() {
		return txtTamanio;
	}

	public void setTxtTamanio(JTextField txtTamanio) {
		this.txtTamanio = txtTamanio;
	}
	
	
	
	public String validarDatos(ArrayList<Proceso> procesos) {
		if (nombreProcesoExiste(procesos)) {
			return "El nombre de este proceso ya fue ingresado";
		}else if (txtNombre.getText().equals("")) {
			return "Por favor ingrese un nombre de proceso";
		}else if (txtTamanio.getText().equals("")) {
			return "Por favor ingrese un tamaño";
		}else if (txtTiempo.getText().equals("")) {
			return "Por favor ingrese un tiempo";
		}else if(!validarnumero(txtTamanio.getText())) {
			return "Por favor ingrese un tamaño valido";
		}else if (!validarnumero(txtTiempo.getText())) {
			return "Por favor ingrese un tiempo valido";
		}return null;
		
	}
	
	public boolean validarnumero(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public boolean nombreProcesoExiste(ArrayList<Proceso> procesos) {
		if (procesos.size()>0) {
			for (int i = 0; i < procesos.size(); i++) {
				if (txtNombre.getText().equalsIgnoreCase(procesos.get(i).getNombre())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void limpiar() {
		txtNombre.setText("");
		txtTamanio.setText("");
		txtTiempo.setText("");
	}
	
}
