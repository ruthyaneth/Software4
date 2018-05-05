package test;

import java.util.ArrayList;

import logic.Particion;
import logic.Procesador;
import logic.Proceso;

public class TestLogic {
	public static void main(String[] args) {

		Procesador procesador= new Procesador();


		Particion particion1=new Particion("PP1",15);
		Particion particion2=new Particion("PP2",15);
		Particion particion3=new Particion("PP3",15);




		Proceso proceso1 = new Proceso("P1", 5, 10, particion1);
		Proceso proceso2 = new Proceso("P2", 10, 10, particion1);
		Proceso proceso3 = new Proceso("P3", 8, 20, particion2);
		Proceso proceso4 = new Proceso("P4", 3, 10, particion3);

		procesador.getParticiones().add(particion1);
		procesador.getParticiones().add(particion2);
		procesador.getParticiones().add(particion3);

		procesador.getProcesos().add(proceso1);
		procesador.getProcesos().add(proceso2);
		procesador.getProcesos().add(proceso3);
		procesador.getProcesos().add(proceso4);




		procesador.procesar();
		for (int i = 0; i < procesador.getParticiones().size(); i++) {
			System.out.println("Listos particion "+i);
			imprimir(procesador.getParticiones().get(i).getListos());
			System.out.println("ejecutados particion "+i);
			imprimir(procesador.getParticiones().get(i).getEjecutados());
			System.out.println("No ejecutados particion "+i);
			imprimir(procesador.getParticiones().get(i).getNoEjecutados());
			System.out.println("Terminados"+i);
			imprimir(procesador.getParticiones().get(i).getTerminados());
			
		}




	}

	public static void imprimir(ArrayList<Proceso> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNombre());
		}
	}


}
