package turismoDeLaTierraMedia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LectorDePromociones {
	static List<Promocion> promociones = new ArrayList<Promocion>();

	public static List<Promocion> leerPromociones(String archivo, List<Atraccion> atracciones) {

		File f = new File(archivo);
		Scanner sc = null;
		String[] datos;

		try {

			sc = new Scanner(f);

			while (sc.hasNextLine()) {
				datos = sc.nextLine().split(";");

				String nombre = datos[0];
				switch (nombre) {
				case "Absoluta":
					double costo = Integer.parseInt(datos[datos.length - 1]);
					Promocion promoAbsoluta = new PromocionesAbsolutas(tratarAtracciones(datos, atracciones), nombre,
							TipoAtraccion.valueOf(datos[1]), costo);
					promociones.add(promoAbsoluta);
					break;

				case "AxB":
					Promocion promoAxB = new PromocionesAxB(tratarAtracciones(datos, atracciones), nombre,
							TipoAtraccion.valueOf(datos[1]));
					promociones.add(promoAxB);
					break;

				case "Porcentual":
					double descuento = Integer.parseInt(datos[datos.length - 1]);
					Promocion promoPorcenctual = new PromocionesPorcentuales(tratarAtracciones(datos, atracciones),
							nombre, TipoAtraccion.valueOf(datos[1]), descuento);
					promociones.add(promoPorcenctual);
					break;
				}
			}

		} catch (IOException e) {
			// Si hay algun problema en la lectura se muestra la traza de la pila
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}

		finally {
			sc.close();
		}
		return promociones;
	}

	private static ArrayList<Atraccion> tratarAtracciones(String[] datos, List<Atraccion> atracciones) {
		int cantidadDeAtracciones = Integer.parseInt(datos[2]);
		ArrayList<Atraccion> packPromo = new ArrayList<Atraccion>();

		for (int i = 3; i < 3 + cantidadDeAtracciones; i++) {
			for (Atraccion atraccion : atracciones) {
				if (atraccion.getNombre().equals(datos[i])) {
					packPromo.add(atraccion);
				}
			}
		}
		return packPromo;
	}
}