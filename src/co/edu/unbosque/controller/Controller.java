package co.edu.unbosque.controller;

import co.edu.unbosque.model.Algoritmo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import co.edu.unbosque.model.AdministradorRuta;
import co.edu.unbosque.model.Lista;
import co.edu.unbosque.model.Nodo;
import co.edu.unbosque.vista.FramePrincipal;

/**
 * La clase Controller controla la lógica principal de la aplicación.
 */

public class Controller implements ActionListener {

	private AdministradorRuta generadorRuta;

	private Algoritmo al;

	private FramePrincipal fp;

	/**
	 * Constructor de la clase Controller.
	 */
	public Controller() {

		fp = new FramePrincipal();

		generadorRuta = new AdministradorRuta(20);

		al = new Algoritmo();
		ejecutarAlgoritmo();
		funcionar();

	}

	/**
	 * Método principal que maneja las opciones del menú.
	 */
	private void funcionar() {

		fp.getPp().getBtn_1().addActionListener(this);
		fp.getPp().getBtn_2().addActionListener(this);
		fp.getPp().getBtn_3().addActionListener(this);
		fp.getPp().getBtn_4().addActionListener(this);
		fp.getPp().getBtn_5().addActionListener(this);
		fp.getPp().getBtn_6().addActionListener(this);
		fp.getPp().getBtn_7().addActionListener(this);

	}

