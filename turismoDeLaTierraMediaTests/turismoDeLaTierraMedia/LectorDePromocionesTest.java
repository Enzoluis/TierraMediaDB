package turismoDeLaTierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class LectorDePromocionesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String path = "C:/Users/Usuario/eclipse-workspace/turismoTierraMedia/Archivos/Promociones.txt";
		
		ArrayList<Atraccion> promoAbsoluta = new ArrayList<Atraccion>();
		ArrayList<Atraccion> promoPorcentual = new ArrayList<Atraccion>();
		ArrayList<Atraccion> promoAxB = new ArrayList<Atraccion>();
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
		Atraccion minasTirith = new Atraccion("Minas Tirith", 2.5, 5, TipoAtraccion.valueOf("PAISAJE"), 25);
		Atraccion laComarca = new Atraccion("La Comarca", 6.5, 3, TipoAtraccion.valueOf("DEGUSTACION"), 150);
		Atraccion mordor = new Atraccion("Mordor", 3, 25, TipoAtraccion.valueOf("AVENTURA"), 4);
		Atraccion abismoDeHelm = new Atraccion("Abismo de Helm", 2, 5, TipoAtraccion.valueOf("PAISAJE"), 15);
		Atraccion lothlorien = new Atraccion("Lothlorien", 1, 35, TipoAtraccion.valueOf("DEGUSTACION"), 30);
		Atraccion erebor = new Atraccion("Erebor", 3, 12, TipoAtraccion.valueOf("PAISAJE"), 32);
		Atraccion bosqueNegro = new Atraccion("Bosque Negro", 4, 3, TipoAtraccion.valueOf("AVENTURA"), 12);
		
		atracciones.add(lothlorien);
		atracciones.add(laComarca);
		atracciones.add(bosqueNegro);
		atracciones.add(mordor);
		atracciones.add(minasTirith);
		atracciones.add(abismoDeHelm);
		atracciones.add(erebor);
		
		ArrayList<Promocion> promociones =  (ArrayList<Promocion>) LectorDePromociones.leerPromociones(path, atracciones);
		
				
		promoAbsoluta.add(lothlorien);
		promoAbsoluta.add(laComarca);
		
		promoPorcentual.add(bosqueNegro);
		promoPorcentual.add(mordor);
		
		promoAxB.add(erebor);
		promoAxB.add(minasTirith);
		promoAxB.add(abismoDeHelm);
		
		
		PromocionesAbsolutas absoluta = new PromocionesAbsolutas(promoAbsoluta, "Absoluta", TipoAtraccion.valueOf("DEGUSTACION"), 36);
		PromocionesPorcentuales porcentual = new PromocionesPorcentuales(promoPorcentual, "Porcentual", TipoAtraccion.valueOf("AVENTURA"), 20);
		PromocionesAxB axB = new PromocionesAxB(promoAxB, "AxB", TipoAtraccion.valueOf("PAISAJE"));

		assertEquals(absoluta.getNombre(), promociones.get(0).getNombre());
		assertEquals(absoluta.getTipo(), promociones.get(0).getTipo());
		assertEquals(absoluta.getCosto(), promociones.get(0).getCosto(), 0.0001);
		
		assertEquals(porcentual.getNombre(), promociones.get(1).getNombre());
		assertEquals(porcentual.getTipo(), promociones.get(1).getTipo());
		assertEquals(porcentual.getCosto(), promociones.get(1).getCosto(), 0.0001);
		
		assertEquals(axB.getNombre(), promociones.get(2).getNombre());
		assertEquals(axB.getTipo(), promociones.get(2).getTipo());
		assertEquals(axB.getCosto(), promociones.get(2).getCosto(), 0.0001);
	}

}
