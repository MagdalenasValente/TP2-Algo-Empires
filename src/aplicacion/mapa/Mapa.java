package mapa;

import entidades.Entidad;
import entidades.unidades.Unidad;
import excepciones.*;


import java.awt.Point;
import java.util.*;


public class Mapa {
	
	private HashMap<Point, Entidad> grilla;
	private Integer ancho;
	private Integer alto;

	public Mapa(Integer ancho, Integer alto) {
		this.grilla = new HashMap<Point, Entidad>();
		this.ancho = ancho;
		this.alto = alto;
	}
	
	private boolean verificarCoordenadas(Point coordenadas, Point tamanio) {
		Point menorCoordenada = coordenadas;
		Integer mayorAlto = (int) (menorCoordenada.getX() + tamanio.getX());
		Integer mayorAncho = (int) (menorCoordenada.getY() + tamanio.getY());
		Point mayorCoordenada = new Point(mayorAlto, mayorAncho);
		Boolean mayorQueCero = menorCoordenada.getX() >= 0 && menorCoordenada.getY() >= 0;
		Boolean menorQueFinDelMapa = mayorCoordenada.getX() < this.ancho && mayorCoordenada.getY() < this.alto;
		return(mayorQueCero && menorQueFinDelMapa);
	}

	private boolean verificarQueNoColisiona(Point coordenadas, Point tamanioDeLaEntidad){
        int coordenadaEnX = (int)coordenadas.getX();
        int coordenadaEnY = (int)coordenadas.getY();
		for(int i = 0; i<(int)tamanioDeLaEntidad.getX(); i++) {
			for(int j = 0; j<(int)tamanioDeLaEntidad.getY(); j++) {
				if(estaOcupado(new Point(coordenadaEnX + i,coordenadaEnY + j))){
				    return false;
                }
			}
		}
		return true;
	}

	private boolean rellenarLugarDelMapa(Point ubicacion, Point tamanio, Entidad ocuparLugar){
		int coordenadaEnX = (int)ubicacion.getX();
		int coordenadaEnY = (int)ubicacion.getY();
		int tamanioEnX = (int)tamanio.getX();
		int tamanioEnY = (int)tamanio.getY();
		if (coordenadaEnX + tamanioEnX > ancho || coordenadaEnY + tamanioEnY > alto || coordenadaEnX * coordenadaEnY < 0){
			/* caso de que la coordenadas esten fuera del mapa */
			return false;
		}
		for(int i = 0; i<tamanioEnX; i++) {
			for(int j = 0; j<tamanioEnY; j++) {
				this.grilla.remove(new Point(coordenadaEnX + i,coordenadaEnY +j));
				this.grilla.put(new Point(coordenadaEnX + i,coordenadaEnY +j), ocuparLugar);	//la esquina inferior izquierda de la entidad se coloca en la posicion seleccionada
			}
		}
		return true;
	}

	public void colocar(Point coordenadas, Entidad entidad) {
		Point tamanioDeLaEntidad = entidad.verTamanio();
		if(!this.verificarQueNoColisiona(coordenadas, tamanioDeLaEntidad)) {
			throw new EspacioOcupadoException();
		}
		if(!this.verificarCoordenadas(coordenadas, tamanioDeLaEntidad)) {
			throw new EspacioInvalidoException();
		}
		rellenarLugarDelMapa(coordenadas,tamanioDeLaEntidad,entidad);
		/*
		int coordenadaEnX = (int)coordenadas.getX();
		int coordenadaEnY = (int)coordenadas.getY();
		for(int i = 0; i<(int)tamanioDeLaEntidad.getX(); i++) {
			for(int j = 0; j<(int)tamanioDeLaEntidad.getY(); j++) {
				this.grilla.put(new Point(coordenadaEnX + i,coordenadaEnY +j), entidad);	//la esquina inferior izquierda de la entidad se coloca en la posicion seleccionada
			}
		}*/
		entidad.setMapa(this);
		entidad.setPosicion(coordenadas);
	}

	public boolean estaOcupado(Point coordenadas) {
		return this.grilla.containsKey(coordenadas);
	}

    public void mover(Unidad unidad, Point coordenadas, Point direccion) {
        int direccionEnX = (int) direccion.getX();
        int direccionEnY = (int) direccion.getY();
        int coordenadaEnX = (int)coordenadas.getX();
        int coordenadaEnY = (int)coordenadas.getY();
        Point posicionNueva = new Point(coordenadaEnX + direccionEnX, coordenadaEnY + direccionEnY);
        try {
            this.colocar(posicionNueva, unidad);
        }catch (RuntimeException e){
            return;
        }


    }

    public boolean estaEnRango(Point objetivoCoordenadas, Point atacanteCoordenadas, int atacanteRango){
		if (!this.estaOcupado(objetivoCoordenadas)){
			throw new UbicacionDeAtaqueVaciaException();
		}
		int objetivoCoordenadaEnX = (int) objetivoCoordenadas.getX();
		int objetivoCoordenadaEnY = (int) objetivoCoordenadas.getY();
		int atacanteCoordenadaEnX = (int) atacanteCoordenadas.getX();
		int atacanteCoordenadaEnY = (int) atacanteCoordenadas.getY();
		//extremos
		int extremo_superior_de_rango = atacanteCoordenadaEnY + atacanteRango;
		int extremo_inferior_de_rango = atacanteCoordenadaEnY - atacanteRango;
		int extremo_derecho_de_rango = atacanteCoordenadaEnX + atacanteRango;
		int extremo_izquierdo_de_rango = atacanteCoordenadaEnX - atacanteRango;
		//calculos bool
		boolean entreElRengoHorizontal = (extremo_derecho_de_rango >= objetivoCoordenadaEnX) && (extremo_izquierdo_de_rango <= objetivoCoordenadaEnX);
		boolean entreElRengoVertical = (extremo_superior_de_rango >= objetivoCoordenadaEnY) && (extremo_inferior_de_rango <= objetivoCoordenadaEnY);
		return (entreElRengoHorizontal && entreElRengoVertical);
	}

	public Entidad entidadQueOcupaLaPoscicion (Point coordenadas){
		return this.grilla.get(coordenadas);
	}

	public void entidadHaMuerto (Entidad entidad){
		Point ubicacion = entidad.verPosicion();
		Point tamanioDeLaEntidad = entidad.verTamanio();

		rellenarLugarDelMapa(ubicacion,tamanioDeLaEntidad,null);
		/*int coordenadaEnX = (int)ubicacion.getX();
		int coordenadaEnY = (int)ubicacion.getY();
		for(int i = 0; i<(int)tamanioDeLaEntidad.getX(); i++) {
			for(int j = 0; j<(int)tamanioDeLaEntidad.getY(); j++) {
				this.grilla.remove(new Point(coordenadaEnX + i,coordenadaEnY +j));
			}
		}*/
	}
}