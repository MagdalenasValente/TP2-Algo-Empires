package entidadesTest.unidadesTest;

import static org.junit.Assert.*;

import entidades.unidades.Espadachin;
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

	@Test
	public void armaRepararCastilloLevantaNoPuedeRepararException(){
	    boolean lanzoLaExcepcion = false;
		Unidad armaDeAsedio = new ArmaDeAsedio();
		Edificio castillo = new Castillo();
        try {
            armaDeAsedio.reparar(castillo);
        } catch (NoPuedeRepararException e) {
            lanzoLaExcepcion = true;
        }
        assert(lanzoLaExcepcion);
	}


    @Test
    public void armaDeAsedioAtacarCastilloCon1000DeVidaLeCausa75DeDanio(){
        ArmaDeAsedio arma = new ArmaDeAsedio();
        Castillo castillo = new Castillo();
        arma.atacar(castillo);
        assertEquals(925, castillo.vida());
    }

    @Test
    public void armaDeAsedioAtacarEspadachinCon100DeVidaNoLeCausaDanio(){
        ArmaDeAsedio arma = new ArmaDeAsedio();
        Espadachin espadachin = new Espadachin();
        arma.atacar(espadachin);
        assertEquals(100, espadachin.vida());
    }


}
