package co.edu.unbosque.controller;

import co.edu.unbosque.model.AdministradorRuta;
import co.edu.unbosque.model.Algoritmo;
import co.edu.unbosque.model.Lista;
import co.edu.unbosque.model.Nodo;
import co.edu.unbosque.vista.VistaConsola;
import java.awt.event.ActionEvent;
import java.util.Scanner;

/**
 * La clase Controller controla la lógica principal de la aplicación.
 */
public class Controller implements ActionListener {

	private AdministradorRuta generadorRuta;
	private Scanner sc;
	private Algoritmo al;
	private VistaConsola vc;

	/**
	 * Constructor de la clase Controller.
	 */
	public Controller() {
		vc = new VistaConsola();
		sc = new Scanner(System.in);
		generadorRuta = new AdministradorRuta(20);
		al = new Algoritmo();
		ejecutarAlgoritmo();
		funcionar();

	}

	/**
	 * Método principal que maneja las opciones del menú.
	 */
	public void funcionar() {
		String menu = " 1. Agregar estacion \n 2.buscar estacion\n 3.eliminar estacion\n 4. ruta mas rapida.\n 5. todas las rutas \n 6. agregar conexiones \n 7. Editar Estacion \n  10. salir";
		int option = 0;
		do {
			option = vc.ReadInteger(menu);
			switch (option) {
				case 1:
					insertar();
					break;
				case 2:
					buscar();
					break;
				case 3:
					eliminar();
					break;
				case 4:
					rutaRapida();
					break;
				case 5:
					allRutas();
					break;
				case 6:
					agregarConexiones();
					break;
				case 7:
					editar();
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					vc.SeeInfo("gracias por entrar");
				default:
					vc.SeeInfo("Incorrect option,please selected diferent option");

			}

		} while (option != 10);

	}

