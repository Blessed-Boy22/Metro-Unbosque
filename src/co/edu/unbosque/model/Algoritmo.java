package co.edu.unbosque.model;



public class Algoritmo {
   public int INFINITO = Integer.MAX_VALUE;
public Algoritmo() {
	// TODO Auto-generated constructor stub
}
public void calcularRutaMasCorta(AdministradorRuta grafo, int salida, int[] distancia, int[] anteriores) {
    try {
        int g = grafo.cantidadEstaciones();
        boolean[] visitadas = new boolean[g];
        for (int i = 0; i < g; i++) {
            distancia[i] = INFINITO;
            anteriores[i] = -1;
        }
        distancia[salida] = 0;

        for (int i = 0; i < g; i++) {
        	 int estacionActual = obtenerEstacionNoVisitadaMinimaDistancia(salida, distancia, visitadas);
            visitadas[estacionActual] = true;

            for (int siguienteEstacion = 0; siguienteEstacion < g; siguienteEstacion++) {
                int peso = grafo.getMatrizAdyacencia()[estacionActual][siguienteEstacion];
                if (!visitadas[siguienteEstacion] && peso > 0) {
                    int nuevaDistancia = distancia[estacionActual] + peso;
                    // Verificar si hay riesgo de desbordamiento antes de actualizar la distancia
                    if (nuevaDistancia < distancia[siguienteEstacion] && nuevaDistancia >= 0) {
                        distancia[siguienteEstacion] = nuevaDistancia;
                        anteriores[siguienteEstacion] = estacionActual;
                    }
                }
            }
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        // Manejar la excepción
        System.err.println("Error: Ruta no existente");
        e.printStackTrace();
        // También puedes lanzar una nueva excepción personalizada si es necesario.
        // throw new MiExcepcion("Mensaje de error personalizado", e);
    }
}
  
   public Lista recuperarRutaMasCorta(int[] anteriores, int salida, int llegada) {
	    Lista ruta = new Lista();

	    // Verificar si la salida existe en el grafo
	    if (salida < 0 || salida >= anteriores.length || anteriores[salida] == -1) {
	        System.out.println("Error: Ruta no existente.");
	        return ruta;
	    }

	    int nodo = llegada;
	    while (nodo != -1) {
	        ruta.insertarCabeza2(nodo);
	        if (nodo >= 0 && nodo < anteriores.length) {
	            nodo = anteriores[nodo];
	        } else {
	            // Manejar el caso en el que el nodo está fuera de los límites del array
	            System.out.println("Error: Índice de nodo fuera de los límites.");
	            return ruta;
	        }
	    }

	    return ruta;
	}

    private  int obtenerEstacionNoVisitadaMinimaDistancia(int salida, int[] distancia, boolean[] visitada) {
        int minDistancia = INFINITO;
        int nodoMinDistancia = 0;
        for (int i = 0; i < distancia.length; i++) {
            if (!visitada[i] && distancia[i] < minDistancia) {
                minDistancia = distancia[i];
                nodoMinDistancia = i;
            }
        }
        return nodoMinDistancia;
    }	
    public  void imprimirTodasLasRutasDesdeHasta(AdministradorRuta grafo, int estacionSalida, int estacionDestino) throws Exception {
        int salida = grafo.numEstacion(grafo.getNodos()[grafo.numEstacion(estacionSalida)].es.getNumEstacion());
        int destino = grafo.numEstacion(grafo.getNodos()[grafo.numEstacion(estacionDestino)].es.getNumEstacion());

        if (salida == -1 || destino == -1) {
            throw new Exception("Estación de salida o destino no válida");
        }

        System.out.println("Rutas desde " + estacionSalida + " hasta " + estacionDestino + ":");

        imprimirTodasLasRutasDFS(grafo, salida, destino, new int[grafo.cantidadEstaciones()], 0, 1);
    }

    public  void imprimirTodasLasRutasDFS(AdministradorRuta grafo, int estacionActual, int destino, int[] rutaActual, int longitudActual, int numeroRuta) {
        rutaActual[longitudActual] = estacionActual;

        if (estacionActual == destino) {
            System.out.print("Ruta " + numeroRuta + ": ");
            for (int i = 0; i <= longitudActual; i++) {
                System.out.print(grafo.getNodos()[rutaActual[i]].es.getNombre());
                if (i < longitudActual) {
                    int estacionActualEnRuta = rutaActual[i];
                    int estacionSiguienteEnRuta = rutaActual[i + 1];
                    int peso = grafo.getMatrizAdyacencia()[estacionActualEnRuta][estacionSiguienteEnRuta];
                    System.out.print(" (Distancia: " + peso + ") -> ");
                }
            }
            System.out.println();
            return;
        }

        int numEstaciones = grafo.cantidadEstaciones();
        for (int i = 0; i < numEstaciones; i++) {
            int peso = grafo.getMatrizAdyacencia()[estacionActual][i];
            if (peso > 0) {
                imprimirTodasLasRutasDFS(grafo, i, destino, rutaActual, longitudActual + 1, numeroRuta);
            }
        }
    }
    
    
	
}
