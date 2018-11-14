package test;

import static org.junit.Assert.*;

import org.junit.Test;

import aplicacion.*;

public class AldeanoUnitTest {

	@Test
	public void aldeanoNuevoTiene50DeVida() {
		Entidad aldeano = new Aldeano();
		assertEquals(aldeano.vida(), 50);
	}

}
