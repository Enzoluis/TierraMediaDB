package turismoDeLaTierraMedia;

public abstract class Producto {

	String nombre;
	protected double costo;
	protected double tiempoDeVisita;
	protected TipoAtraccion tipo;

	public Producto(String nombre, TipoAtraccion tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public abstract double getCosto();

	public abstract double getTiempoDeVisita();

	public String getNombre() {
		return this.nombre;
	}

	protected abstract boolean tieneCupo();

	protected abstract void restarCupo();

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public boolean esPromo() {
		return false;
	}

}
