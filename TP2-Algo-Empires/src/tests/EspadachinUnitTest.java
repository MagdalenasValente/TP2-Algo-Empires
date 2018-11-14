import static org.junit.Assert.*;

import entidades.Entidad;
import entidades.unidades.Espadachin;
import org.junit.Test;

public class EspadachinUnitTest {

	@Test
	public void EspadachinNuevoTiene100DeVida() {
		Entidad espadachin = new Espadachin();
		assertEquals(espadachin.vida(), 100);
	}

}