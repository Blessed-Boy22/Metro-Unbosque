package co.edu.unbosque.model;

import java.util.Iterator;

public class Lista {

    private Nodo cabeza;
    private int cantElementos;

    public Lista() {
        cabeza = null;
        cantElementos = 0;
    }

    public Lista insertarCabeza(String x) { // Cambiado el nombre del método
        Nodo siguiente;
        int cuenta;

        siguiente = new Nodo(x);
        siguiente.referencia = cabeza;
        cabeza = siguiente;
        return this;
    }
	public void buscar(String x){
		Nodo anterior, actual;
		boolean find=false;
		actual = cabeza;
		anterior = null;
		while(actual !=null && !find) {
			if(!find) {
				anterior=actual;
				actual=actual.referencia;
			}
			if(actual!=null) {
				if(actual==cabeza);
				cabeza=actual.referencia;
				}
			}
	}
		
	public void eliminar(String z) {
		Nodo anterior, actual;
		boolean find=false;
		actual = cabeza;
		anterior = null;
		while(actual !=null && !find) {
			find =(actual.dato.equals(z));
			if(!find) {
				anterior=actual;
				actual=actual.referencia;
			}
			if(actual!=null) {
				if(actual==cabeza);
				cabeza=actual.referencia;
		}else {
			anterior.referencia=actual.referencia;
			actual.referencia=null;
			}
		}
	}

	@Override
	public String toString() {
		return "Lista [cabeza=" + cabeza + ", cantElementos=" + cantElementos + "]";
	}
}
							