	/**
	 * Maneja eventos de acción.
	 *
	 * @param e Objeto de evento de acción.
	 */
	public void actionPerformed(ActionEvent e) {

		int op = Integer.parseInt(e.getActionCommand());

		switch (op) {
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
				editar();
				break;
			case 5:
				allRutas();
				break;
			case 6:
				rutaRapida();
				break;
			case 7:
				agregarConexiones();
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				JOptionPane.showMessageDialog(null, "gracias por entrar");
			default:
				JOptionPane.showMessageDialog(null, "Incorrect option,please selected diferent option");

		}

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
			generadorRuta.nuevoArco(1, 0, 2);
			generadorRuta.nuevoArco(2, 1, 2);
			generadorRuta.nuevoArco(3, 1, 1);
			generadorRuta.nuevoArco(4, 2, 1);
			generadorRuta.nuevoArco(6, 4, 5);
			generadorRuta.nuevoArco(5, 3, 14);
			generadorRuta.nuevoArco(7, 5, 2);
			generadorRuta.nuevoArco(8, 5, 2);
			generadorRuta.nuevoArco(7, 6, 1);
			generadorRuta.nuevoArco(10, 6, 2);
			generadorRuta.nuevoArco(9, 6, 2);
			generadorRuta.nuevoArco(12, 7, 1);
			generadorRuta.nuevoArco(11, 8, 1);
			generadorRuta.nuevoArco(14, 9, 2);
			generadorRuta.nuevoArco(15, 10, 2);
			generadorRuta.nuevoArco(13, 11, 2);
			generadorRuta.nuevoArco(12, 11, 6);
			generadorRuta.nuevoArco(15, 12, 2);
			generadorRuta.nuevoArco(16, 15, 2);
			generadorRuta.nuevoArco(17, 15, 2);
			generadorRuta.nuevoArco(18, 17, 2);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/**
	 * Método para insertar una estación en el grafo.
	 */
	public void insertar() {

		try {
			String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de estacion:", "Agregar",
					JOptionPane.QUESTION_MESSAGE);

			if (nombre != null && !nombre.isEmpty()) {
				generadorRuta.agregarEstacion(nombre);
				JOptionPane.showMessageDialog(null, "Estación agregada exitosamente", "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "El nombre de la estación no puede estar vacío", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar la estación", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para buscar una estación en el grafo.
	 */
	public void buscar() {
		try {
			String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de estacion:", "Buscar",
					JOptionPane.QUESTION_MESSAGE);

			if (nombre != null && !nombre.isEmpty()) {
				// Llamada al método buscarEstacion y obtener el resultado
				String estacionEncontrada = generadorRuta.buscarEstacion(nombre);

				if (estacionEncontrada != null) {
					// Mostrar información de la estación encontrada
					JOptionPane.showMessageDialog(null, "Estación encontrada: " + estacionEncontrada, "Resultado",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró la estación con el nombre proporcionado",
							"Resultado",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "El nombre de la estación no puede estar vacío", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar la estación", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para eliminar una estación del grafo.
	 */
	public void eliminar() {
		try {
			String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la estación a eliminar", "Eliminar",
					JOptionPane.QUESTION_MESSAGE);

			if (nombre != null && !nombre.isEmpty()) {
				// Llamada al método eliminar y obtener el resultado
				String resultado = generadorRuta.eliminar(nombre);

				// Mostrar el resultado en un JOptionPane
				JOptionPane.showMessageDialog(null, resultado, "Resultado de la eliminación",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "El nombre de la estación no puede estar vacío", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar la estación", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para encontrar la ruta más rápida entre dos estaciones.
	 */
	public void rutaRapida() {
		int[] distancia = new int[20];
		int[] anteriores = new int[20];

		try {
			String salida = JOptionPane.showInputDialog(null, "Ingrese nombre de salida", "Ruta rápida",
					JOptionPane.QUESTION_MESSAGE);

			if (salida != null && !salida.isEmpty()) {
				int salidaint = generadorRuta.buscar(salida);

				String llegada = JOptionPane.showInputDialog(null, "Ingrese nombre de la llegada", "Ruta rápida",
						JOptionPane.QUESTION_MESSAGE);

				if (llegada != null && !llegada.isEmpty()) {
					int llegadaint = generadorRuta.buscar(llegada);

					// Calcular la ruta más corta
					al.calcularRutaMasCorta(generadorRuta, salidaint, distancia, anteriores);

					// Recuperar la ruta más corta
					Lista rutaMasCorta = al.recuperarRutaMasCorta(anteriores, salidaint, llegadaint);

					if (rutaMasCorta != null) {
						Nodo actual = rutaMasCorta.getCabeza();

						// Crear un JTextArea para mostrar la ruta
						JTextArea textArea = new JTextArea();

						// Establecer el JTextArea como no editable
						textArea.setEditable(false);

						while (actual != null) {
							int estacionActual = actual.getDatos();
							textArea.append(generadorRuta.getNodos()[estacionActual].getEs().getNombre());

							if (actual.getReferencia() != null) {
								int estacionSiguiente = actual.getReferencia().getDatos();
								int peso = generadorRuta.getMatrizAdyacencia()[estacionActual][estacionSiguiente];

								textArea.append(" (Distancia: " + peso + " km) -> ");
							}

							actual = actual.getReferencia();
						}

						// Mostrar el JTextArea en un JScrollPane si es necesario
						JScrollPane scrollPane = new JScrollPane(textArea);
						JOptionPane.showMessageDialog(null, scrollPane, "Ruta más corta",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"No hay una ruta disponible entre las estaciones seleccionadas", "Ruta no encontrada",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "El nombre de la estación de llegada no puede estar vacío",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "El nombre de la estación de salida no puede estar vacío", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error al calcular la ruta más corta", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para imprimir todas las rutas entre dos estaciones.
	 */
	public void allRutas() {
		try {
			String salida = JOptionPane.showInputDialog(null, "Ingresar nombre de salida:", "Rutas",
					JOptionPane.QUESTION_MESSAGE);

			if (salida != null && !salida.isEmpty()) {
				try {
					int salidaint = generadorRuta.buscar(salida);
					String llegada = JOptionPane.showInputDialog(null, "Ingrese nombre de  llegada:", "Conexiones",
							JOptionPane.QUESTION_MESSAGE);
					int llegadaint = generadorRuta.buscar(llegada);
					String allrutas = al.imprimirTodasLasRutasDesdeHasta(generadorRuta, salidaint, llegadaint);

					System.out.println(allrutas);

					JTextArea textArea = new JTextArea(10, 30);
					textArea.setText(allrutas);
					JScrollPane scrollPane = new JScrollPane(textArea);
					JOptionPane.showMessageDialog(null, scrollPane, "Rutas", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e) {
				}
			} else {
				JOptionPane.showMessageDialog(null, "El nombre de la estación no puede estar vacío", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar la estación", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Método para agregar conexiones entre estaciones.
	 */
	public void agregarConexiones() {
		try {
			String salida = JOptionPane.showInputDialog(null, "Ingresar ruta de salida:", "Conexiones",
					JOptionPane.QUESTION_MESSAGE);

			if (salida != null && !salida.isEmpty()) {
				try {
					int salidaint = generadorRuta.buscar(salida);
					String salida1 = JOptionPane.showInputDialog(null, "Ingrese ruta de  llegada:", "Conexiones",
							JOptionPane.QUESTION_MESSAGE);
					int llegadaint = generadorRuta.buscar(salida1);
					int distancia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese distancia en Km:",
							"Conexiones", JOptionPane.QUESTION_MESSAGE));

					generadorRuta.nuevoArco(salidaint, llegadaint, distancia);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ocurrió un error!", "Error", JOptionPane.ERROR_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "El nombre de la estación no puede estar vacío", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar la estación", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Método para editar el nombre de una estación.
	 */
	public void editar() {
		try {
			String nombreAntiguo = JOptionPane.showInputDialog(null, "Ingrese el nombre de la estación:", "Editar",
					JOptionPane.QUESTION_MESSAGE);

			if (nombreAntiguo != null && !nombreAntiguo.isEmpty()) {
				String nuevoNombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre:", "Editar",
						JOptionPane.QUESTION_MESSAGE);

				if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
					// Llamada al método editarEstacionNombre y obtener el resultado
					String resultado = generadorRuta.editarEstacionNombre(nombreAntiguo, nuevoNombre);

					// Mostrar el resultado en un JOptionPane
					JOptionPane.showMessageDialog(null, resultado, "Resultado de la edición",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "El nuevo nombre no puede estar vacío", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "El nombre de la estación no puede estar vacío", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocurrió un error al editar la estación", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
