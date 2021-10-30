package turismoDeLaTierraMedia;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Promocion extends Producto {

	protected ArrayList<Atraccion> miPromo;

	public Promocion(ArrayList<Atraccion> miPromo, String nombre, TipoAtraccion tipo) {
		super(nombre, tipo);
		this.miPromo = miPromo;
	}

	@Override
	public double getCosto() {
		double costos = 0;

		for (Atraccion atraccion : miPromo) {
			costos += atraccion.getCosto();
		}

		return costos;
	}

	@Override
	public double getTiempoDeVisita() {
		double tiempo = 0;

		for (Atraccion atraccion : miPromo) {
			tiempo += atraccion.getTiempoDeVisita();
		}

		return tiempo;
	}

	@Override
	public boolean tieneCupo() {
		boolean cupo = true;
		for (Atraccion atraccion : miPromo) {
			// Si alguna de las atracciones no tiene cupo no se puede ofrecer el paquete
			if (!atraccion.tieneCupo()) {
				cupo = false;
			}
		}
		return cupo;
	}

	@Override
	public void restarCupo() {
		for (Atraccion atraccion : miPromo) {
			atraccion.restarCupo();
		}
	}

	@Override
	public String toString() {
		String listaAtracciones = "";
		DecimalFormat df = new DecimalFormat("###.##");
		
		for (Atraccion atraccion : this.miPromo) {
			listaAtracciones += atraccion.getNombre() + " | ";
		}
		
		return "Promocion: " + listaAtracciones + "\nCosto: " + df.format(this.getCosto())
				+ " monedas de oro | Tiempo total de visitas: " + this.getTiempoDeVisita();
	}
}
