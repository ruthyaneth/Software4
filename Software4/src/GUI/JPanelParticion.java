package GUI;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JPanelParticion extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea jTextAreaListos;
	private JTextArea jTextAreaEjecutados;
	private JTextArea jTextAreaNoEjecutados;
	private JTextArea jTextAreaFinalizados;
	
	public JPanelParticion() {
		
		this.setBorder(null);
		
		jTextAreaListos = new JTextArea();
		JScrollPane areaListos = new JScrollPane(jTextAreaListos);
		areaListos.setPreferredSize(new Dimension(100, 550));
		areaListos.setBorder(BorderFactory.createTitledBorder("Listos"));
		this.add(areaListos);
		
		jTextAreaEjecutados = new JTextArea();
		JScrollPane areaEjecutados = new JScrollPane(jTextAreaEjecutados);
		areaEjecutados.setPreferredSize(new Dimension(100, 550));
		areaEjecutados.setBorder(BorderFactory.createTitledBorder("Ejecutados"));
		this.add(areaEjecutados);
		
		jTextAreaNoEjecutados = new JTextArea();
		JScrollPane areaNoEjecutados = new JScrollPane(jTextAreaNoEjecutados);
		areaNoEjecutados.setPreferredSize(new Dimension(100, 550));
		areaNoEjecutados.setBorder(BorderFactory.createTitledBorder("No Ejecutados"));
		this.add(areaNoEjecutados);
		
		jTextAreaFinalizados = new JTextArea();
		JScrollPane areaFinalizados = new JScrollPane(jTextAreaFinalizados);
		areaFinalizados.setPreferredSize(new Dimension(100, 550));
		areaFinalizados.setBorder(BorderFactory.createTitledBorder("Finalizados"));
		this.add(areaFinalizados);
	}
	

	public JTextArea getjTextAreaListos() {
		return jTextAreaListos;
	}

	public void setjTextAreaListos(JTextArea jTextAreaListos) {
		this.jTextAreaListos = jTextAreaListos;
	}

	public JTextArea getjTextAreaEjecutados() {
		return jTextAreaEjecutados;
	}

	public void setjTextAreaEjecutados(JTextArea jTextAreaEjecutados) {
		this.jTextAreaEjecutados = jTextAreaEjecutados;
	}

	public JTextArea getjTextAreaNoEjecutados() {
		return jTextAreaNoEjecutados;
	}

	public void setjTextAreaNoEjecutados(JTextArea jTextAreaNoEjecutados) {
		this.jTextAreaNoEjecutados = jTextAreaNoEjecutados;
	}

	public JTextArea getjTextAreaFinalizados() {
		return jTextAreaFinalizados;
	}

	public void setjTextAreaFinalizados(JTextArea jTextAreaFinalizados) {
		this.jTextAreaFinalizados = jTextAreaFinalizados;
	}
	
}
//listos, ejecutados, no ejecutados, finalizados