package entidadesTest.unidadesTest;

import static org.junit.Assert.*;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import entidades.unidades.Arquero;
import entidades.unidades.Espadachin;
import entidades.unidades.Unidad;
import excepciones.NoPuedeRepararException;
import org.junit.Test;


public class ArqueroUnitTest {

/*
	@Test
	public void ArqueroRepararCastilloLevantaNoPuedeRepararException(){
		boolean lanzoLaExcepcion = false;
		Unidad arquero = new Arquero();
		Edificio castillo = new Castillo();
		try {
			arquero.reparar(castillo);
		} catch (NoPuedeRepararException e) {
			lanzoLaExcepcion = true;
		}
		assert(lanzoLaExcepcion);
	}*/

	@Test
	public void ArqueroAtacarCastilloCon1000DeVidaLeCausa10DeDanio(){
		Arquero arquero = new Arquero();
		Castillo castillo = new Castillo();
		arquero.atacar(castillo);
		assertEquals(990, castillo.vida());
	}

	@Test
	public void ArqueroAtacarEspadachinCon100DeVidaLeCausa15DeDanio(){
		Arquero arquero = new Arquero();
		Espadachin espadachin = new Espadachin();
		arquero.atacar(espadachin);
		assertEquals(85, espadachin.vida());
	}
}
