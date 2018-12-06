package Control;

import entidades.edificios.Castillo;
import entidades.edificios.Plaza;
import entidades.unidades.Aldeano;
import juego.Juego;
import juego.Jugador;
import mapa.Mapa;

import java.awt.*;
import java.util.Random;

public class IniciarJuego {
    public Mapa mapa;
    private Juego juego;
    public String turnoDeJugador;
    private String jugadorUno;
    private String jugadorDos;

    public IniciarJuego(int tamanioMapaAncho, int tamanioMapaLargo, String nombreJugadorUno, String nombreJugadorDos){

        jugadorUno = nombreJugadorUno;
        jugadorDos = nombreJugadorDos;

        seleccionarOrdenDeJugador();

        int unbicacionDelCastilloAncho = tamanioMapaAncho / 4;
        int unbicacionDelCastilloLargo = tamanioMapaLargo / 4;

        Point castilloJugadorUno = new Point(unbicacionDelCastilloAncho,unbicacionDelCastilloLargo);
        Point castilloJugadorDos = new Point(unbicacionDelCastilloAncho * 3,unbicacionDelCastilloLargo * 3);

        Point plazaJugadorUno = new Point(unbicacionDelCastilloAncho + 5,unbicacionDelCastilloLargo);
        Point plazaJugadorDos = new Point((unbicacionDelCastilloAncho * 3) - 5,unbicacionDelCastilloLargo * 3);

        mapa = new Mapa(tamanioMapaAncho,tamanioMapaLargo);
        mapa.colocar(castilloJugadorUno,new Castillo());
        mapa.colocar(castilloJugadorDos,new Castillo());
        mapa.colocar(plazaJugadorUno,new Plaza());
        mapa.colocar(plazaJugadorDos,new Plaza());
        for (int i = 0; i < 3; i++){
            Point aldeanosJugadorUno = new Point(unbicacionDelCastilloAncho + (i*2),unbicacionDelCastilloLargo - 5);
            Point aldeanosJugadorDos = new Point((unbicacionDelCastilloAncho * 3)- (i*2),(unbicacionDelCastilloAncho * 3) + 5);
            mapa.colocar(aldeanosJugadorUno,new Aldeano());
            mapa.colocar(aldeanosJugadorDos,new Aldeano());
        }
    }

    private void seleccionarOrdenDeJugador(){
        Random primeroUno = new Random();
        if (primeroUno.nextBoolean()){
            this.turnoDeJugador = jugadorUno;
            this.juego = new Juego(jugadorUno,jugadorDos);
        }
        else {
            this.turnoDeJugador = jugadorDos;
            this.juego = new Juego(jugadorDos,jugadorUno);
        }
    }

    public void finDelTurno(){
        if (turnoDeJugador == jugadorUno){
            turnoDeJugador = jugadorDos;
        }
        else{turnoDeJugador = jugadorUno;}
    }
}
