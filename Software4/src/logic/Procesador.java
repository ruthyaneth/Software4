package logic;

import java.util.ArrayList;

public class Procesador {

	private ArrayList<Particion> particiones;
	private ArrayList<Proceso> procesos;
	public static int cuantum=5;

	public Procesador() {
		particiones= new ArrayList<>();
		procesos= new ArrayList<>();
	}

	public void procesar() {
		agregarAlistos();
		for (int i = 0; i < particiones.size(); i++) {
			Particion particion=particiones.get(i);
			for (int j = 0; j < particion.getListos().size(); j++) {
				Proceso proceso=particion.getListos().get(j);
				if (proceso.getTamanio()<=particion.getTamanio()) {
					particion.getEjecutados().add(proceso);
					ejecutar(particion, proceso);
				}else {particion.getNoEjecutados().add(proceso);}
			}

		}
	}

	public void agregarAlistos() {
		for (int j = 0; j < particiones.size(); j++) {
			for (int i = 0; i < procesos.size(); i++) {
				Particion particion= particiones.get(j);
				Proceso proceso= procesos.get(i);
				if (proceso.getParticion().getNombre().equals(particion.getNombre())){
					particion.getListos().add(proceso);
				}
			}
		}

	}

	public void ejecutar(Particion  particion, Proceso proceso) {
		proceso.setTiempo(proceso.getTiempo()-cuantum);			

		if (proceso.getTiempo()>=cuantum) {	
			particion.getListos().add(proceso);
		}else { 
			particion.getTerminados().add(proceso);
		}
	}

	public ArrayList<Particion> getParticiones() {
		return particiones;
	}


	public void setParticiones(ArrayList<Particion> particiones) {
		this.particiones = particiones;
	}


	public ArrayList<Proceso> getProcesos() {
		return procesos;
	}


	public void setProcesos(ArrayList<Proceso> procesos) {
		this.procesos = procesos;
	}


	public Particion buscarParticion(String nombre) {
		for (int i = 0; i < particiones.size(); i++) {
			if (particiones.get(i).getNombre().equals(nombre)) {
				return particiones.get(i);
			}
		}
		return null;
	}

	public void eliminarParticion(String  Nombreparticion) {
		for (int i = 0; i < particiones.size(); i++) {
			if (particiones.get(i).getNombre().equals(Nombreparticion)) {
				particiones.remove(particiones.get(i));
			}
		}
	}
	public void guardaEditarParticion(String nombreParticion,String nuevoNombre, int tamaño) {
		for (int i = 0; i < particiones.size(); i++) {
			if (particiones.get(i).getNombre().equals(nombreParticion)) {
				particiones.get(i).setNombre(nuevoNombre);
				particiones.get(i).setTamanio(tamaño);
			}
		}
	}
	public void guardaEditarProceso(String nombreParticion,String nuevoNombre, int tiempo, String particion, int tamaño) {
		for (int i = 0; i < procesos.size(); i++) {
			if (procesos.get(i).getNombre().equals(nombreParticion)) {
				procesos.get(i).setNombre(nuevoNombre);
				procesos.get(i).setTiempo(tiempo);
//				procesos.get(i).setParticion(particion);
				procesos.get(i).setTamanio(tamaño);
			}
		}
	}
	

	public void eliminarProceso(String nombreproceso) {
		for (int i = 0; i < procesos.size(); i++) {
			if (procesos.get(i).getNombre().equals(nombreproceso)) {
				procesos.remove(procesos.get(i));
			}
		}
	}	
	public void reinicar() {
		for (int i = 0; i < particiones.size(); i++) {
			particiones.get(i).getListos().clear();
			particiones.get(i).getTerminados().clear();
			particiones.get(i).getEjecutados().clear();
			particiones.get(i).getNoEjecutados().clear();
		}
	}
}
