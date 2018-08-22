package ApiPersona.util;

import java.io.*;

public class CopiAndWrite {
	private static String numero;
	public static String leer() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("ultimo.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				numero=linea;
				return linea;
				
			}
			return null;
				//System.out.println(linea);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void escribir() {
		FileWriter fichero = null;
		PrintWriter pw = null;
		leer();
		try {
			fichero = new FileWriter("ultimo.txt");
			pw = new PrintWriter(fichero);
			
			pw.print(Integer.parseInt(numero)+1);
			//for (int i = 0; i < 10; i++)
				//pw.println("Linea " + i);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
