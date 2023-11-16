package co.edu.unbosque.model;

public class Nodo {
	
	String dato;
	Nodo referencia;
	
	public Nodo(String x) {
		dato=x;
	}
	public Nodo(String x,Nodo s) {
		dato=x;
		referencia=s;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public Nodo getReferencia() {
		return referencia;
	}
	public void setReferencia(Nodo referencia) {
		this.referencia = referencia;
	}

	
}
