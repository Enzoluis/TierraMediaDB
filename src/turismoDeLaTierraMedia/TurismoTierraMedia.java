package turismoDeLaTierraMedia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TurismoTierraMedia {
	private final static String DIRECTORIO = "C:\\Users\\salin\\eclipse-workspace\\turismoTierraMedia\\Archivos\\";
	private List<Usuario> usuarios;
	private List<Atraccion> atracciones;
	private List<Promocion> promociones;
	private List<Producto> ofertasLista;

	public void crearItinerario() throws IOException {

		this.usuarios = LectorDeUsuario.leerUsuario(DIRECTORIO + "Usuario.txt");
		this.atracciones = LectorDeAtracciones.leerAtracciones(DIRECTORIO + "Atracciones.txt");
		this.promociones = LectorDePromociones.leerPromociones(DIRECTORIO + "Promociones.txt", atracciones);
		this.ofertasLista = new ArrayList<Producto>();

		this.ofertasLista.addAll(promociones);
		this.ofertasLista.addAll(atracciones);

		for (Usuario usuario : usuarios) {
			this.ofertasLista.sort(new CompararPorPreferencia(usuario.getAtraccionPreferida()));
			/*
			 * for (Producto producto : ofertasLista) { System.out.println(producto);
			 * System.out.println(
			 * "---------------------------------------------------------------------------------"
			 * ); } //se corrobora el buen ordenamiento
			 */
			sugerirOfertasAlUsuario(usuario, (ArrayList<Producto>) ofertasLista);
			System.out.println("Tu itinerario es: \n" + usuario.mostrarItinerario());
			escribirItinerario(usuario); // Guardamos un archivo con las ofertas aceptadas
		}
	}

	private static void sugerirOfertasAlUsuario(Usuario usuario, ArrayList<Producto> ofertasLista) {
		Scanner sc = new Scanner(System.in);
		String respuesta = "";
		System.out.print("---------------------------------------------------------------------------------");
		System.out.println("\n\tBienvenido " + usuario.getNombre() + ", mira las ofertas para armar tu itinerario");
		System.out.println("---------------------------------------------------------------------------------");

		for (Producto oferta : ofertasLista) {
			if ((usuario.getOro() >= oferta.getCosto()) && (usuario.getTiempoDispobible() >= oferta.getTiempoDeVisita())
					&& (oferta.tieneCupo()) && (!usuario.getItinerario().contains(oferta))) {

				System.out.println(oferta.toString() + "\n\t\t ¿Te interesa aceptar esta oferta?\n"
						+ "\n Si -----> y\n No -----> n");
				System.out.println("\t\tOro disponible: " + usuario.getOro() + " monedas." + "| Tiempo disponible:"
						+ usuario.getTiempoDispobible() + " horas.");

				do {
					System.out.print("-> ");
					respuesta = sc.next();
					System.out.println(
							"---------------------------------------------------------------------------------");

					if (!(respuesta.equals("y") || respuesta.equals("n")))
						System.out.println("Respuesta invalida ");
				} while (!(respuesta.equals("y") || respuesta.equals("n")));

				if (respuesta.equals("y")) {
					usuario.agregarItinerario(oferta);
					oferta.restarCupo();
				}
			}
		}
	}

	private static void escribirItinerario(Usuario usuario) throws IOException {
		PrintWriter salida = null;
		try {
			salida = new PrintWriter(new FileWriter(DIRECTORIO + usuario.getNombre() + ".txt"));
			salida.println("Turismo de la Tierra Media\n");
			salida.println("Usuario: " + usuario.getNombre());
			salida.println("Preferencias: " + usuario.getAtraccionPreferida() + "\n");
			salida.println("ITINERARIO:");
			salida.println(usuario.mostrarItinerario());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			salida.close();
		}
	}
}