package co.edu.unbosque.model;

public class Estacion {

    String nombre;
    int numEstacion;

    public Estacion() {

    }

    public Estacion(String nom) {
        this.nombre = nom;
        this.numEstacion = -1;
    }

    public Estacion(int nom) {
        this.numEstacion = nom;
    }

    public Estacion(String nom, int numEst) {
        this.nombre = nom;
        this.numEstacion = numEst; // Corregido aquí
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumEstacion() {
		return numEstacion;
	}
	public void setNumEstacion(int numEstacion) {
		this.numEstacion = numEstacion;
	}
	public boolean equals(Object e) {
		return this.numEstacion == ((Estacion)e).numEstacion;
	}

	@Override
	public String toString() {
		return "Estacion [nombre=" + nombre + ", numEstacion=" + numEstacion + "]";
	}
}
