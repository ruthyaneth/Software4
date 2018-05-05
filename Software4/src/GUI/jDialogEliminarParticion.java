package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import controlador.Controlador;


public class jDialogEliminarParticion extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jLabelNombre;
	
	private JComboBox<String> jComboBoxNombre;
	
	private JButton jButtonEliminar;
	private JButton jButtonSalir;
	
	public jDialogEliminarParticion(Controlador controlador) {
		this.setTitle("Eliminar Particion");
		this.setUndecorated(true);

		this.setSize(250, 250);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints= new GridBagConstraints();
		
		jLabelNombre = new JLabel("Nombre");
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jLabelNombre, constraints);
		
		jComboBoxNombre = new JComboBox<>();
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jComboBoxNombre, constraints);
		
		jButtonEliminar = new JButton("Eliminar");
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		jButtonEliminar.addActionListener(controlador);
		jButtonEliminar.setActionCommand(controlador.ELIMINAR_DIALOG_EL_PART);
		this.add(jButtonEliminar, constraints);
		
		jButtonSalir = new JButton("Salir");
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		jButtonSalir.addActionListener(controlador);
		jButtonSalir.setActionCommand(controlador.SALIR_DIALOG_EL_PART);
		this.add(jButtonSalir, constraints);
	}
	
	public JComboBox<String> getjComboBoxNombre() {
		return jComboBoxNombre;
	}

	public void setjComboBoxNombre(JComboBox<String> jComboBoxNombre) {
		this.jComboBoxNombre = jComboBoxNombre;
	}
}