	/**
	 * Método para ejecutar el algoritmo.
	 */
	public void ejecutarAlgoritmo() {
		try {

			generadorRuta.agregarEstacion("Portal Ñero");
			generadorRuta.agregarEstacion("General Santander");
			generadorRuta.agregarEstacion("Santa Isabel");
			generadorRuta.agregarEstacion("Jimenez");
			generadorRuta.agregarEstacion("Comuneros");
			generadorRuta.agregarEstacion("Calle 19");
			generadorRuta.agregarEstacion("Ricaurte");
			generadorRuta.agregarEstacion("Carrera 22");
			generadorRuta.agregarEstacion("Calle 45");
			generadorRuta.agregarEstacion("Pradera");
			generadorRuta.agregarEstacion("Campin");
			generadorRuta.agregarEstacion("Heroes");
			generadorRuta.agregarEstacion("Polo");
			generadorRuta.agregarEstacion("Unbosque");
			generadorRuta.agregarEstacion("Portal Americas");
			generadorRuta.agregarEstacion("Escuela paramilitar");
			generadorRuta.agregarEstacion("Casa PostDay");
			generadorRuta.agregarEstacion("Minuto de dios");
			generadorRuta.agregarEstacion("Casa Santiaga");
			generadorRuta.nuevoArco(0, 1, 1);
			generadorRuta.nuevoArco(1, 2, 2);
			generadorRuta.nuevoArco(1, 3, 2);
			generadorRuta.nuevoArco(2, 4, 1);
			generadorRuta.nuevoArco(4, 6, 1);
			generadorRuta.nuevoArco(3, 5, 5);
			generadorRuta.nuevoArco(5, 7, 14);
			generadorRuta.nuevoArco(5, 8, 2);
			generadorRuta.nuevoArco(6, 7, 2);
			generadorRuta.nuevoArco(6, 10, 1);
			generadorRuta.nuevoArco(6, 9, 2);
			generadorRuta.nuevoArco(7, 12, 2);
			generadorRuta.nuevoArco(8, 11, 1);
			generadorRuta.nuevoArco(9, 14, 1);
			generadorRuta.nuevoArco(10, 15, 2);
			generadorRuta.nuevoArco(11, 13, 2);
			generadorRuta.nuevoArco(11, 12, 2);
			generadorRuta.nuevoArco(12, 15, 6);
			generadorRuta.nuevoArco(15, 16, 2);
			generadorRuta.nuevoArco(15, 17, 2);
			generadorRuta.nuevoArco(17, 18, 2);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * Método para insertar una estación en el grafo.
	 */
	public void insertar() {
		System.out.println("Ingrese nombre de estacion:");
		String nombre = sc.nextLine();

		generadorRuta.agregarEstacion(nombre);
	}

	/**
	 * Método para buscar una estación en el grafo.
	 */
	public void buscar() {
		System.out.println("ingrese el nombre de la estacion");
		String nombre = sc.nextLine();
		generadorRuta.buscarEstacion(nombre);
	}

	/**
	 * Método para eliminar una estación del grafo.
	 */
	public void eliminar() {
		System.out.println("ingrese el nombre de la estacion a eliminar");
		String nombre = sc.nextLine();
		generadorRuta.eliminar(nombre);
	}

	/**
	 * Método para encontrar la ruta más rápida entre dos estaciones.
	 */
	public void rutaRapida() {
		int[] distancia = new int[20];
		int[] anteriores = new int[20];
		System.out.println("Ingrese nombre de salida");
		String salida = sc.nextLine();
		int salidaint = generadorRuta.buscar(salida);
		System.out.println("Ingrese nombre de la llegada");
		String llegada = sc.nextLine();
		int llegadaint = generadorRuta.buscar(llegada);
		al.calcularRutaMasCorta(generadorRuta, salidaint, distancia, anteriores);
		Lista rutaMasCorta = al.recuperarRutaMasCorta(anteriores, salidaint, llegadaint);

		Nodo actual = rutaMasCorta.getCabeza();
		while (actual != null) {
			System.out.print(generadorRuta.getNodos()[actual.getDatos()].getEs().getNombre());

			if (actual.getReferencia() != null) {
				int estacionActual = actual.getDatos();
				int estacionSiguiente = actual.getReferencia().getDatos();
				int peso = generadorRuta.getMatrizAdyacencia()[estacionActual][estacionSiguiente];

				System.out.print(" (Distancia: " + peso + ") -> ");
			}

			actual = actual.getReferencia();
		}
	}

	/**
	 * Método para imprimir todas las rutas entre dos estaciones.
	 */
	public void allRutas() {
		try {
			System.out.println("Ingrese nombre de salida");
			String salida = sc.nextLine();
			int salidaint = generadorRuta.buscar(salida);
			System.out.println("Ingrese nombre de la llegada");
			String llegada = sc.nextLine();
			int llegadaint = generadorRuta.buscar(llegada);
			al.imprimirTodasLasRutasDesdeHasta(generadorRuta, salidaint, llegadaint);
		} catch (Exception e) {
			System.out.println("ocurrio un error");
		}
	}

	/**
	 * Método para agregar conexiones entre estaciones.
	 */
	public void agregarConexiones() {
		try {
			System.out.println("Ingresar ruta de salida");
			String salida = sc.nextLine();
			int salidaint = generadorRuta.buscar(salida);
			System.out.println("Ingrese ruta de  llegada");
			String llegada = sc.nextLine();
			int llegadaint = generadorRuta.buscar(llegada);

			int distancia = vc.ReadInteger("ingrese distancia en km");
			generadorRuta.nuevoArco(salidaint, llegadaint, distancia);
		} catch (Exception e) {
			System.out.println("ocurrio un error");
		}
	}

	/**
	 * Método para editar el nombre de una estación.
	 */
	public void editar() {
		System.out.println("Ingrese el nombre de la estacion");
		String nombre1 = sc.nextLine();
		System.out.println("Ingrese el nuevo nombre de la estacion");
		String nombre2 = sc.nextLine();
		generadorRuta.editarEstacionNombre(nombre1, nombre2);
	}

	/**
	 * Maneja eventos de acción.
	 *
	 * @param e Objeto de evento de acción.
	 */
	public void actionPerformed(ActionEvent e) {

	}
}
