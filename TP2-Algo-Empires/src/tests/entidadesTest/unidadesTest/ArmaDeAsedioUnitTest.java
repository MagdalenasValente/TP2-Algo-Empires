package entidadesTest.unidadesTest;

import static org.junit.Assert.*;

import excepciones.NoPuedeRepararException;
import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import entidades.unidades.ArmaDeAsedio;
import entidades.unidades.Unidad;
import org.junit.Test;


public class ArmaDeAsedioUnitTest {

	@Test
	public void armaDeAsedioNuevaTiene150DeVida() {
		Entidad armaDeAsedio = new ArmaDeAsedio();
		assertEquals(armaDeAsedio.vida(), 150);
	}

	public void ArmaRepararCastilloLevantaNoPuedeRepararException(){
		Unidad armaDeAsedio = new ArmaDeAsedio();
		Edificio castillo = new Castillo();
		armaDeAsedio.reparar(castillo);
        try {
            armaDeAsedio.reparar(castillo);
        } catch (NoPuedeRepararException e) {
            assertTrue(true);
        }
	}


}
