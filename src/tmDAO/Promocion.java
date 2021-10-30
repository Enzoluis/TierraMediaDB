package tmDAO;

import java.util.ArrayList;
import java.util.List;
import turismoDeLaTierraMedia.Producto;
import turismoDeLaTierraMedia.TipoAtraccion;

public class Promocion {
	private List<Atraccion> atracciones;
	private TipoAtraccion tipo;
	private String nombre;

	public Promocion(TipoAtraccion tipo, String nombre) {
		this.tipo = tipo;
		this.nombre = nombre;

	}

	public void setAtracciones(List<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public int getId() {
		return id;
	}

	/*
	 * public Promociones(ArrayList<Atraccion> miPromo, String nombre, TipoAtraccion
	 * tipo, int id) { super(miPromo, nombre, tipo); this.id=id;
	 * 
	 * }
	 * 
	 * public void setAtracciones(List<Atraccion> atracciones) {
	 * this.atracciones=atracciones;
	 * 
	 * }
	 * 
	 * public int getId() { return id; }
	 */
}
