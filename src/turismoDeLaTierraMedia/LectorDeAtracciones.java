package turismoDeLaTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeAtracciones {

	public static ArrayList<Atraccion> leerAtracciones(String archivo) {
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = br.readLine();

			while ((linea != null)) {
				String datos[] = linea.split(",");
				String nombre = datos[0];
				Double costo = Double.parseDouble(datos[1]);
				Double tiempoVisita = Double.parseDouble(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				String atraccion = datos[4];

				// agrego esa atraccion a la lista, siempre y cuando no esté repetida
				Atraccion p = new Atraccion(nombre, costo, tiempoVisita, TipoAtraccion.valueOf(atraccion.toUpperCase()),
						cupo);

				if (!atracciones.contains(p))
					atracciones.add(p);

				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return atracciones;
	}
}
