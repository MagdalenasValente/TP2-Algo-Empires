package test;

import static org.junit.Assert.*;

import org.junit.Test;

import aplicacion.*;

public class ArmaDeAsedioUnitTest {

	@Test
	public void armaDeAsedioNuevaTiene150DeVida() {
		Entidad armaDeAsedio = new ArmaDeAsedio();
		assertEquals(armaDeAsedio.vida(), 150);
	}

}
