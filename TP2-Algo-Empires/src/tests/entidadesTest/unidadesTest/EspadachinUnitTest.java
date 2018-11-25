package entidadesTest.unidadesTest;

import static org.junit.Assert.*;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import entidades.unidades.Espadachin;
import entidades.unidades.Unidad;
import excepciones.NoPuedeRepararException;
import org.junit.Test;

public class EspadachinUnitTest {

	@Test
	public void EspadachinNuevoTiene100DeVida() {
		Entidad espadachin = new Espadachin();
		assertEquals(espadachin.vida(), 100);
	}

	//@Test
	//public void ArqueroRepararCastilloLevantaNoPuedeRepararException(){
	//	boolean lanzoLaExcepcion = false;
	//	Unidad espadachin = new Espadachin();
	//	Edificio castillo = new Castillo();
	//	try {
	//		espadachin.reparar(castillo);
	//	} catch (NoPuedeRepararException e) {
	//		lanzoLaExcepcion = true;
	//	}
	//	assert(lanzoLaExcepcion);
	//}

	@Test
	public void EspadachinAtacarCastilloCon1000DeVidaLeCausa15DeDanio(){
		Espadachin espadachin = new Espadachin();
		Castillo castillo = new Castillo();
		espadachin.atacar(castillo);
		assertEquals(985, castillo.vida());
	}

	@Test
	public void EspadachinAtacarEspadachinCon100DeVidaLeCausa25DeDanio(){
		Espadachin espadachin = new Espadachin();
		Espadachin otroEspadachin = new Espadachin();
		espadachin.atacar(otroEspadachin);
		assertEquals(75, otroEspadachin.vida());
	}

}