package logic;

import java.util.ArrayList;

public class Particion {

	private String nombre;
	private int tamanio;

	private ArrayList<Proceso>listos ;
	private ArrayList<Proceso>terminados;
	private ArrayList<Proceso> ejecutados ;
	private ArrayList<Proceso> noEjecutados;

	public Particion(String nombre, int tamanio) {
		super();
		this.nombre = nombre;
		this.tamanio = tamanio;
		listos= new ArrayList<>();
		terminados= new ArrayList<>();
		ejecutados= new ArrayList<>();
		noEjecutados= new ArrayList<>();

	}
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public ArrayList<Proceso> getListos() {
		return listos;
	}
	public void setListos(ArrayList<Proceso> listos) {
		this.listos = listos;
	}
	public ArrayList<Proceso> getTerminados() {
		return terminados;
	}
	public void setTerminados(ArrayList<Proceso> terminados) {
		this.terminados = terminados;
	}
	public ArrayList<Proceso> getEjecutados() {
		return ejecutados;
	}
	public void setEjecutados(ArrayList<Proceso> ejecutados) {
		this.ejecutados = ejecutados;
	}
	public ArrayList<Proceso> getNoEjecutados() {
		return noEjecutados;
	}
	public void setNoEjecutados(ArrayList<Proceso> noEjecutados) {
		this.noEjecutados = noEjecutados;
	}

}
