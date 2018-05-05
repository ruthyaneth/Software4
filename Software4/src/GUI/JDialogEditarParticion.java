package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import logic.Particion;

public class JDialogEditarParticion extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel jLabelSelectParticion;
	private JLabel jLabelNombreParticion;
	private JLabel jLabelTamañoPartición;
	
	private JComboBox<String> jComboBoxParticion;
	private JTextField jTextFieldNombreParticion;
	private JTextField jTextFieldTamañoParticion;
	
	private JButton jButtonCrear;
	private JButton jButtonSalir;
	
	public JDialogEditarParticion(Controlador controlador ) {
		
		this.setUndecorated(true);

		this.setTitle("Editar Partición");
		this.setSize(250, 250);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints= new GridBagConstraints();
		
		jLabelSelectParticion = new JLabel("Seleccionar Partición");
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jLabelSelectParticion, constraints);
		
		jComboBoxParticion = new JComboBox<>();
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jComboBoxParticion, constraints);

		jLabelNombreParticion = new JLabel("Nombre:");
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		this.add(jLabelNombreParticion, constraints);
		
		jTextFieldNombreParticion = new JTextField();
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		jTextFieldNombreParticion.setText("                            ");
		this.add(jTextFieldNombreParticion, constraints);
		
		jLabelTamañoPartición = new JLabel("Tamaño:");
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.fill=constraints.BOTH;
		this.add(jLabelTamañoPartición, constraints);
		
		jTextFieldTamañoParticion = new JTextField();
		constraints.gridx=1;
		constraints.gridy=2;
		constraints.fill=constraints.BOTH;
		this.add(jTextFieldTamañoParticion, constraints);
		
		jButtonCrear = new JButton("Guardar");
		constraints.gridx=0;
		constraints.gridy=3;
		constraints.fill=constraints.BOTH;
		jButtonCrear.addActionListener(controlador);
		jButtonCrear.setActionCommand(controlador.GUARDAR_DIALOG_EDIT_PARTICION);
		this.add(jButtonCrear, constraints);
		
		jButtonSalir = new JButton("Salir");
		constraints.gridx=1;
		constraints.gridy=3;
		constraints.fill=constraints.BOTH;
		jButtonSalir.addActionListener(controlador);
		jButtonSalir.setActionCommand(controlador.SALIR_DIALOG_EDIT_PARTICION);
		this.add(jButtonSalir, constraints);
	
	}
//	public void editarParticion(){}

	public JComboBox<String> getjComboBoxParticion() {
		return jComboBoxParticion;
	}

	public void setjComboBoxParticion(JComboBox<String> jComboBoxParticion) {
		this.jComboBoxParticion = jComboBoxParticion;
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
	
	
}
