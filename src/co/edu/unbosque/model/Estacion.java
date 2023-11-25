package co.edu.unbosque.model;

/**
 * Esta clase representa una estación en el sistema del metro.
 */
public class Estacion {

	String nombre;
	int numEstacion;

	public Estacion() {

	}

	public Estacion(int num) {
		this.numEstacion = num;
	}

	public Estacion(String nom, int numEst) {
		this.nombre = nom;
		this.numEstacion = numEst; // Corregido aquí
	}

	/**
	 * Obtiene el nombre de la estación.
	 * 
	 * @return el nombre de la estación
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la estación.
	 * 
	 * @param nombre el nombre de la estación
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el número de la estación.
	 * 
	 * @return el número de la estación
	 */
	public int getNumEstacion() {
		return numEstacion;
	}

	/**
	 * Establece el número de la estación.
	 * 
	 * @param numEstacion el número de la estación
	 */
	public void setNumEstacion(int numEstacion) {
		this.numEstacion = numEstacion;
	}

	@Override
	public boolean equals(Object e) {
		return this.numEstacion == ((Estacion) e).numEstacion;
	}

	@Override
	public String toString() {
		return "Estacion [nombre=" + nombre + ", numEstacion=" + numEstacion + "]";
	}
}
