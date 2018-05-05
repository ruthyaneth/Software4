package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controlador.Controlador;

public class JPanelMenu extends JPanel {

	private JButton btnAddParticion;
	private JButton btnAddProceso;
	private JButton btnIniciar;
	private JButton btnReiniciar;
	private JButton eliminarParticion;
	private JButton eliminarProceso;
	private JButton editarParticion;
	private JButton editarProceso;
	private JButton btnsalir;
	

	public JPanelMenu(Controlador controlador) {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c= new GridBagConstraints();

		btnAddParticion = new JButton("Agregar Particion");
		c.gridx=1;
		c.gridy=0;
		c.fill=c.BOTH;
		btnAddParticion.addActionListener(controlador);
		btnAddParticion.setActionCommand(controlador.ADD_PARTICION);
		this.add(btnAddParticion,c);

		btnAddProceso= new JButton("Agregar Proceso");
		c.gridx=1;
		c.gridy=1;
		c.fill=c.BOTH;
		btnAddProceso.addActionListener(controlador);
		btnAddProceso.setActionCommand(controlador.ADD_PROCESO);
		this.add(btnAddProceso,c);

		btnIniciar= new JButton("Iniciar");
		c.gridx=1;
		c.gridy=2;
		c.fill=c.BOTH;
		btnIniciar.addActionListener(controlador);
		btnIniciar.setActionCommand(controlador.INICIAR);
		this.add(btnIniciar,c);

		eliminarParticion= new JButton("Eliminar particion");
		c.gridx=1;
		c.gridy=3;
		c.fill=c.BOTH;
		eliminarParticion.addActionListener(controlador);
		eliminarParticion.setActionCommand(controlador.ELIMINAR_PARTICION);
		this.add(eliminarParticion,c);

		eliminarProceso= new JButton("Eliminar proceso");
		c.gridx=1;
		c.gridy=4;
		c.fill=c.BOTH;
		eliminarProceso.addActionListener(controlador);
		eliminarProceso.setActionCommand(controlador.ELIMINAR_PROCESO);
		this.add(eliminarProceso,c);

		editarParticion= new JButton("Editar particion");
		c.gridx=1;
		c.gridy=5;
		c.fill=c.BOTH;
		editarParticion.addActionListener(controlador);
		editarParticion.setActionCommand(controlador.EDITAR_PARTICION);
		this.add(editarParticion,c);

		editarProceso= new JButton("Editar proceso");
		c.gridx=1;
		c.gridy=6;
		c.fill=c.BOTH;
		editarProceso.addActionListener(controlador);
		editarProceso.setActionCommand(controlador.EDITAR_PROCESO);
		this.add(editarProceso,c);


		btnReiniciar= new JButton("Reiniciar");
		c.gridx=1;
		c.gridy=7;
		c.fill=c.HORIZONTAL;
		btnReiniciar.addActionListener(controlador);
		btnReiniciar.setActionCommand(controlador.REINICIAR);
		this.add(btnReiniciar,c);
		
		btnsalir= new JButton("Salir");
		c.gridx=1;
		c.gridy=8;
		c.fill=c.BOTH;
		btnsalir.addActionListener(controlador);
		btnsalir.setActionCommand(controlador.SALIR);
		this.add(btnsalir,c);
	}
}
