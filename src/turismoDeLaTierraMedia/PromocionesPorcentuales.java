package turismoDeLaTierraMedia;

import java.util.ArrayList;

public class PromocionesPorcentuales extends Promocion {
	double descuento;

	public PromocionesPorcentuales(ArrayList<Atraccion> packPorcentual, String nombre, TipoAtraccion tipo,
			double descuento) {
		super(packPorcentual, nombre, tipo);
		this.descuento = descuento;
	}

	@Override
	public double getCosto() {
		return super.getCosto() * ((100 - this.descuento) / 100);
				
	}

	@Override
	public String getNombre() {
		String listaAtracciones = "";
		listaAtracciones = super.toString();
		return listaAtracciones;
	}
}
