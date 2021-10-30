package turismoDeLaTierraMedia;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class LectorDeUsuarioTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void queLeeBienELArchivoTest() throws IOException {
		String path = "C:/Users/Usuario/eclipse-workspace/turismoTierraMedia/Archivos/Usuario.txt";
		ArrayList<Usuario> lista = LectorDeUsuario.leerUsuario(path);
		Usuario eowyn = new Usuario("Eowyn", 10, 8, TipoAtraccion.valueOf("AVENTURA"));
		Usuario gandalf = new Usuario("Gandalf", 100, 5, TipoAtraccion.valueOf("PAISAJE"));
		Usuario sam = new Usuario("Sam", 36, 8, TipoAtraccion.valueOf("DEGUSTACION"));
		Usuario galadriel = new Usuario("Galadriel", 120, 3, TipoAtraccion.valueOf("PAISAJE"));

		assertEquals(eowyn.getNombre(), lista.get(0).getNombre());
		assertEquals(eowyn.getOro(), lista.get(0).getOro(), 0.0001);
		assertEquals(eowyn.getTiempoDispobible(), lista.get(0).getTiempoDispobible(), 0.0001);
		assertEquals(eowyn.getAtraccionPreferida(), lista.get(0).getAtraccionPreferida());
		
		assertEquals(gandalf.getNombre(), lista.get(1).getNombre());
		assertEquals(gandalf.getOro(), lista.get(1).getOro(), 0.0001);
		assertEquals(gandalf.getTiempoDispobible(), lista.get(1).getTiempoDispobible(), 0.0001);
		assertEquals(gandalf.getAtraccionPreferida(), lista.get(1).getAtraccionPreferida());
		
		assertEquals(sam.getNombre(), lista.get(2).getNombre());
		assertEquals(sam.getOro(), lista.get(2).getOro(), 0.0001);
		assertEquals(sam.getTiempoDispobible(), lista.get(2).getTiempoDispobible(), 0.0001);
		assertEquals(sam.getAtraccionPreferida(), lista.get(2).getAtraccionPreferida());
		
		assertEquals(galadriel.getNombre(), lista.get(3).getNombre());
		assertEquals(galadriel.getOro(), lista.get(3).getOro(), 0.0001);
		assertEquals(galadriel.getTiempoDispobible(), lista.get(3).getTiempoDispobible(), 0.0001);
		assertEquals(galadriel.getAtraccionPreferida(), lista.get(3).getAtraccionPreferida());
	}

}
