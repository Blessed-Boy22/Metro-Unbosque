package co.edu.unbosque.model;

/**
 * Clase que representa un nodo en una estructura de datos.
 */
public class Nodo {
	int datos;
	Estacion es;
	Nodo referencia;

	/**
	 * Constructor de la clase Nodo que recibe un entero como parámetro.
	 * 
	 * @param x el entero que se asignará como dato del nodo.
	 */
	public Nodo(int x) {
		datos = x;
	}

	/**
	 * Constructor de la clase Nodo que recibe una estación como parámetro.
	 * 
	 * @param e la estación que se asignará como dato del nodo.
	 */
	public Nodo(Estacion e) {
		es = e;
	}

	/**
	 * Método para obtener el dato almacenado en el nodo.
	 * 
	 * @return el dato almacenado en el nodo.
	 */
	public int getDatos() {
		return datos;
	}

	/**
	 * Método para establecer el dato del nodo.
	 * 
	 * @param datos el nuevo dato a asignar al nodo.
	 */
	public void setDatos(int datos) {
		this.datos = datos;
	}

	/**
	 * Método para obtener la referencia al siguiente nodo.
	 * 
	 * @return la referencia al siguiente nodo.
	 */
	public Nodo getReferencia() {
		return referencia;
	}

	/**
	 * Método para establecer la referencia al siguiente nodo.
	 * 
	 * @param referencia la nueva referencia al siguiente nodo.
	 */
	public void setReferencia(Nodo referencia) {
		this.referencia = referencia;
	}

	/**
	 * Método para obtener la estación almacenada en el nodo.
	 * 
	 * @return la estación almacenada en el nodo.
	 */
	public Estacion getEs() {
		return es;
	}

	/**
	 * Método para establecer la estación del nodo.
	 * 
	 * @param es la nueva estación a asignar al nodo.
	 */
	public void setEs(Estacion es) {
		this.es = es;
	}

	/**
	 * Método que devuelve una representación en cadena del nodo.
	 * 
	 * @return una cadena que representa el nodo.
	 */
	@Override
	public String toString() {
		return "Nodo [datos=" + datos + ", es=" + es + ", referencia=" + referencia + "]";
	}
}
