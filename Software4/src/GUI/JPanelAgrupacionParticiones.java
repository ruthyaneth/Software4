package GUI;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controlador.Controlador;

public class JPanelAgrupacionParticiones extends JPanel {

	private JPanelParticion jPanelParticion;
	private Controlador controlador;
	private ArrayList<JPanelParticion> nombrePaneles;
	
 	private static final long serialVersionUID = 1L;

	public JPanelAgrupacionParticiones(Controlador controlador) {
		this.controlador = controlador;
		nombrePaneles = new ArrayList<>();
	}
	
	public void crearPanelesParticiones() {

		for (int i = 0; i < controlador.getProcesador().getParticiones().size(); i++) {
			jPanelParticion = new JPanelParticion();
			JScrollPane panelParticion = new JScrollPane(jPanelParticion);
			panelParticion.setPreferredSize(new Dimension(600, 600));
			panelParticion.setBorder(BorderFactory.createTitledBorder(controlador.getProcesador().getParticiones().get(i).getNombre()));
			jPanelParticion.setName("jPanelParticion"+i);
			nombrePaneles.add(jPanelParticion);
			this.add(panelParticion);
		}
	}
	
	public JPanelParticion consultarNombrePanelParticion(int num) {
		
		JPanelParticion aux1 = null;
		for (int i = 0; i < controlador.getProcesador().getParticiones().size(); i++) {
			aux1= nombrePaneles.get(num);
		}
		return aux1;
	}
	public void reiniciar() {
		jPanelParticion.getjTextAreaEjecutados().setText("");
		jPanelParticion.getjTextAreaFinalizados().setText("");
		jPanelParticion.getjTextAreaListos().setText("");
		jPanelParticion.getjTextAreaNoEjecutados().setText("");
		
	}
	public JPanelParticion getjPanelParticion() {
		return jPanelParticion;
	}

	public void setjPanelParticion(JPanelParticion jPanelParticion) {
		this.jPanelParticion = jPanelParticion;
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public ArrayList<JPanelParticion> getNombrePaneles() {
		return nombrePaneles;
	}

	public void setNombrePaneles(ArrayList<JPanelParticion> nombrePaneles) {
		this.nombrePaneles = nombrePaneles;
	}
}
