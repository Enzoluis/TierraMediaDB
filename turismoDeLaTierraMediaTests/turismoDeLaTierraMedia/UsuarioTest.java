package turismoDeLaTierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void agregarItinerarioTest() {
		Usuario usuario = new Usuario("Eowyn", 10, 8, TipoAtraccion.valueOf("AVENTURA"));
		ArrayList<Atraccion> lista = new ArrayList<Atraccion>();
		Atraccion moria = new Atraccion("Moria", 10, 2, TipoAtraccion.valueOf("AVENTURA"), 6);
		Atraccion mordor = new Atraccion("Mordor", 3, 6.5, TipoAtraccion.valueOf("AVENTURA"), 150);

		assertNotNull(usuario);
		lista.add(moria);
		lista.add(mordor);
		PromocionesAbsolutas promo = new PromocionesAbsolutas(lista, "promo", TipoAtraccion.valueOf("AVENTURA"), 50);
		// comparacion con lista vacia
		assertEquals(new ArrayList(), usuario.getItinerario());

		usuario.agregarItinerario(moria);
		usuario.agregarItinerario(mordor);
		usuario.agregarItinerario(promo);

		assertTrue(usuario.getItinerario().contains(moria));
		assertTrue(usuario.getItinerario().contains(mordor));
		assertTrue(usuario.getItinerario().contains(promo));

		assertEquals(-48.5, usuario.getOro(), 0.0001);
	}

	@Test
	public void queRestaOroYTiempoTest() {
		Usuario usuario = new Usuario("Eowyn", 10, 10, TipoAtraccion.valueOf("AVENTURA"));
		Atraccion moria = new Atraccion("Moria", 10, 2, TipoAtraccion.valueOf("AVENTURA"), 6);

		assertNotNull(usuario);

		usuario.agregarItinerario(moria);
		assertEquals(8, usuario.getOro(), 0.0001);
		assertEquals(0, usuario.getTiempoDispobible(), 0.0001);
	}

}
