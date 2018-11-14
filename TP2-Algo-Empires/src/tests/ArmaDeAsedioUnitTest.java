import static org.junit.Assert.*;

import entidades.Entidad;
import entidades.unidades.ArmaDeAsedio;
import org.junit.Test;


public class ArmaDeAsedioUnitTest {

	@Test
	public void armaDeAsedioNuevaTiene150DeVida() {
		Entidad armaDeAsedio = new ArmaDeAsedio();
		assertEquals(armaDeAsedio.vida(), 150);
	}

}
