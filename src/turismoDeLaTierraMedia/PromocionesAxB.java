package turismoDeLaTierraMedia;

import java.util.ArrayList;

public class PromocionesAxB extends Promocion {

	public PromocionesAxB(ArrayList<Atraccion> packAxB, String nombre, TipoAtraccion tipo) {
		super(packAxB, nombre, tipo);
	}

	@Override
	public double getCosto() {
		double costoUltimaAtraccion = super.miPromo.get(super.miPromo.size() - 1).getCosto();

		return super.getCosto() - costoUltimaAtraccion;
	}

	@Override
	public String getNombre() {
		String listaAtracciones = "";
		listaAtracciones = super.toString();
		return listaAtracciones;
	}
}
