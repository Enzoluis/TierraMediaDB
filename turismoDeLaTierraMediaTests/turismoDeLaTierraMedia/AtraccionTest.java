package turismoDeLaTierraMedia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AtraccionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Atraccion moria = new Atraccion("Moria", 10, 2, TipoAtraccion.valueOf("AVENTURA"), 6);
		assertNotNull(moria);
	}

	@Test
	public void queTieneCupotest() {
		Atraccion moria = new Atraccion("Moria", 10, 2, TipoAtraccion.valueOf("AVENTURA"), 6);
		assertEquals(true, moria.tieneCupo());
	}

	@Test
	public void queRestaYSeQuedaSinCupotest() {
		Atraccion moria = new Atraccion("Moria", 10, 2, TipoAtraccion.valueOf("AVENTURA"), 6);

		moria.restarCupo();
		moria.restarCupo();
		moria.restarCupo();
		moria.restarCupo();
		moria.restarCupo();
		moria.restarCupo();

		assertEquals(false, moria.tieneCupo());
	}

}
