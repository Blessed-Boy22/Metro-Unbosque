package co.edu.unbosque.model;

/**
 * La clase `Algoritmo` contiene métodos para realizar cálculos relacionados con
 * rutas y distancias en el grafo.
 */
public class Algoritmo {

	public static int INFINITO = Integer.MAX_VALUE;
	public static String allRutas;

	/**
	 * Calcula la ruta más corta desde una estación de salida hasta todas las demás
	 * estaciones en el grafo.
	 *
	 * @param grafo      Grafo de estaciones.
	 * @param salida     Número de la estación de salida.
	 * @param distancia  Arreglo para almacenar las distancias desde la estación de
	 *                   salida.
	 * @param anteriores Arreglo para almacenar las estaciones anteriores en la ruta
	 *                   más corta.
	 */
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
			
			e.printStackTrace();

		}
	}

	/**
	 * Recupera la ruta más corta desde la estación de salida hasta la estación de
	 * llegada.
	 *
	 * @param anteriores Arreglo de estaciones anteriores en la ruta más corta.
	 * @param salida     Número de la estación de salida.
	 * @param llegada    Número de la estación de llegada.
	 * @return Lista que representa la ruta más corta.
	 */
	public Lista recuperarRutaMasCorta(int[] anteriores, int salida, int llegada) {
		Lista ruta = new Lista();

		int nodo = llegada;
		while (nodo != -1) {
			ruta.insertarCabeza2(nodo);
			if (nodo >= 0 && nodo < anteriores.length) {
				nodo = anteriores[nodo];
			} else {
				// Manejar el caso en el que el nodo está fuera de los límites del array
				
				return ruta;
			}
		}

		return ruta;
	}

	/**
	 * Obtiene la estación no visitada con la menor distancia en el arreglo.
	 *
	 * @param salida    Número de la estación de salida.
	 * @param distancia Arreglo de distancias.
	 * @param visitada  Arreglo que indica si una estación ha sido visitada.
	 * @return Número de la estación no visitada con la menor distancia.
	 */
	private static int obtenerEstacionNoVisitadaMinimaDistancia(int salida, int[] distancia, boolean[] visitada) {
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

	/**
	 * Imprime todas las rutas posibles desde una estación de salida hasta una
	 * estación de destino.
	 *
	 * @param grafo           Grafo de estaciones.
	 * @param estacionSalida  Número de la estación de salida.
	 * @param estacionDestino Número de la estación de destino.
	 * @throws Exception Si la estación de salida o destino no son válidas.
	 */
	public String imprimirTodasLasRutasDesdeHasta(AdministradorRuta grafo, int estacionSalida, int estacionDestino)
			throws Exception {
		int salida = grafo.numEstacion(grafo.getNodos()[grafo.numEstacion(estacionSalida)].es.getNumEstacion());
		int destino = grafo.numEstacion(grafo.getNodos()[grafo.numEstacion(estacionDestino)].es.getNumEstacion());

		if (salida == -1 || destino == -1) {
			throw new Exception("Estación de salida o destino no válida. Verifique las estaciones proporcionadas.");
		}

		

		return "Rutas desde " + estacionSalida + " hasta " + estacionDestino + ":" + imprimirTodasLasRutasDFS(grafo,
				salida, destino, new int[grafo.cantidadEstaciones()], 0, 1, new boolean[grafo.cantidadEstaciones()]);
	}

	/**
	 * Método auxiliar para realizar una búsqueda en profundidad (DFS) e imprimir
	 * todas las rutas posibles.
	 *
	 * @param grafo          Grafo de estaciones.
	 * @param estacionActual Estación actual en la búsqueda.
	 * @param destino        Número de la estación de destino.
	 * @param rutaActual     Arreglo que representa la ruta actual.
	 * @param longitudActual Longitud actual de la ruta.
	 * @param numeroRuta     Número de la ruta actual.
	 */
	public String imprimirTodasLasRutasDFS(AdministradorRuta grafo, int estacionActual, int destino, int[] rutaActual,
			int longitudActual, int numeroRuta, boolean[] visitado) {
		rutaActual[longitudActual] = estacionActual;
		visitado[estacionActual] = true;

// Si se ha alcanzado el destino, construir la ruta
		if (estacionActual == destino) {
			StringBuilder ruta = new StringBuilder();

			for (int i = 0; i <= longitudActual; i++) {
				ruta.append(grafo.getNodos()[rutaActual[i]].es.getNombre());

				if (i < longitudActual) {
					int estacionActualEnRuta = rutaActual[i];
					int estacionSiguienteEnRuta = rutaActual[i + 1];
					int peso = grafo.getMatrizAdyacencia()[estacionActualEnRuta][estacionSiguienteEnRuta];

					ruta.append(" (Distancia: " + peso + "Km) -> ");
				}
			}

// Agregar un salto de línea para separar rutas
			ruta.append("\n");

// Marcar como no visitado para otras rutas
			visitado[estacionActual] = false;

			return ruta.toString();
		}

		int numEstaciones = grafo.cantidadEstaciones();
		StringBuilder allRutas = new StringBuilder();

		for (int i = 0; i < numEstaciones; i++) {
			int peso = grafo.getMatrizAdyacencia()[estacionActual][i];

			if (peso > 0 && !visitado[i]) {
				allRutas.append(imprimirTodasLasRutasDFS(grafo, i, destino, rutaActual, longitudActual + 1, numeroRuta,
						visitado));
			}
		}

// Marcar como no visitado para otras rutas
		visitado[estacionActual] = false;

		return allRutas.toString();
	}

}
