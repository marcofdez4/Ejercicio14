package ejercicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Artista;

public class Programa {

	public static void main(String[] args) {
		//Artistas de prueba
		Artista a3 = new Artista("Slayer","Metal", 50000, "Venezuela");
		Artista a4 = new Artista("Green day","Rock alternativo", 100200, "California");
		Artista a5 = new Artista("Motorhead","Rock & roll", 9999999, "Inglaterra");
		
		List<Artista> artistas= new ArrayList<>();
		artistas.add(a3);
		artistas.add(a4);
		artistas.add(a5);
		
		String rutaSalida = "src\\ejercicio\\salidaSpotify.txt";
		try {
			File archivoSalida = new File(rutaSalida);
			if (!archivoSalida.exists()) {
				archivoSalida.createNewFile();
			}
			FileWriter fw = new FileWriter(archivoSalida);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("PROGRAMA DE SPOTIFY\n\n");
			for(Artista a: artistas) {
				bw.write("\nNombre del artista: "+a.getNombre());
				bw.write("\ngenero: "+a.getGenero());
				bw.write("\nnumero de reproducciones: "+a.getNumeroReproducciones());
				bw.write("\npais mas escuchado: "+a.getPaisMasEscucha());
				bw.write("\n--------------------------------------------------");
			}
			Scanner sc = new Scanner(System.in);
			
			int menu = 99;
			while(menu!=0) {
				System.out
				.println("Ingrese una operacion:\n" + "1. Registrar artista\n" +"2. Ver lista de artistas\n"+ "0. Salir y generar txt");
				
				menu = sc.nextInt();
				switch (menu) {
				case 0:
					bw.close();
					sc.close();
					break;
				case 1:
					Artista addArtist = registraArtista(bw, sc);
					bw.write("\nNombre del artista: "+addArtist.getNombre());
					bw.write("\ngenero: "+addArtist.getGenero());
					bw.write("\nnumero de reproducciones: "+addArtist.getNumeroReproducciones());
					bw.write("\npais mas escuchado: "+addArtist.getPaisMasEscucha());
					bw.write("\n--------------------------------------------------");
					artistas.add(addArtist); 
					break;
				case 2:
					if(artistas.isEmpty()) {
						System.out.println("La lista esta vacía!");
					}
					else {
						System.out.println("La lista de artistas es:");
						for(Artista art: artistas) {
							System.out.println(art.getNombre());
						}
					}
					break;
				default:
					System.out.println("numero erroneo, inserte otro numero de la lista");
				}	
				System.out.println("-------------------------------------------------");
			}
		}
		catch(IOException io) {
			
		}
	}
	public static Artista registraArtista(BufferedWriter bw, Scanner sc) {
		System.out.println("Ingresando artista...");
		System.out.println("Nombre: ");
		sc.nextLine();
		String nombre = sc.nextLine();
		System.out.println("Genero: ");
		String genero = sc.nextLine();
		System.out.println("numero de reproducciones: ");
		Boolean numCorrecto = false;
		Integer numeroRepro = null;
		while(!numCorrecto) {
			
			try {
				String numeroStrin = sc.nextLine();
				numeroRepro = Integer.valueOf(numeroStrin);
				numCorrecto=true;
			} 
			catch(Exception e) {
				System.out.println("debes de introducir un numero: ");
				continue;
			}
			
		}
		System.out.println("pais mas escuchado: ");
		String pais = sc.nextLine();
		
		return new Artista(nombre, genero, numeroRepro, pais);
		
		

	}
}
