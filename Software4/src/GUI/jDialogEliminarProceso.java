package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import logic.Proceso;


public class jDialogEliminarProceso extends JDialog {
	
	private static final long serialVersionUID = 1L;

	private JLabel jLabelNombre;
	
	private JComboBox<String> jComboBoxNombre;
	
	private JButton jButtonEliminar;
	private JButton jButtonSalir;
	
	public jDialogEliminarProceso(Controlador controlador) {
		this.setTitle("Eliminar Proceso");
		this.setSize(250, 250);
		this.setUndecorated(true);

		this.setLocationRelativeTo(null);
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints= new GridBagConstraints();
		
		jLabelNombre = new JLabel("Nombre");
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jLabelNombre, constraints);
		
		jComboBoxNombre = new JComboBox<String>();
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.fill=constraints.BOTH;
		this.add(jComboBoxNombre, constraints);
		
		jButtonEliminar = new JButton("Eliminar");
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		jButtonEliminar.addActionListener(controlador);
		jButtonEliminar.setActionCommand(controlador.ELIMINAR_DIALOG_EL_PROCESO);
		this.add(jButtonEliminar, constraints);
		
		jButtonSalir = new JButton("Salir");
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.fill=constraints.BOTH;
		jButtonSalir.addActionListener(controlador);
		jButtonSalir.setActionCommand(controlador.SALIR_DIALOG_EL_PROCESO);
		this.add(jButtonSalir, constraints);
						
	}

	public JComboBox<String> getjComboBoxNombre() {
		return jComboBoxNombre;
	}

	public void setjComboBoxNombre(JComboBox<String> jComboBoxNombre) {
		this.jComboBoxNombre = jComboBoxNombre;
	}
	
	
}
