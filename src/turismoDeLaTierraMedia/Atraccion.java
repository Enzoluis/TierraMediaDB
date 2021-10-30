package turismoDeLaTierraMedia;

public class Atraccion extends Producto {

	private int cupoPersonas;
	private double costo;

	public Atraccion(String nombre, double tiempoVisita, double costo, TipoAtraccion tipo, int cupo) {
		super(nombre, tipo);
		this.cupoPersonas = cupo;
		this.tiempoDeVisita = tiempoVisita;
		this.costo = costo;
	}

	@Override
	public boolean tieneCupo() {
		return this.cupoPersonas > 0;
	}

	@Override
	public void restarCupo() {
		if (this.cupoPersonas > 0)
			this.cupoPersonas--;
	}

	@Override
	public double getCosto() {
		return this.costo;
	}

	@Override
	public double getTiempoDeVisita() {
		return super.tiempoDeVisita;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return "Atracción: " + nombre + "| Costo: " + costo + " monedas de oro"+ "| Tiempo de Visita: " + tiempoDeVisita + " horas";
	}
}