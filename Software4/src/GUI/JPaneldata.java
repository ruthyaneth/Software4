package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controlador.Controlador;
import logic.Procesador;

public class JPaneldata extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea jTextAreaProcesos;
	private JTextArea jTextAreaParticiones;
	private JPanelAgrupacionParticiones jPanelAgrupacionParticiones;
	
	public JPaneldata(Controlador controlador) {
		int contadorPaticion = 1;
		//this.setBorder(BorderFactory.createTitledBorder("Datos"));
		this.setLayout(new BorderLayout());
		
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(jScrollPane);
		
		jTextAreaParticiones= new JTextArea();
		jTextAreaParticiones.setEditable(false);
		JScrollPane panelparticiones= new JScrollPane(jTextAreaParticiones); 
		panelparticiones.setBorder(BorderFactory.createTitledBorder("Particiones"));
		panelparticiones.setPreferredSize(new Dimension(200, 200));
		this.add(panelparticiones,BorderLayout.NORTH);
		
		
		jTextAreaProcesos = new JTextArea();
		jTextAreaProcesos.setEditable(false);
		JScrollPane panelprocesos= new JScrollPane(jTextAreaProcesos);
		panelprocesos.setBorder(BorderFactory.createTitledBorder("Procesos"));
		panelprocesos.setPreferredSize(new Dimension(200, 200));
		this.add(panelprocesos, BorderLayout.CENTER);
		
		jPanelAgrupacionParticiones = new JPanelAgrupacionParticiones(controlador);
		JScrollPane panelParticion1 = new JScrollPane(jPanelAgrupacionParticiones);
		panelParticion1.setPreferredSize(new Dimension(400, 400));
		panelParticion1.setBorder(BorderFactory.createTitledBorder("Listas"));
		this.add(panelParticion1,BorderLayout.SOUTH);
	
	}
	public void reiniciar() {
		jTextAreaParticiones.setText("");
		jTextAreaProcesos.setText("");
	}

	public JTextArea getjTextAreaProcesos() {
		return jTextAreaProcesos;
	}

	public void setjTextAreaProcesos(JTextArea jTextAreaProcesos) {
		this.jTextAreaProcesos = jTextAreaProcesos;
	}

	public JTextArea getjTextAreaParticiones() {
		return jTextAreaParticiones;
	}

	public void setjTextAreaParticiones(JTextArea jTextAreaParticiones) {
		this.jTextAreaParticiones = jTextAreaParticiones;
	}
	
	public void ingresartexto(String texto) {
		jTextAreaParticiones.setText(texto);
	}

	public JPanelAgrupacionParticiones getjPanelAgrupacionParticiones() {
		return jPanelAgrupacionParticiones;
	}

	public void setjPanelAgrupacionParticiones(JPanelAgrupacionParticiones jPanelAgrupacionParticiones) {
		this.jPanelAgrupacionParticiones = jPanelAgrupacionParticiones;
	}
	
}
//listos, ejecutados, no ejecutados, finalizados