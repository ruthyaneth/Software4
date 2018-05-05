package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import GUI.JDialogAgregarParticion;
import GUI.JDialogAgregarProceso;
import GUI.JDialogEditarParticion;
import GUI.JDialogEditarProceso;
import GUI.JFInicial;
import GUI.JPanelAgrupacionParticiones;
import GUI.JPanelParticion;
import GUI.JPaneldata;
import GUI.jDialogEliminarParticion;
import GUI.jDialogEliminarProceso;
import logic.Particion;
import logic.Procesador;
import logic.Proceso;

public class Controlador implements ActionListener{

	public static final String SALIR = "Salir";
	public static final String ADD_PROCESO = "Agregar proceso";
	public static final String ADD_PARTICION= "Agregar partición";
	public static final String SALIR_DIALOG_PARTICION= "SalirDP";
	public static final String CREAR_DIALOG_PARTICION = "Crear particion";
	public static final String ELIMINAR_DIALOG_EL_PART = "Eliminar Dialogo Particion";
	public static final String SALIR_DIALOG_EL_PART = "Salir Dialogo Particion";
	public static final String ELIMINAR_PARTICION = "Eliminar Particion";
	public static final String CREAR_DIALOG_AGR_PROCESO = "Crear Dialogo Agregar Proceso";
	public static final String SALIR_DIALOG_AGR_PROCESO = "Salir Dialogo Agregar Proceso";
	public static final String ELIMINAR_DIALOG_EL_PROCESO = "Eliminar Dialogo Eliminar Proceso";
	public static final String SALIR_DIALOG_EL_PROCESO = "Salir Dialogo Eliminar Proceso";
	public static final String ELIMINAR_PROCESO = "Eliminar Proceso";
	public static final String EDITAR_PARTICION = "Editar Particion";
	public static final String GUARDAR_DIALOG_EDIT_PARTICION = "Guardar dialogo Editar particion";
	public static final String SALIR_DIALOG_EDIT_PARTICION = "Salir dialogo editar particion";
	public static final String GUARDAR_DIALOG_EDIT_PROCESO = "Guardar dialogo editar proceso";
	public static final String SALIR_DIALOG_EDIT_PROCESO = "Salir dialogo editar proceso";
	public static final String EDITAR_PROCESO = "Editar proces";
	public static final String INICIAR = "Iniciar";
	public static final String REINICIAR = "Reiniciar";

	private JFInicial jf;
	private JDialogAgregarProceso jDialogAgregarProceso;
	private JDialogAgregarParticion jDialogAgregarParticion;
	private jDialogEliminarParticion jDialogEliminarParticion;
	private jDialogEliminarProceso jDialogEliminarProceso;
	private JDialogEditarParticion jDialogEditarParticion;
	private JDialogEditarProceso jDialogEditarProceso;

	Procesador procesador;


