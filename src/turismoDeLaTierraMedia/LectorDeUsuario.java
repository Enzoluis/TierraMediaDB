package turismoDeLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorDeUsuario {

	public static ArrayList<Usuario> leerUsuario(String archivo) throws IOException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		Scanner sc = null;
		try {
			sc = new Scanner(new File(archivo));

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(";");

				try {
					String nombre = datos[0];
					String preferencia = datos[1];
					double oro = Double.parseDouble(datos[2]);
					double tiempo = Double.parseDouble(datos[3]);
					Usuario p = new Usuario(nombre, oro, tiempo, TipoAtraccion.valueOf(preferencia));

					if (!usuarios.contains(p))
						usuarios.add(p);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage() + " no es un numero");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Hay un error en el ingreso de los datos");
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return usuarios;
	}

}
