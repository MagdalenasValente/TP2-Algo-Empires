import java.awt.Point;

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
    public void moverAldeanoVariasVecesTerminaEnLaPosicionCorrecta(){
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
}