	public Controlador() {
		jf= new JFInicial(this);
		procesador= new Procesador();
		jDialogAgregarProceso= new JDialogAgregarProceso(this);
		jDialogAgregarParticion = new JDialogAgregarParticion(this);
		jDialogEliminarParticion = new jDialogEliminarParticion(this);
		jDialogEliminarProceso = new jDialogEliminarProceso(this);
		jDialogEditarParticion = new JDialogEditarParticion(this);
		jDialogEditarProceso = new JDialogEditarProceso(this);
		jf.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case SALIR:
			jf.dispose();	
			break;
		case ADD_PROCESO:
			if (procesador.getParticiones().size()!=0) {
				jDialogAgregarProceso.setVisible(true);	
			}else JOptionPane.showMessageDialog(null, "Primero ingresa particiones para poder ingresar el proceso");
			break;
		case ADD_PARTICION:
			jDialogAgregarParticion.setVisible(true);
			break;
		case SALIR_DIALOG_PARTICION:
			jDialogAgregarParticion.dispose();
			break;
		case CREAR_DIALOG_PARTICION:
			crearParticion();
			break;
		case ELIMINAR_PARTICION:
			if (procesador.getParticiones().size()!=0) {
				jDialogEliminarParticion.setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Primero ingresa particiones para poder eliminarlas");
			break;
		case SALIR_DIALOG_EL_PART:
			jDialogEliminarParticion.dispose();
			break;
		case ELIMINAR_DIALOG_EL_PART:
			procesador.eliminarParticion(String.valueOf(jDialogEliminarParticion.getjComboBoxNombre().getSelectedItem()));
			agregarATextParticion(procesador.getParticiones(), jf.getJPanelData().getjTextAreaParticiones());
			JOptionPane.showMessageDialog(null, "La particion fue eliminada");
			jDialogEliminarParticion.dispose();
			break;
		case CREAR_DIALOG_AGR_PROCESO:
			crearProceso();
			break;
		case SALIR_DIALOG_AGR_PROCESO:
			jDialogAgregarProceso.dispose();
			break;
		case ELIMINAR_DIALOG_EL_PROCESO:
			procesador.eliminarProceso(String.valueOf(jDialogEliminarProceso.getjComboBoxNombre().getSelectedItem()));
			agregarATextProcesos(procesador.getProcesos(), jf.getJPanelData().getjTextAreaProcesos());
			JOptionPane.showMessageDialog(null,"El proceso fue eliminado");
			jDialogEliminarProceso.dispose();
			break;
		case SALIR_DIALOG_EL_PROCESO:		
			jDialogEliminarProceso.dispose();
			break;
		case ELIMINAR_PROCESO:
			if (!procesador.getProcesos().isEmpty()) {
				jDialogEliminarProceso.setVisible(true);
			}else JOptionPane.showMessageDialog(null, "Primero ingresa Procesos para poder eliminarlos");
			break;
		case EDITAR_PARTICION:
			if (!procesador.getParticiones().isEmpty()) {
				cargaEditarParticion(String.valueOf(jDialogEditarParticion.getjComboBoxParticion().getSelectedItem()));
				jDialogEditarParticion.setVisible(true);
				
			}else JOptionPane.showMessageDialog(null, "Primero ingresa Particiones para poder editarlas");
			break;
		case GUARDAR_DIALOG_EDIT_PARTICION:
			procesador.guardaEditarParticion(String.valueOf(jDialogEditarParticion.getjComboBoxParticion().getSelectedItem()), jDialogEditarParticion.getjTextFieldNombreParticion().getText(), Integer.parseInt(jDialogEditarParticion.getjTextFieldTamañoParticion().getText()));
			refrescarJTextParticion(procesador.getParticiones(), jf.getJPanelData().getjTextAreaParticiones());
			break;
		case SALIR_DIALOG_EDIT_PARTICION:
			jDialogEditarParticion.dispose();
			break;
		case GUARDAR_DIALOG_EDIT_PROCESO:
			procesador.guardaEditarProceso(String.valueOf(jDialogEditarProceso.getjComboBoxProceso().getSelectedItem()), jDialogEditarProceso.getTxtNombre().getText(), Integer.parseInt(jDialogEditarProceso.getTxtTiempo().getText()), String.valueOf(jDialogEditarProceso.getJComboBoxParticion().getSelectedItem()), Integer.parseInt(jDialogEditarProceso.getTxtTamanio().getText()));
			refrescarJTextProceso(procesador.getProcesos(), jf.getJPanelData().getjTextAreaProcesos());
			break;
		case SALIR_DIALOG_EDIT_PROCESO:
			jDialogEditarProceso.dispose();
			break;
		case INICIAR:
			jf.getJPanelData().getjPanelAgrupacionParticiones().crearPanelesParticiones();
			jf.paintAll(jf.getGraphics());
			for (int i = 0; i < procesador.getParticiones().size(); i++) {
				System.out.println(jf.getJPanelData().getjPanelAgrupacionParticiones().consultarNombrePanelParticion(i).getName());
			}
			procesador.procesar();
			agregarListas();
			break;
		case REINICIAR:
			procesador.reinicar();
			jf.getJPanelData().getjPanelAgrupacionParticiones().reiniciar();
			jf.getJPanelData().reiniciar();
			reiniciarListas();
			break;
		case EDITAR_PROCESO:
			if (!procesador.getProcesos().isEmpty()) {
				jDialogEditarProceso.setVisible(true);
				cargaEditarProceso(String.valueOf(jDialogEditarProceso.getjComboBoxProceso().getSelectedItem()));
			}else JOptionPane.showMessageDialog(null, "Primero ingresa Procesos para poder editarlos");
			break;
		default:
			break;
		}
	}

