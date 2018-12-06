package juego;

import entidades.edificios.*;
import entidades.unidades.*;
import excepciones.LimiteDePoblacionAlcanzadoException;
import mapa.Mapa;

import java.awt.*;

public class Poblacion {
    private int limiteMaximoDePobacion;
    private int poblacionActual;
    private Mapa mapa;
    private String duenio;

    public Poblacion(Mapa mapa, String duenio){
        this.limiteMaximoDePobacion = 50;
        this.poblacionActual = 0;
        this.mapa = mapa;
        this.duenio = duenio;
    }

    public boolean incrementarPoblacion(){
        if (this.poblacionActual == this.limiteMaximoDePobacion){
            return false;
        }
        this.poblacionActual++;
        return true;
    }

    public boolean decrementarPoblacion(){
        if (this.poblacionActual == 0){
            return false;
        }
        this.poblacionActual--;
        return true;
    }

    public int verPoblacionActual(){
        return this.poblacionActual;
    }

    public boolean estaLlena(){
        return this.limiteMaximoDePobacion == this.poblacionActual;
    }

    public void agregar(Castillo castillo, Point coordenadas){
        this.mapa.colocar(coordenadas, castillo);

    }

    public void agregar(Cuartel cuartel, Point coordenadas){
        this.mapa.colocar(coordenadas, cuartel);
    }

    public void agregar(Plaza plaza, Point coordenadas){
        this.mapa.colocar(coordenadas, plaza);
    }

    public void agregar(Espadachin espadachin, Point coordenadas){
        if (this.estaLlena()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        this.mapa.colocar(coordenadas, espadachin);
    }

    public void agregar(Aldeano aldeano, Point coordenadas){
        if (this.estaLlena()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        this.mapa.colocar(coordenadas, aldeano);
    }

    public void agregar(Arquero arquero, Point coordenadas){
        if (this.estaLlena()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        this.mapa.colocar(coordenadas, arquero);
    }

    public void agregar(ArmaDeAsedio armaDeAsedio, Point coordenadas){
        if (this.estaLlena()){
            throw new LimiteDePoblacionAlcanzadoException();
        }
        this.mapa.colocar(coordenadas, armaDeAsedio);
    }
}
