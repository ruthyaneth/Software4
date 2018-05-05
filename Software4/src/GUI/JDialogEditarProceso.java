package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import logic.Particion;
import logic.Proceso;

public class JDialogEditarProceso extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelSelecProceso;
	private JLabel lblNombre;
	private JLabel lblTiempo;
	private JLabel lblParticion;
	private JLabel lblTamanio;
	
	private JComboBox<String> jComboBoxProceso;
	private JTextField txtNombre;
	private JTextField txtTiempo;
	private JComboBox<String> bxParticion;
	private JTextField txtTamanio;

	private JButton btnAceptar;
	private JButton btnCancelar;

	public JDialogEditarProceso(Controlador controlador) {
		this.setTitle("Editar Proceso");
		this.setUndecorated(true);

		this.setSize(250, 250);
		this.setLocationRelativeTo(null);

		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints= new GridBagConstraints();
		
		jLabelSelecProceso = new JLabel("Seleccionar Proces");
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jLabelSelecProceso,constraints);
		
		jComboBoxProceso = new JComboBox<>();
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jComboBoxProceso,constraints);

		lblNombre= new JLabel("Nombre: ");
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(lblNombre,constraints);

		txtNombre= new JTextField();
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(txtNombre, constraints);

		lblTiempo= new JLabel("Tiempo (seg): ");
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.fill=constraints.BOTH;
		this.add(lblTiempo, constraints);

		txtTiempo= new JTextField();
		constraints.gridx=1;
		constraints.gridy=2;
		constraints.fill=constraints.BOTH;
		this.add(txtTiempo, constraints);


		lblParticion= new JLabel("Particion: ");
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.fill=constraints.BOTH;
		this.add(lblParticion, constraints);

		bxParticion= new JComboBox<>();
		constraints.gridx=1;
		constraints.gridy=3;
		constraints.fill=constraints.BOTH;
		this.add(bxParticion, constraints);

		lblTamanio= new JLabel("Tamaño: ");
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.fill=constraints.BOTH;
		this.add(lblTamanio, constraints);

		txtTamanio= new JTextField();
		constraints.gridx=1;
		constraints.gridy=4;
		constraints.fill=constraints.BOTH;
		this.add(txtTamanio, constraints);

		btnAceptar= new JButton("Guardar");
		constraints.gridx=0;
		constraints.gridy=5;
		constraints.fill=constraints.BOTH;
		btnAceptar.addActionListener(controlador);
		btnAceptar.setActionCommand(controlador.GUARDAR_DIALOG_EDIT_PROCESO);
		this.add(btnAceptar, constraints);

		btnCancelar= new JButton("Cancelar");
		constraints.gridx=1;
		constraints.gridy=5;
		constraints.fill=constraints.BOTH;
		btnCancelar.addActionListener(controlador);
		btnCancelar.setActionCommand(controlador.SALIR_DIALOG_EDIT_PROCESO);
		this.add(btnCancelar, constraints);
	}

	public JComboBox<String> getjComboBoxProceso() {
		return jComboBoxProceso;
	}

	public void setjComboBoxProceso(JComboBox<String> jComboBoxProceso) {
		this.jComboBoxProceso = jComboBoxProceso;
	}

	public JComboBox<String> getJComboBoxParticion() {
		return bxParticion;
	}

	public void setBxParticion(JComboBox<String> bxParticion) {
		this.bxParticion = bxParticion;
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

	public JTextField getTxtTamanio() {
		return txtTamanio;
	}

	public void setTxtTamanio(JTextField txtTamanio) {
		this.txtTamanio = txtTamanio;
	}
}