	public void crearParticion() {
		
		if (jDialogAgregarParticion.validarDatos(procesador.getParticiones())==null) {
			String nombre=jDialogAgregarParticion.getjTextFieldNombreParticion().getText();
			int tamanio=Integer.parseInt(jDialogAgregarParticion.getjTextFieldTamañoParticion().getText());
			Particion particion= new Particion(nombre,tamanio );
			procesador.getParticiones().add(particion);
			jDialogAgregarProceso.getBxParticion().addItem(particion.getNombre());
			jDialogEliminarParticion.getjComboBoxNombre().addItem(particion.getNombre());
			jDialogEditarParticion.getjComboBoxParticion().addItem(particion.getNombre());
			jDialogEditarProceso.getJComboBoxParticion().addItem(particion.getNombre());
			agregarATextParticion(procesador.getParticiones(),jf.getJPanelData().getjTextAreaParticiones());
			jf.getJPanelData().repaint();
			jDialogAgregarParticion.limpiar();
			jDialogAgregarParticion.setVisible(false);
		}else  JOptionPane.showMessageDialog(null, jDialogAgregarParticion.validarDatos(procesador.getParticiones()));
	}

	public void crearProceso() {
		if (jDialogAgregarProceso.validarDatos(procesador.getProcesos())==null) {
			if (jDialogAgregarProceso.validarDatos(procesador.getProcesos())==null) {
				String nombre= jDialogAgregarProceso.getTxtNombre().getText();
				int tamanio= Integer.parseInt(jDialogAgregarProceso.getTxtTamanio().getText());
				int tiempo= Integer.parseInt(jDialogAgregarProceso.getTxtTiempo().getText());
				Particion particion= procesador.buscarParticion(String.valueOf(jDialogAgregarProceso.getBxParticion().getSelectedItem()));
				Proceso proceso= new Proceso(nombre, tiempo, tamanio, particion);
				procesador.getProcesos().add(proceso);
				jDialogEliminarProceso.getjComboBoxNombre().addItem(proceso.getNombre());
				jDialogEditarProceso.getjComboBoxProceso().addItem(proceso.getNombre());
				agregarATextProcesos(procesador.getProcesos(),jf.getJPanelData().getjTextAreaProcesos());
				jf.getJPanelData().getjTextAreaProcesos().repaint();
				jDialogAgregarProceso.limpiar();
				jDialogAgregarProceso.setVisible(false);
			}
		}else JOptionPane.showMessageDialog(null, jDialogAgregarProceso.validarDatos(procesador.getProcesos()));
	}

	public void agregarATextProcesos(ArrayList<Proceso> lista, JTextArea text) {
		String texto="";
		if (!lista.isEmpty()) {
			for (int i = 0; i < lista.size(); i++) {
				texto+="\n"+lista.get(i).getNombre()+"\t tamaño: "+lista.get(i).getTamanio()+"\t tiempo: "+lista.get(i).getTiempo();
				text.setText("\t "+ texto);
				text.repaint();
			}
		}else text.setText(texto);
	}

	public void agregarListas() {
		agregarAListos();
		agregarATerminados();
		agregarAEjecutados();
		agregarANoEjecutados();
	}

	public void agregarATextParticion(ArrayList<Particion> lista,JTextArea jTextArea) {
		String texto="";
		if (!lista.isEmpty()) {
			for (int i = 0; i < lista.size(); i++) {
				texto+= "\n"+lista.get(i).getNombre()+"\t tamaño: "+lista.get(i).getTamanio();
				jTextArea.setText("\t "+texto);
				jTextArea.repaint();
			}
		}else jTextArea.setText(texto);
	}
	
	public void reiniciarListas() {
		JPanelParticion aux=null;
		for (int i = 0; i < procesador.getParticiones().size(); i++) {
			aux= jf.getJPanelData().getjPanelAgrupacionParticiones().consultarNombrePanelParticion(i);
			aux.getjTextAreaEjecutados().setText("");
			aux.getjTextAreaFinalizados().setText("");
			aux.getjTextAreaListos().setText("");
			aux.getjTextAreaNoEjecutados().setText("");
		}
	}
	public void agregarAListos() {
		String text="";
		JPanelParticion aux = null;
		for (int i = 0; i < procesador.getParticiones().size(); i++) {
			aux= jf.getJPanelData().getjPanelAgrupacionParticiones().consultarNombrePanelParticion(i);
			for (int k = 0; k < procesador.getParticiones().get(i).getListos().size(); k++) {
				text+="\n"+procesador.getParticiones().get(i).getListos().get(k).getNombre();
				aux.getjTextAreaListos().setText(text);
			}
		}
		text="";
	}
	
