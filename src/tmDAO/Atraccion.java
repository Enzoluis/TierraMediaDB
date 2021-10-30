package tmDAO;

import turismoDeLaTierraMedia.Producto;
import turismoDeLaTierraMedia.TipoAtraccion;

public class Atraccion extends Producto {

	private int cupoPersonas;
	private double costo;
	private int id;
	private TipoAtraccion tipo;
	private String nombre;
	private int cupo;

	public Atraccion(int id, String nombre, double tiempoVisita, double costo, TipoAtraccion tipo, int cupo) {
		super(nombre, tipo);
		
		this.id=id;
		this.nombre=nombre;
		this.tiempoDeVisita = tiempoVisita;
		this.costo = costo;
		this.tipo=tipo;
		this.cupoPersonas = cupo;
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
		return "id:"+ id + ", Atracción: " + nombre + "| Costo: " + costo + " monedas de oro" 
				+ "| Tiempo de Visita: " + tiempoDeVisita + " horas";
	}

	public void setCupo(int nuevoCupo) {
		cupo=nuevoCupo;
		
	}

	public int getId() {
		return id;
	}

	public int getCupo() {
		return cupo;
	}
}
