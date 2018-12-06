package Control;

import entidades.edificios.Castillo;
import entidades.edificios.Plaza;
import entidades.unidades.Aldeano;
import juego.Juego;
import juego.Jugador;
import juego.Poblacion;
import mapa.Mapa;

import java.awt.*;
import java.util.Random;

public class IniciarJuego {
    public Mapa mapa;
    private Juego juego;
    public String turnoDeJugador;
    private Poblacion poblacionJugadorActual;
    private Poblacion poblacionJugadorEnEspera;

    public IniciarJuego(int tamanioMapaAncho, int tamanioMapaLargo, String nombreJugadorUno, String nombreJugadorDos){

        mapa = new Mapa(tamanioMapaAncho,tamanioMapaLargo);
        this.poblacionJugadorActual = new Poblacion(mapa,nombreJugadorUno);
        this.poblacionJugadorEnEspera = new Poblacion(mapa, nombreJugadorDos);

        seleccionarOrdenDeJugador();

        int unbicacionDelCastilloAncho = tamanioMapaAncho / 4;
        int unbicacionDelCastilloLargo = tamanioMapaLargo / 4;

        Point coordenadasCastilloJugadorUno = new Point(unbicacionDelCastilloAncho,unbicacionDelCastilloLargo);
        Point coordenadasCastilloJugadorDos = new Point(unbicacionDelCastilloAncho * 3,unbicacionDelCastilloLargo * 3);

        Point coordenadasPlazaJugadorUno = new Point(unbicacionDelCastilloAncho + 5,unbicacionDelCastilloLargo);
        Point coordenadasPlazaJugadorDos = new Point((unbicacionDelCastilloAncho * 3) - 5,unbicacionDelCastilloLargo * 3);


        poblacionJugadorActual.agregar(new Castillo(), coordenadasCastilloJugadorUno);
        poblacionJugadorEnEspera.agregar(new Castillo(), coordenadasCastilloJugadorDos);
        poblacionJugadorActual.agregar(new Plaza(), coordenadasPlazaJugadorUno);
        poblacionJugadorEnEspera.agregar(new Plaza(), coordenadasPlazaJugadorDos);
        for (int i = 0; i < 3; i++){
            Point aldeanosJugadorUno = new Point(unbicacionDelCastilloAncho + (i*2),unbicacionDelCastilloLargo - 5);
            Point aldeanosJugadorDos = new Point((unbicacionDelCastilloAncho * 3)- (i*2),(unbicacionDelCastilloAncho * 3) + 5);
            poblacionJugadorActual.agregar(new Aldeano(), aldeanosJugadorUno);
            poblacionJugadorActual.agregar(new Aldeano(), aldeanosJugadorDos);
        }
    }

    private void seleccionarOrdenDeJugador(){
        Random randomBool = new Random();
        Poblacion aux;
        if (randomBool.nextBoolean()){
            aux = this.poblacionJugadorEnEspera;
            this.poblacionJugadorEnEspera = this.poblacionJugadorActual;
            this.poblacionJugadorActual = aux;
        }
    }

    public void cambiarJugadores(){
        Poblacion aux;
        aux = this.poblacionJugadorActual;
        this.poblacionJugadorActual = this.poblacionJugadorEnEspera;
        this.poblacionJugadorEnEspera = aux;
    }

    public void terminarTurno(){
        //this.poblacionJugadorActual.actuar();
        //if(this.acabo()){
            //se acabo el juego
        //}
        this.cambiarJugadores();
    }

    /*public boolean acabo(){
        return this.poblacionJugadorEnEspera.haPerdido();
    }*/
}
