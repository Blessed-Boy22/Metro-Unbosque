package co.edu.unbosque.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaConsola {
private Scanner read;
	
	public VistaConsola() {
		read= new Scanner(System.in);
	}	
	
	 /**
     * Lee una cadena de texto ingresada por el usuario.
     *
     * @param message El mensaje que se muestra al usuario antes de la entrada.
     * @return La cadena de texto ingresada por el usuario.
     */
	public String ReadString(String message){
		System.out.println(message);
		String ms = read.nextLine();
		return ms;
	}
	
	/**
     * Lee un entero ingresado por el usuario.
     *
     * @param message El mensaje que se muestra al usuario antes de la entrada.
     * @return El entero ingresado por el usuario.
     */
	public int ReadInteger(String message){
		int msg = 0;
		boolean output = false;
		do{
			System.out.println(message);
			try{
				msg = read.nextInt();
				output = true;
			}catch(InputMismatchException ex){
				System.out.println("El dato ingresado esta erroneo");
				msg = 0;
			}finally{
				read.nextLine();
			}
		}while(!output);
		return msg;
	}

	 /**
     * Muestra un mensaje al usuario.
     */
	public void SeeInfo(Object object){
		System.out.println(object);
	}

	/**
     * Lee un número decimal de punto flotante ingresado por el usuario.
     *
     * @param message El mensaje que se muestra al usuario antes de la entrada.
     * @return El número decimal de punto flotante ingresado por el usuario.
     */
	public float ReadFloat(String message) {
		System.out.println(message);
		float msg=read.nextFloat();
		read.nextLine();

		return msg;

	}
}
