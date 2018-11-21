package entidadesTest.unidadesTest;

import static org.junit.Assert.*;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import entidades.unidades.Arquero;
import entidades.unidades.Unidad;
import excepciones.NoPuedeRepararException;
import org.junit.Test;


public class ArqueroUnitTest {

	@Test
	public void arqueroNuevoTiene75DeVida() {
		Entidad arquero = new Arquero();
		assertEquals(arquero.vida(), 75);
	}

	//@Test
	//public void ArqueroRepararCastilloLevantaNoPuedeRepararException(){
	//	boolean lanzoLaExcepcion = false;
	//	Unidad arquero = new Arquero();
	//	Edificio castillo = new Castillo();
	//	try {
	//		arquero.reparar(castillo);
	//	} catch (NoPuedeRepararException e) {
	//		lanzoLaExcepcion = true;
	//	}
	//	assert(lanzoLaExcepcion);
	//}
}
