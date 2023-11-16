package co.edu.unbosque.model;

public class Algoritmo {
	static final int INFINITO=Integer.MAX_VALUE;
	
	public static void calcularRutaMasCorta(GeneradorRuta grafo,int salida, int[]distancia, int[]anteriores) {
		int g=grafo.cantidadEstaciones();
		boolean[] visitadas = new boolean[g];
		for (int i=0;i<g;i++) {
			distancia[i]=INFINITO;
			anteriores[i]=-1;
		}
		distancia[salida]=0;
		
		for(int i=salida;i<g;i++) {
			int estacionActual= obtenerEstacionNoVisitadaMinimaDistancia(salida,distancia,visitadas);
			visitadas[estacionActual]=true;
			
			for(int siguienteEstacion=0;siguienteEstacion<g;siguienteEstacion++) {
				int peso=grafo.getMatrizAdyacencia()[estacionActual][siguienteEstacion];
				if(!visitadas[siguienteEstacion]&& peso>0){
					int nuevaDistancia=distancia[estacionActual]+peso;
					if(nuevaDistancia<distancia[siguienteEstacion]) {
						distancia[siguienteEstacion]=nuevaDistancia;
						anteriores[siguienteEstacion]=estacionActual;
					}
					}
				}
		}
	}
	public static Lista recuperarRutaMasCorta(int[]anteriores,int salida, int llegada) {
		Lista ruta=new Lista();
		int nodo=llegada;
		while(nodo!=-1) {
			ruta.insertarCabeza(nodo);
			nodo=anteriores[nodo];
		}
		return ruta;
	}

	private static int obtenerEstacionNoVisitadaMinimaDistancia(int salida, int[] distancia, boolean[] visitada) {
		int minDistancia=INFINITO;
		int nodoMinDistancia=0;
		for(int i=0;i<distancia.length;i++) {
			if(!visitada[i]&&distancia[i]<minDistancia) {
				minDistancia=distancia[i];
				nodoMinDistancia=i;
			}
		}
		return nodoMinDistancia;
	}

	public static void main(String[] args) {
		int n=18;
		GeneradorRuta ruta=new GeneradorRuta(n);
		ruta.agregarEstacion(0);
		ruta.agregarEstacion(1);
		ruta.agregarEstacion(2);
		ruta.agregarEstacion(3);
		ruta.agregarEstacion(4);
		ruta.agregarEstacion(5);
		ruta.agregarEstacion(6);
		ruta.agregarEstacion(7);
		ruta.agregarEstacion(8);
		ruta.agregarEstacion(9);
		ruta.agregarEstacion(10);
		ruta.agregarEstacion(11);
		ruta.agregarEstacion(12);
		ruta.agregarEstacion(13);
		ruta.agregarEstacion(14);
		ruta.agregarEstacion(15);
		ruta.agregarEstacion(16);
		ruta.agregarEstacion(17);
		ruta.agregarEstacion(18);
		try {
			ruta.nuevoArco(0, 1, 1);
			ruta.nuevoArco(1, 2, 2);
			ruta.nuevoArco(1, 3, 2);
			ruta.nuevoArco(2, 4, 1);
			ruta.nuevoArco(4, 6, 1);
			ruta.nuevoArco(3, 5, 5);
			ruta.nuevoArco(5, 7, 2);
			ruta.nuevoArco(5, 8, 2);
			ruta.nuevoArco(6, 7, 2);
			ruta.nuevoArco(6, 10, 1);
			ruta.nuevoArco(6, 9, 2);
			ruta.nuevoArco(7, 12, 2);
			ruta.nuevoArco(8, 11, 1);
			ruta.nuevoArco(9, 14, 1);
			ruta.nuevoArco(10, 15, 2);
			ruta.nuevoArco(11, 13, 2);
			ruta.nuevoArco(11, 12, 2);
			ruta.nuevoArco(12, 15, 2);
			ruta.nuevoArco(15, 16, 2);
			ruta.nuevoArco(15, 17, 2);
			ruta.nuevoArco(17, 18, 2);
		} catch(Exception e) {
			e.printStackTrace();
		}
		int salida=0;
		int destino=6;
		int[] distancia=new int[n];
		int[] anteriores=new int[n];
		
		calcularRutaMasCorta(ruta, salida, distancia, anteriores);
		Lista rutaMasCorta=recuperarRutaMasCorta(anteriores, salida, destino);
		
		System.out.println("Distancia minima desde "+ salida + " a "+ destino +": " +distancia[destino]);
		System.out.println("Ruta más corta: "+ rutaMasCorta);
	}
	
}
