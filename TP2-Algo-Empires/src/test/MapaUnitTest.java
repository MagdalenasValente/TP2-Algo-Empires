package test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import aplicacion.*;

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
}