	public void agregarAEjecutados() {
		String text="";
		JPanelParticion aux = null;
		for (int i = 0; i < procesador.getParticiones().size(); i++) {
			aux= jf.getJPanelData().getjPanelAgrupacionParticiones().consultarNombrePanelParticion(i);
			for (int j = 0; j < procesador.getParticiones().get(i).getEjecutados().size(); j++) {
				text+="\n"+procesador.getParticiones().get(i).getEjecutados().get(j).getNombre();
				aux.getjTextAreaEjecutados().setText(text);				
			}
		}
	}
	
	public void agregarANoEjecutados() {
		String text="";
		JPanelParticion aux=null;
		for (int i = 0; i < procesador.getParticiones().size(); i++) {
			 aux= jf.getJPanelData().getjPanelAgrupacionParticiones().consultarNombrePanelParticion(i);
			for (int j = 0; j < procesador.getParticiones().get(i).getNoEjecutados().size(); j++) {
				text+="\n"+procesador.getParticiones().get(i).getNoEjecutados().get(j).getNombre();
				aux.getjTextAreaNoEjecutados().setText(text);
			}
		}
	}
	public void agregarATerminados() {
		String text="";
		JPanelParticion aux=null;
		for (int i = 0; i < procesador.getParticiones().size(); i++) {
			aux= jf.getJPanelData().getjPanelAgrupacionParticiones().consultarNombrePanelParticion(i);
			for (int j = 0; j < procesador.getParticiones().get(i).getTerminados().size(); j++) {
				text+="\n"+procesador.getParticiones().get(i).getTerminados().get(j).getNombre();
				aux.getjTextAreaFinalizados().setText(text);
			}
		}
	}
	public void cargaEditarParticion(String nombreParticion) {
		for (int i = 0; i < procesador.getParticiones().size(); i++) {
			if (procesador.getParticiones().get(i).getNombre().equals(nombreParticion)) {
				jDialogEditarParticion.getjTextFieldNombreParticion().setText(procesador.getParticiones().get(i).getNombre());
				jDialogEditarParticion.getjTextFieldTamañoParticion().setText(Integer.toString(procesador.getParticiones().get(i).getTamanio()));
			}
		}
	}
	public void cargaEditarProceso(String nombreProceso) {
		for (int i = 0; i < procesador.getProcesos().size(); i++) {
			if (procesador.getProcesos().get(i).getNombre().equals(nombreProceso)) {
				jDialogEditarProceso.getTxtNombre().setText(procesador.getProcesos().get(i).getNombre());
				jDialogEditarProceso.getTxtTamanio().setText(Integer.toString(procesador.getProcesos().get(i).getTamanio()));
				jDialogEditarProceso.getJComboBoxParticion().setSelectedItem(procesador.getProcesos().get(i).getParticion());
				jDialogEditarProceso.getTxtTiempo().setText(Integer.toString(procesador.getProcesos().get(i).getTiempo()));
			}
		}
	}
	public void refrescarJTextParticion(ArrayList<Particion> lista,JTextArea jTextArea) {
		String texto="";
		if (!lista.isEmpty()) {
			for (int i = 0; i < lista.size(); i++) {
				texto+= "\n"+lista.get(i).getNombre()+"\t tamaño: "+lista.get(i).getTamanio();
				jTextArea.setText("\t "+texto);
				jTextArea.repaint();
			}
		}else jTextArea.setText(texto);
	}
	public void refrescarJTextProceso(ArrayList<Proceso> lista,JTextArea jTextArea) {
		String texto="";
		if (!lista.isEmpty()) {
			for (int i = 0; i < lista.size(); i++) {
				texto+= "\n"+lista.get(i).getNombre()+"\t tamaño: "+lista.get(i).getTamanio();
				jTextArea.setText("\t "+texto);
				jTextArea.repaint();
			}
		}else jTextArea.setText(texto);
	}

	public Procesador getProcesador() {
		return procesador;
	}
	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	} 
}
