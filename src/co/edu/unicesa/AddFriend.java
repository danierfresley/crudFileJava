package co.edu.unicesa;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class AddFriend {

	public static void main(String[] args) {
		
		try {
			Scanner scanner = new Scanner(System.in);
			
			String nombreNumeroString;
			String nombre;
			String numero;
			
			boolean encontrado = false;
			
			System.out.print("Digite el nombre: ");
			String nuevoNombre = scanner.next();
			
			System.out.print("Digite el numero celular: ");
			String nuevoNumero = scanner.next();
			
			File file = new File("amigosContactos.txt");
			
			if(!file.exists()) {
				file.createNewFile();
			}
			
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			
			while(raf.getFilePointer() < raf.length()) {
				
				nombreNumeroString = raf.readLine();
				String lineaSplit[] = nombreNumeroString.split("!");
				nombre = lineaSplit[0];
				numero = lineaSplit[1];
				
				if(nombre.equals(nuevoNombre) || numero.equals(nuevoNumero)) {
					encontrado = true;
					break;
				}
				 
			}
			
			if(encontrado == false) {
				nombreNumeroString = nuevoNombre + "!" + nuevoNumero;
				raf.writeBytes(nombreNumeroString);
				raf.writeBytes(System.lineSeparator());
				System.out.println("Amigo agregado");
				raf.close();
			} else {
				raf.close();
				System.out.println("Nombre o numero de ingreso existe");
			}
			
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		
		
	}

}
