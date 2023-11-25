package co.edu.unbosque.model;

/**
 * La clase `AdministradorRuta` gestiona la red de estaciones y las conexiones
 * entre ellas.
 */
public class AdministradorRuta {

	private int numEstacion;
	public static final int MAX_VERTICES = 20;
	private Nodo[] nodos;
	private int[][] matrizAdyacencia;

	/**
	 * Constructor por defecto que utiliza el número máximo de vértices permitidos.
	 */
	public AdministradorRuta() {
		this(MAX_VERTICES);
	}

	/**
	 * Constructor que permite especificar el número de nodos en la red.
	 *
	 * @param numNodos Número de nodos en la red.
	 */
	public AdministradorRuta(int numNodos) {
		matrizAdyacencia = new int[numNodos][numNodos];
		nodos = new Nodo[numNodos];
		for (int i = 0; i < numNodos; i++) {
			for (int j = 0; j < numNodos; j++) {
				matrizAdyacencia[i][j] = 0;
			}
		}
		numEstacion = 0;
	}

	/**
	 * Método para obtener el número de estación correspondiente a un número de
	 * nodo.
	 *
	 * @param numNodo Número del nodo.
	 * @return Número de estación correspondiente, o -1 si no se encuentra.
	 */
	public int numEstacion(int numNodo) {
		Estacion e = new Estacion(numNodo);
		boolean encontrado = false;
		int i = 0;
		for (i = 0; i < nodos.length; i++) {
			encontrado = nodos[i] == null ? false : nodos[i].es.equals(e);
			if (encontrado)
				break;
		}
		return (i < numEstacion) ? i : -1;
	}

	/**
	 * Agrega una nueva estación a la red.
	 *
	 * @param nombre Nombre de la nueva estación.
	 */
	public void agregarEstacion(String nombre) {
		Estacion es = new Estacion(nombre, numEstacion);
		Nodo e = new Nodo(es);

		nodos[numEstacion] = e;
		numEstacion++;
	}

	/**
	 * Crea una nueva conexión entre dos estaciones con un peso especificado.
	 *
	 * @param salida  Número de estación de salida.
	 * @param llegada Número de estación de llegada.
	 * @param peso    Peso de la conexión.
	 * @throws Exception Si alguna de las estaciones no existe.
	 */
	public void nuevoArco(int salida, int llegada, int peso) throws Exception {
		int eS;
		int eL;
		eS = numEstacion(salida);
		eL = numEstacion(llegada);
		if (eS < 0 || eL < 0)
			throw new Exception("La estacion no existe");
		matrizAdyacencia[eS][eL] = peso;
	}

	/**
	 * Verifica si dos estaciones son adyacentes.
	 *
	 * @param salida  Número de estación de salida.
	 * @param llegada Número de estación de llegada.
	 * @return `true` si son adyacentes, `false` en caso contrario.
	 * @throws Exception Si alguna de las estaciones no existe.
	 */
	public boolean adyacente(int salida, int llegada) throws Exception {
		int eS;
		int eL;
		eS = numEstacion(salida);
		eL = numEstacion(llegada);
		if (eS < 0 || eL < 0)
			throw new Exception("La estacion no existe");
		return matrizAdyacencia[eS][eL] == 1;
	}

	/**
	 * Busca una estación por su nombre y devuelve su índice.
	 *
	 * @param nombre Nombre de la estación a buscar.
	 * @return Índice de la estación, o -1 si no se encuentra.
	 */
	public int buscar(String nombre) {
		for (int i = 0; i < numEstacion; i++) {
			if (nodos[i] != null && nodos[i].es.nombre.equalsIgnoreCase(nombre)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Busca una estación por su nombre y muestra información sobre ella.
	 *
	 * @param nombre Nombre de la estación a buscar.
	 * @return Información sobre la estación encontrada o un mensaje si no se
	 *         encuentra.
	 */
	public String buscarEstacion(String nombre) {
		for (int i = 0; i < numEstacion; i++) {
			if (nodos[i] != null && nodos[i].es.nombre.equalsIgnoreCase(nombre)) {
				Estacion estacion = nodos[i].es;
				System.out.println("Nombre: " + estacion.getNombre() + ", Número: " + estacion.getNumEstacion());
				return "Nombre: " + estacion.getNombre() + ", Número: " + estacion.getNumEstacion();
				// Puedes agregar otros detalles de la estación según tus necesidades
			}
		}
		return "La estación " + nombre + " no se encontró.";
	}

	/**
	 * Edita el nombre de una estación existente.
	 *
	 * @param nombreAntiguo Nombre antiguo de la estación.
	 * @param nuevoNombre   Nuevo nombre de la estación.
	 */
	public void editarEstacionNombre(String nombreAntiguo, String nuevoNombre) {
		int indiceEstacion = buscar(nombreAntiguo);
		if (indiceEstacion != -1) {
			// Guarda el número de estación antes de la edición
			int numEstacionAntiguo = nodos[indiceEstacion].es.getNumEstacion();

			// Actualiza el nombre
			nodos[indiceEstacion].es.setNombre(nuevoNombre);

			// Si el número de estación cambió, vuelve a asignar el número anterior
			if (numEstacionAntiguo != nodos[indiceEstacion].es.getNumEstacion()) {
				nodos[indiceEstacion].es.setNumEstacion(numEstacionAntiguo);
			}
		} else {
			System.out.println("La estación " + nombreAntiguo + " no se encontró.");
		}
	}

	/**
	 * Elimina una estación por su nombre.
	 *
	 * @param nombre Nombre de la estación a eliminar.
	 */
	public void eliminar(String nombre) {
		int indiceEstacion = buscar(nombre);
		if (indiceEstacion != -1) {
			for (int i = indiceEstacion; i < numEstacion - 1; i++) {
				nodos[i] = nodos[i + 1];
			}
			nodos[numEstacion - 1] = null;
			numEstacion--;
		} else {
			System.out.println("La estación " + nombre + " no se encontró.");
		}
	}

	/**
	 * Obtiene la cantidad total de estaciones en la red.
	 *
	 * @return Cantidad total de estaciones.
	 */
	public int cantidadEstaciones() {
		return nodos.length;
	}

	public int getNumEstacion() {
		return numEstacion;
	}

	public void setNumEstacion(int numEstacion) {
		this.numEstacion = numEstacion;
	}

	public Nodo[] getNodos() {
		return nodos;
	}

	public void setNodos(Nodo[] nodos) {
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
