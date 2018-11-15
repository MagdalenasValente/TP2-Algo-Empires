package entidadesTest.unidadesTest;

import static org.junit.Assert.*;

import entidades.Entidad;
import entidades.unidades.Arquero;
import org.junit.Test;


public class ArqueroUnitTest {

	@Test
	public void arqueroNuevoTiene75DeVida() {
		Entidad arquero = new Arquero();
		assertEquals(arquero.vida(), 75);
	}

}
