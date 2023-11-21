package co.edu.unbosque.model;

public class Nodo {
    int datos;
    Estacion es;
    Nodo referencia;

    public Nodo(int x) {
        datos = x;
    }
  
    public Nodo(Estacion e) {
        es = e;
    }
  
   

	public int getDatos() {
		return datos;
	}

	@Override
	public String toString() {
		return "Nodo [datos=" + datos + ", es=" + es + ", referencia=" + referencia + "]";
	}

	public void setDatos(int datos) {
		this.datos = datos;
	}



	public Nodo getReferencia() {
		return referencia;
	}

	public void setReferencia(Nodo referencia) {
		this.referencia = referencia;
	}

	public Estacion getEs() {
		return es;
	}

	public void setEs(Estacion es) {
		this.es = es;
	}
	
	
}
