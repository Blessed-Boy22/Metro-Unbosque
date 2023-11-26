package co.edu.unbosque.model;

/**
 * Esta clase representa una lista enlazada.
 */
public class Lista {

	private Nodo cabeza;
	private int cantElementos;
	

	public Lista() {
		cabeza = null;
		cantElementos = 0;
	
	}

	/**
	 * Inserta un elemento al inicio de la lista.
	 * 
	 * @param x el elemento a insertar
	 * @return la lista actualizada
	 */
	public Lista insertarCabeza2(int x) {
		Nodo siguiente;
		int cuenta;

		siguiente = new Nodo(x);
		siguiente.referencia = cabeza;
		cabeza = siguiente;
		return this;
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

	@Override
	public String toString() {
		return "Lista [cabeza=" + cabeza.toString() + ", cantElementos=" + cantElementos + "]";
	}
}
