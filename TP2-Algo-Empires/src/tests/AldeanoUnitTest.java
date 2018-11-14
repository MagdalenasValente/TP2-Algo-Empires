import entidades.Entidad;
import entidades.unidades.Aldeano;
import org.junit.Test;

import static org.junit.Assert.*;


public class AldeanoUnitTest {

	@Test
	public void aldeanoNuevoTiene50DeVida() {
		Entidad aldeano = new Aldeano();
		assertEquals(aldeano.vida(), 50);
	}

}
