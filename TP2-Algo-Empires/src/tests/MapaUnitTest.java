import java.awt.Point;

import entidades.unidades.Arquero;
import entidades.unidades.Espadachin;
import excepciones.UbicacionDeAtaqueVaciaException;
import mapa.Mapa;
import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Plaza;
import entidades.unidades.Aldeano;
import entidades.unidades.Unidad;
import excepciones.EspacioOcupadoException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MapaUnitTest {

	@Test
	public void mapaTrasColocarUnAldeanoEnPosicionValidaLaPosicionQuedaOcupada() {
		Mapa mapa = new Mapa(40, 40);
		Entidad aldeano = new Aldeano();
		Point coordenadas = new Point(2, 2);
		mapa.colocar(coordenadas, aldeano);
		assert(mapa.estaOcupado(coordenadas));
	}
	
	@Test
	public void mapaTrasColocarUnCastilloEnPosicionValidaLaPosicionSuperiorDerechaDelCastilloQuedaOcupada() {
		Mapa mapa = new Mapa(40, 40);
		Entidad castillo = new Castillo();
		Point coordenadas = new Point(2, 2);
		mapa.colocar(coordenadas, castillo);
		Point posicionSuperiorDerechaDelCastillo = new Point(5,5);
		assert(mapa.estaOcupado(posicionSuperiorDerechaDelCastillo));
	}
	
	@Test
	public void mapaTrasColocarUnCastilloEnPosicionValidaUnaPosicionFueraDelCastilloNoEstaOcupada() {
		Mapa mapa = new Mapa(40, 40);
		Entidad castillo = new Castillo();
		Point coordenadas = new Point(2, 2);
		mapa.colocar(coordenadas, castillo);
		Point posicionFueraDelCastillo = new Point(6,6);
		assert(!mapa.estaOcupado(posicionFueraDelCastillo));
	}

	@Test
	public void mapaColocarUnaPlazaEnUnEspacioOcupadoLevantaEspacioOcupadoException() {
	    boolean lanzoLaExcepcion = false;
		Mapa mapa = new Mapa(40, 40);
		Entidad plaza = new Plaza();
		Unidad aldeano = new Aldeano();
		Point coordenadas = new Point(2, 2);
		mapa.colocar(coordenadas, aldeano);
		try{
		    mapa.colocar(coordenadas, plaza);
        }catch (EspacioOcupadoException e){
		    lanzoLaExcepcion = true;
        }
		assert(lanzoLaExcepcion);
	}

    @Test
    public void mapaColocarUnCastilloEncimaDeUnAldeanoLevanteEspacioOcupadoException() {
        boolean lanzoLaExcepcion = false;
        Mapa mapa = new Mapa(40, 40);
        Entidad castillo = new Castillo();
        Unidad aldeano = new Aldeano();
        Point coordenadasAldeano = new Point(2, 2);
        Point coordenadasCastillo = new Point(1,1);
        mapa.colocar(coordenadasAldeano, aldeano);
        try{
            mapa.colocar(coordenadasCastillo, castillo);
        }catch (EspacioOcupadoException e){
            lanzoLaExcepcion = true;
        }
        assert(lanzoLaExcepcion);
    }

    @Test
    public void mapaColocarUnCastilloEncimaDeUnAldeanoNoColocaElCastillo() {
        boolean lanzoLaExcepcion = false;
        Mapa mapa = new Mapa(40, 40);
        Entidad castillo = new Castillo();
        Unidad aldeano = new Aldeano();
        Point coordenadasAldeano = new Point(2, 2);
        Point coordenadasCastillo = new Point(1,1);
        mapa.colocar(coordenadasAldeano, aldeano);
        try{
            mapa.colocar(coordenadasCastillo, castillo);
        }catch (EspacioOcupadoException e){
        }
        assert(!mapa.estaOcupado(coordenadasCastillo));
    }

    @Test
    public void moverAldeanoVariasVecesTerminaEnLaPosicionCorrecta(){ //no se si dejar estos tests aca o ponerlos en aldeano
	    Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point arriba = new Point(0,1);
        Point derecha = new Point(1,0);
        aldeano.desplazarse(arriba);
        aldeano.desplazarse(arriba);
        aldeano.desplazarse(derecha);
        assertEquals(aldeano.verPosicion(), new Point(21,22));
    }


    @Test
    public void moverAldeanoEnDiagonalArribaALaDerechaTerminaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point direccion = new Point(1,1);
        aldeano.desplazarse(direccion);
        assertEquals(aldeano.verPosicion(), new Point(21,21));
    }

    @Test
    public void moverAldeanoEnDiagonalArribaALaIzquierdaTerminaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point direccion = new Point(-1,1);
        aldeano.desplazarse(direccion);
        assertEquals(aldeano.verPosicion(), new Point(19,21));
    }

    @Test
    public void moverAldeanoEnDiagonalAbajoALaIzquierdaTerminaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point direccion = new Point(-1,-1);
        aldeano.desplazarse(direccion);
        assertEquals(aldeano.verPosicion(), new Point(19,19));
    }

    @Test
    public void moverAldeanoEnDiagonalAbajoALaDerechaTerminaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point direccion = new Point(1,-1);
        aldeano.desplazarse(direccion);
        assertEquals(aldeano.verPosicion(), new Point(21,19));
    }

    @Test
    public void moverAldeanoALaDerechaTerminaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point direccion = new Point(1,0);
        aldeano.desplazarse(direccion);
        assertEquals(aldeano.verPosicion(), new Point(21,20));
    }

    @Test
    public void moverAldeanoALaIzquierdaTerminaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point direccion = new Point(-1,0);
        aldeano.desplazarse(direccion);
        assertEquals(aldeano.verPosicion(), new Point(19,20));
    }

    @Test
    public void moverAldeanoHaciaAbajoTerminaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point direccion = new Point(0,-1);
        aldeano.desplazarse(direccion);
        assertEquals(aldeano.verPosicion(), new Point(20,19));
    }

    @Test
    public void moverAldeanoHaciaArribaTerminaEnLaPosicionCorrecta(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        mapa.colocar(new Point(20,20), aldeano);
        Point direccion = new Point(0,1);
        aldeano.desplazarse(direccion);
        assertEquals(aldeano.verPosicion(), new Point(20,21));
    }

    @Test
    public void moverAldeanoAUnaPosicionOcupadaLevantaEspacioOcupadoException(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        Castillo castillo = new Castillo();
        mapa.colocar(new Point(21,19), castillo);
        mapa.colocar(new Point(20,20), aldeano);
        try{Point direccion = new Point(1,0);
        }catch (EspacioOcupadoException e){
            assert(true);
        }
    }

    @Test
    public void moverAldeanoAUnaPosicionOcupadaDejaAlAldeanoEnLaPosicionOriginal(){
        Mapa mapa = new Mapa(40,40);
        Unidad aldeano = new Aldeano();
        Castillo castillo = new Castillo();
        mapa.colocar(new Point(21,19), castillo);
        mapa.colocar(new Point(20,20), aldeano);
        try{Point direccion = new Point(1,0);
        }catch (EspacioOcupadoException e){
        }
        assertEquals(aldeano.verPosicion(), new Point(20,20));
    }

    @Test
    public void ochoArquerosDeRango3AtacaAUnaUnidadEnSuRango(){
        Mapa mapa = new Mapa(40,40);
        Entidad Espadachin = new Espadachin();
        int valorDeCoordenadaObjetivo = 20;
        int rango = 3;
        int menorPosible = valorDeCoordenadaObjetivo - rango;
        int mayorPosible = valorDeCoordenadaObjetivo + rango;
        Point obejetivo = new Point(valorDeCoordenadaObjetivo,valorDeCoordenadaObjetivo);
        mapa.colocar(obejetivo, Espadachin);
        Point atacante1 = new Point(menorPosible,valorDeCoordenadaObjetivo);
        Point atacante2 = new Point(mayorPosible,valorDeCoordenadaObjetivo);
        Point atacante3 = new Point(valorDeCoordenadaObjetivo,menorPosible);
        Point atacante4 = new Point(valorDeCoordenadaObjetivo,mayorPosible);
        Point atacante5 = new Point(menorPosible,menorPosible);
        Point atacante6 = new Point(menorPosible,mayorPosible);
        Point atacante7 = new Point(mayorPosible,menorPosible);
        Point atacante8 = new Point(mayorPosible,mayorPosible);
        assert (mapa.estaEnRango(obejetivo,atacante1,rango));
        assert (mapa.estaEnRango(obejetivo,atacante2,rango));
        assert (mapa.estaEnRango(obejetivo,atacante3,rango));
        assert (mapa.estaEnRango(obejetivo,atacante4,rango));
        assert (mapa.estaEnRango(obejetivo,atacante5,rango));
        assert (mapa.estaEnRango(obejetivo,atacante6,rango));
        assert (mapa.estaEnRango(obejetivo,atacante7,rango));
        assert (mapa.estaEnRango(obejetivo,atacante8,rango));
    }
    @Test
    public void ochoArquerosDeRango3AtacaAUnaUnidadFueraFueraSuRango(){
        Mapa mapa = new Mapa(40,40);
        Entidad Espadachin = new Espadachin();
        int valorDeCoordenadaObjetivo = 20;
        int rango = 3;
        int menorPosible = valorDeCoordenadaObjetivo - (rango +1);
        int mayorPosible = valorDeCoordenadaObjetivo + (rango +1);
        Point obejetivo = new Point(valorDeCoordenadaObjetivo,valorDeCoordenadaObjetivo);
        mapa.colocar(obejetivo, Espadachin);
        Point atacante1 = new Point(menorPosible,valorDeCoordenadaObjetivo);
        Point atacante2 = new Point(mayorPosible,valorDeCoordenadaObjetivo);
        Point atacante3 = new Point(valorDeCoordenadaObjetivo,menorPosible);
        Point atacante4 = new Point(valorDeCoordenadaObjetivo,mayorPosible);
        Point atacante5 = new Point(menorPosible,menorPosible);
        Point atacante6 = new Point(menorPosible,mayorPosible);
        Point atacante7 = new Point(mayorPosible,menorPosible);
        Point atacante8 = new Point(mayorPosible,mayorPosible);
        assert (!mapa.estaEnRango(obejetivo,atacante1,rango));
        assert (!mapa.estaEnRango(obejetivo,atacante2,rango));
        assert (!mapa.estaEnRango(obejetivo,atacante3,rango));
        assert (!mapa.estaEnRango(obejetivo,atacante4,rango));
        assert (!mapa.estaEnRango(obejetivo,atacante5,rango));
        assert (!mapa.estaEnRango(obejetivo,atacante6,rango));
        assert (!mapa.estaEnRango(obejetivo,atacante7,rango));
        assert (!mapa.estaEnRango(obejetivo,atacante8,rango));
    }
    @Test
    public void cuandoSePideAtacarUnaCoordenadaVaciaLanzaUnaExcepcionDeUbicacionDeAtaqueVacia(){
        Mapa mapa = new Mapa(40,40);
        int valorDeCoordenadaObjetivo = 20;
        int rango = 3;
        int menorPosible = valorDeCoordenadaObjetivo - rango;
        Point obejetivo = new Point(valorDeCoordenadaObjetivo,valorDeCoordenadaObjetivo);
        Point atacante1 = new Point(menorPosible,valorDeCoordenadaObjetivo);
        try {
            mapa.estaEnRango(obejetivo,atacante1,rango);
        }catch (UbicacionDeAtaqueVaciaException e){
            assert true;
        }
    }
    @Test
    public void sePideLaEntidadQueOcupaUnLugarEnElMapaYEsteSeDevuelve(){
        Mapa mapa = new Mapa(40,40);
        int valorDeCoordenadaObjetivo = 20;
        Point obejetivo1 = new Point(valorDeCoordenadaObjetivo,valorDeCoordenadaObjetivo);
        Point obejetivo2 = new Point(valorDeCoordenadaObjetivo+1,valorDeCoordenadaObjetivo);
        Entidad Espadachin1 = new Espadachin();
        Entidad Espadachin2 = new Espadachin();
        mapa.colocar(obejetivo1, Espadachin1);
        mapa.colocar(obejetivo2, Espadachin2);
        Entidad espadachin = mapa.entidadQueOcupaLaPoscicion(obejetivo1);
        assert (espadachin == Espadachin1);
        assert (espadachin != Espadachin2);
    }


}