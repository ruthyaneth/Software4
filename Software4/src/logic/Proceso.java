package logic;

public class Proceso {
	private String nombre;
	private int tiempo;
	private int tamanio;
	private Particion particion;
	
	
	public Proceso(String nombre,int tiempo, int tamanio,Particion particion) {
		super();
		this.nombre = nombre;
		this.tamanio = tamanio;
		this.tiempo = tiempo;
		this.particion=particion;
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
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public Particion getParticion() {
		return particion;
	}
	public void setParticion(Particion particion) {
		this.particion = particion;
	}


}
