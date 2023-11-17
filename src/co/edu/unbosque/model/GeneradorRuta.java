package co.edu.unbosque.model;

public class GeneradorRuta {
	private int numEstacion;
	public static final int MAX_VERTICES = 20;
	private Estacion[] nodos;
	private int[][] matrizAdyacencia;

	public GeneradorRuta(){	
		this (MAX_VERTICES);
	}
	
    public GeneradorRuta(int numNodos) {
        matrizAdyacencia = new int[numNodos][numNodos];
        nodos = new Estacion[numNodos];
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                matrizAdyacencia[i][j] = 0; // Corregido aquí
            }
        }
        numEstacion = 0;
    }

	public int numEstacion(int numNodo) {
		Estacion e = new Estacion(numNodo);
		boolean encontrado = false;
		int i=0;
		for(i=0;i<nodos.length;i++) {
			encontrado=nodos[i]==null?false:nodos[i].equals(e);
			if(encontrado)
					break;
		}
		return (i<numEstacion)?i:-1;
	}
	public void agregarEstacion(int numEs) {
		boolean existe=numEstacion(numEs)>=0;
		if(!existe) {
			Estacion e = new Estacion(numEs);
			e.setNumEstacion(numEstacion);
			nodos[numEstacion]=e;
			numEstacion++;
		}
	}
	public void nuevoArco(int salida, int llegada, int peso) throws Exception{
		int eS;
		int eL;
		eS=numEstacion(salida);
		eL=numEstacion(llegada);
		if(eS<0||eL<0)
			throw new Exception("La estacion no existe");
		matrizAdyacencia[eS][eL]=peso;
	}
	public boolean adyacente(int salida, int llegada) throws Exception{
		int eS;
		int eL;
		eS=numEstacion(salida);
		eL=numEstacion(llegada);
		if(eS<0||eL<0)
			throw new Exception("La estacion no existe");
		return matrizAdyacencia[eS][eL]==1;
	}	
	public int cantidadEstaciones() {
		return nodos.length;
	}

	public int getNumEstacion() {
		return numEstacion;
	}

	public void setNumEstacion(int numEstacion) {
		this.numEstacion = numEstacion;
	}

	public Estacion[] getNodos() {
		return nodos;
	}

	public void setNodos(Estacion[] nodos) {
		this.nodos = nodos;
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}

	public static int getMaxVertices() {
		return MAX_VERTICES;
	}
}