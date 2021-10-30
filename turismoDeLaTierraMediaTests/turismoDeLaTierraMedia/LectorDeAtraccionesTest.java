package turismoDeLaTierraMedia;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LectorDeAtraccionesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void queLeeBienELArchivoTest() throws IOException {
		String path = "C:/Users/Usuario/eclipse-workspace/turismoTierraMedia/Archivos/Atracciones.txt";
		ArrayList<Atraccion> lista = LectorDeAtracciones.leerAtracciones(path);
		Atraccion moria = new Atraccion("Moria", 10, 2, TipoAtraccion.valueOf("AVENTURA"), 6);
		Atraccion minasTirith = new Atraccion("Minas Tirith", 5, 2.5, TipoAtraccion.valueOf("PAISAJE"), 25);
		Atraccion laComarca = new Atraccion("La Comarca", 3, 6.5, TipoAtraccion.valueOf("DEGUSTACION"), 150);
		
		
		assertEquals(moria.getNombre(), lista.get(0).getNombre());
		assertEquals(moria.getCosto(), lista.get(0).getCosto(), 0.0001);
		assertEquals(moria.getTiempoDeVisita(), lista.get(0).getTiempoDeVisita(), 0.0001);
		assertEquals(moria.getTipo(), lista.get(0).getTipo());
		
		assertEquals(minasTirith.getNombre(), lista.get(1).getNombre());
		assertEquals(minasTirith.getCosto(), lista.get(1).getCosto(), 0.0001);
		assertEquals(minasTirith.getTiempoDeVisita(), lista.get(1).getTiempoDeVisita(), 0.0001);
		assertEquals(minasTirith.getTipo(), lista.get(1).getTipo());
		
		assertEquals(laComarca.getNombre(), lista.get(2).getNombre());
		assertEquals(laComarca.getCosto(), lista.get(2).getCosto(), 0.0001);
		assertEquals(laComarca.getTiempoDeVisita(), lista.get(2).getTiempoDeVisita(), 0.0001);
		assertEquals(laComarca.getTipo(), lista.get(2).getTipo());
	}

}
