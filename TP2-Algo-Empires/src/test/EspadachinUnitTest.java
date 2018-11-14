package test;

import static org.junit.Assert.*;

import org.junit.Test;

import aplicacion.*;

public class EspadachinUnitTest {

	@Test
	public void EspadachinNuevoTiene100DeVida() {
		Entidad espadachin = new Espadachin();
		assertEquals(espadachin.vida(), 100);
	}

}