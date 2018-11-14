package test;

import static org.junit.Assert.*;

import org.junit.Test;

import aplicacion.*;

public class ArqueroUnitTest {

	@Test
	public void arqueroNuevoTiene75DeVida() {
		Entidad arquero = new Arquero();
		assertEquals(arquero.vida(), 75);
	}

}
