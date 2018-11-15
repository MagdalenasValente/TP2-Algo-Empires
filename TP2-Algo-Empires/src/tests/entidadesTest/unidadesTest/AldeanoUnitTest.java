package entidadesTest.unidadesTest;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import entidades.unidades.Aldeano;
import entidades.unidades.Unidad;
import org.junit.Test;

import static org.junit.Assert.*;


public class AldeanoUnitTest {

	@Test
	public void aldeanoNuevoTiene50DeVida() {
		Entidad aldeano = new Aldeano();
		assertEquals(aldeano.vida(), 50);
	}

	@Test
    public void aldeanoRepararCastilloConTodaLaVidaLoDejaEn1000DeVida(){
        Unidad aldeano = new Aldeano();
        Edificio castillo = new Castillo();
        aldeano.reparar(castillo);
        assertEquals(1000, castillo.vida());
    }
}
