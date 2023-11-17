package co.edu.unbosque.vista;

import co.edu.unbosque.model.Lista;

public class Vista {

    public void mostrarRuta(Lista ruta) {
        System.out.println("Ruta: " + ruta);
    }

    public void mostrarDistanciaMinima(int salida, int llegada, int distancia) {
        System.out.println("Distancia mínima desde " + salida + " a " + llegada + ": " + distancia);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Otros métodos de impresión según sea necesario
}
