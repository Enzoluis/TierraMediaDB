package turismoDeLaTierraMedia;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private double oro;
	private double tiempoDispobible;
	private TipoAtraccion atraccionPreferida;
	private ArrayList<Producto> itinerario;

	public Usuario(String nombre, double oro, double tiempoDispobible, TipoAtraccion atraccionPreferida) {
		this.nombre = nombre;
		this.oro = oro;
		this.tiempoDispobible = tiempoDispobible;
		this.atraccionPreferida = atraccionPreferida;
		this.itinerario = new ArrayList<Producto>();
	}

	public void agregarItinerario(Producto oferta) {
		this.itinerario.add(oferta);
		this.setOro(oferta.getCosto());
		this.setTiempoDispobible(oferta.getTiempoDeVisita());
	}

	public double getTiempoDispobible() {
		return tiempoDispobible;
	}

	public void setTiempoDispobible(double tiempoVisita) {
		this.tiempoDispobible -= tiempoVisita;
	}

	public String mostrarItinerario() {
		String visitasElegidas = "";
		double tiempoTotal = 0;
		double costoTotal = 0;
		DecimalFormat df = new DecimalFormat("###.##");

		for (Producto visita : this.itinerario) {
			visitasElegidas += "\t" + visita.getNombre() + "\n";
			costoTotal += visita.getCosto();
			tiempoTotal += visita.getTiempoDeVisita();
		}

		return "Visitas: \n" + visitasElegidas + "\nCosto Total: " 
				+ df.format(costoTotal) + " monedas de Oro | TiempoTotal: "
				+ tiempoTotal+ " horas.";
	}

	public TipoAtraccion getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public String getNombre() {
		return nombre;
	}

	public double getOro() {
		return oro;
	}

	public void setOro(double costo) {
		this.oro -= costo;
	}

	public ArrayList<Producto> getItinerario() {
		return this.itinerario;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", Moneadas de oro=" + oro + ", tiempoDispobible=" + tiempoDispobible
				+ ", atraccionPreferida=" + atraccionPreferida + "]";
	}

}
