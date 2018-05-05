package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import controlador.Controlador;

public class JFInicial extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanelMenu jpmenu;
	private JPaneldata jpdata;
	private JSplitPane splitPane;
	
	public JFInicial(Controlador controlador) {

		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		jpdata= new JPaneldata(controlador);
		JScrollPane scpane= new JScrollPane(jpdata);
		this.add(scpane,BorderLayout.CENTER);
	
		jpmenu = new JPanelMenu(controlador);
		this.add(jpmenu,BorderLayout.WEST);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpmenu, jpdata);
		splitPane.setOneTouchExpandable(true);
		/*
		 * Aca le dices que tan ancho es el panel de los botones
		 */
		splitPane.setDividerLocation(250);
		
		Dimension minimumSize = new Dimension(100, 50);
		jpmenu.setMinimumSize(minimumSize);
		jpdata.setMinimumSize(minimumSize);
		
		this.add(splitPane);
	}

	public JPaneldata getJPanelData() {
		return jpdata;
	}

	public void setJpdata(JPaneldata jpdata) {
		this.jpdata = jpdata;
	}
	
	

}
