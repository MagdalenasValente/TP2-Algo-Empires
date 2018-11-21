package entidadesTest.unidadesTest;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Cuartel;
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

//	@Test
//    public void aldeanoRepararCastilloConTodaLaVidaLoDejaEn1000DeVida(){
//        Unidad aldeano = new Aldeano();
//        Edificio castillo = new Castillo();
//        castillo.setVida(500);
//        aldeano.reparar(castillo);
//        aldeano.actuar();
//       assertEquals(515, castillo.vida());
//        aldeano.actuar();
//        assertEquals(530, castillo.vida());
//    }


    @Test
    public void aldeanoReparaCastilloConTodaLaVidaSumaOro(){
        Aldeano aldeano = new Aldeano();
        Edificio castillo = new Castillo();
        assertEquals(0, aldeano.getOro());
        aldeano.reparar(castillo);
        aldeano.actuar();
        assertEquals(20, aldeano.getOro());

    }


    @Test
    public void aldeanoAlRepararCastilloNoJuntaOro(){
        Aldeano aldeano = new Aldeano();
        Edificio castillo = new Castillo();
        castillo.setVida(500);
        aldeano.reparar(castillo);
        aldeano.actuar();
        assertEquals(0, aldeano.getOro());
        aldeano.actuar();
        assertEquals(0, aldeano.getOro());
        aldeano.actuar();
        assertEquals(0, aldeano.getOro());

    }


    @Test
    public void aldeanoAlRepararCastilloNoJuntaOroHastaQueLoReparoCompletamente(){
        Aldeano aldeano = new Aldeano();
        Edificio castillo = new Castillo();
        castillo.setVida(975);
        aldeano.reparar(castillo);
        aldeano.actuar();
        assertEquals(0, aldeano.getOro());
        assertEquals(990, castillo.vida());
        aldeano.actuar();
        assertEquals(0, aldeano.getOro());
        assertEquals(1000, castillo.vida());
        aldeano.actuar();
        assertEquals(20, aldeano.getOro());
        assertEquals(1000, castillo.vida());
        aldeano.actuar();
        assertEquals(40, aldeano.getOro());
        assertEquals(1000, castillo.vida());
    }

    @Test
    public void aldeanoPuedeCrearCuartel(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        Unidad espadachin = cuartel.crearEspadachin();
        assertEquals(espadachin, null);
    }
    @Test
    public void aldeanoPuedeCrearCuartelYEsteCrearUnidadesLuegoDeLosTurnos(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.actuar();
        aldeano.actuar();
        Unidad espadachin = cuartel.crearEspadachin();
        assertEquals(espadachin, null);
        aldeano.actuar();
        Unidad espadachin2 = cuartel.crearEspadachin();
        assertEquals(espadachin2.vida(), 100);
    }

    @Test
    public void aldeanoNoJuntaOroMientrasConstruyePeroLuegoSiJuntaOro(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        assertEquals(0, aldeano.getOro());
        aldeano.actuar();
        assertEquals(0, aldeano.getOro());
        aldeano.actuar();
        assertEquals(0, aldeano.getOro());
        aldeano.actuar(); // Aca termino de construir.
        assertEquals(0, aldeano.getOro());
        aldeano.actuar(); // Aca junto 20 de Oro
        assertEquals(20, aldeano.getOro());
    }


}
