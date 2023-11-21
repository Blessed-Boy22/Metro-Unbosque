package co.edu.unbosque.model;

public class Lista {

	private Nodo cabeza;
	private int cantElementos;
	private Estacion es;

	public Lista() {
		cabeza = null;
		cantElementos = 0;
		es=es;
	}

	

	public Lista insertarCabeza2(int x) { 
		Nodo siguiente;
		int cuenta;
     
		siguiente = new Nodo(x);
		siguiente.referencia = cabeza;
		cabeza = siguiente;
		return this;
	}
	




	@Override
	public String toString() {
		return "Lista [cabeza=" + cabeza.toString() + ", cantElementos=" + cantElementos + "]";
	}

	public Nodo getCabeza() {
		return cabeza;
	}

	public void setCabeza(Nodo cabeza) {
		this.cabeza = cabeza;
	}

	public int getCantElementos() {
		return cantElementos;
	}

	public void setCantElementos(int cantElementos) {
		this.cantElementos = cantElementos;
	}
}
