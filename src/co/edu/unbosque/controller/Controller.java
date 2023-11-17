package co.edu.unbosque.controller;

import co.edu.unbosque.model.Algoritmo;
import co.edu.unbosque.model.Estacion;
import co.edu.unbosque.model.GeneradorRuta;
import co.edu.unbosque.model.Lista;
import co.edu.unbosque.vista.Vista;

public class Controller {

    private GeneradorRuta generadorRuta;
    private Vista vista;

    public Controller() {
        this.generadorRuta = new GeneradorRuta(20); // Puedes ajustar el tamaño según tus necesidades
        this.vista = new Vista();
    }

    public void ejecutarAlgoritmo() {
        try {
            generadorRuta.agregarEstacion(0);
            generadorRuta.agregarEstacion(1);
            generadorRuta.agregarEstacion(2);
            generadorRuta.agregarEstacion(3);
            generadorRuta.agregarEstacion(4);
            generadorRuta.agregarEstacion(5);
            generadorRuta.agregarEstacion(6);
            generadorRuta.agregarEstacion(7);
            generadorRuta.agregarEstacion(8);
            generadorRuta.agregarEstacion(9);
            generadorRuta.agregarEstacion(10);
            generadorRuta.agregarEstacion(11);
            generadorRuta.agregarEstacion(12);
            generadorRuta.agregarEstacion(13);
            generadorRuta.agregarEstacion(14);
            generadorRuta.agregarEstacion(15);
            generadorRuta.agregarEstacion(16);
            generadorRuta.agregarEstacion(17);
            generadorRuta.agregarEstacion(18);
            generadorRuta.nuevoArco(0, 1, 1);
            generadorRuta.nuevoArco(1, 2, 2);
            generadorRuta.nuevoArco(1, 3, 2);
            generadorRuta.nuevoArco(2, 4, 1);
			generadorRuta.nuevoArco(4, 6, 1);
			generadorRuta.nuevoArco(3, 5, 5);
			generadorRuta.nuevoArco(5, 7, 2);
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
			generadorRuta.nuevoArco(12, 15, 2);
			generadorRuta.nuevoArco(15, 16, 2);
			generadorRuta.nuevoArco(15, 17, 2);
			generadorRuta.nuevoArco(17, 18, 2);
            int salida = 0;
            int destino = 6;
            int[] distancia = new int[20]; // Puedes ajustar el tamaño según tus necesidades
            int[] anteriores = new int[20]; // Puedes ajustar el tamaño según tus necesidades

            Algoritmo.calcularRutaMasCorta(generadorRuta, salida, distancia, anteriores);
            Lista rutaMasCorta = Algoritmo.recuperarRutaMasCorta(anteriores, salida, destino);

            // Muestra los resultados en la consola
            vista.mostrarDistanciaMinima(salida, destino, distancia[destino]);
            vista.mostrarRuta(rutaMasCorta.toString().toString());
            vista.mostrarMensaje("Operación completada con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    // Otros métodos según sea necesario


}
