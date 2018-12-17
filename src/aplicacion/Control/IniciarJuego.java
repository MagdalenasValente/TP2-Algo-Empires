package Control;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Cuartel;
import entidades.edificios.Plaza;
import entidades.unidades.Aldeano;
import entidades.unidades.ArmaDeAsedio;
import entidades.unidades.Arquero;
import entidades.unidades.Espadachin;
import juego.Juego;
import juego.Jugador;
import mapa.Mapa;

import java.awt.*;
import java.util.Random;

public class IniciarJuego {
    public Mapa mapa;
    private Juego juego;
    public String turnoDeJugador;
    private String nombreDeJugadorUno;
    private String nombreDeJugadorDos;

    public IniciarJuego(int tamanioMapaAncho, int tamanioMapaLargo, String nombreJugadorUno, String nombreJugadorDos){
        //este mapa es de pruevas
        nombreDeJugadorUno = nombreJugadorUno;
        nombreDeJugadorDos = nombreJugadorDos;

        seleccionarOrdenDeJugador();

        int unbicacionDelCastilloAncho = tamanioMapaAncho / 4;
        int unbicacionDelCastilloLargo = tamanioMapaLargo / 4;

        Point castilloJugadorUno = new Point(unbicacionDelCastilloAncho,unbicacionDelCastilloLargo);
        Point castilloJugadorDos = new Point(unbicacionDelCastilloAncho * 3,unbicacionDelCastilloLargo * 3);

        Point plazaJugadorUno = new Point(unbicacionDelCastilloAncho + 5,unbicacionDelCastilloLargo);
        Point plazaJugadorDos = new Point((unbicacionDelCastilloAncho * 3) - 5,unbicacionDelCastilloLargo * 3);

        Jugador primero = juego.getJugadorDeTurno();
        Jugador segundo = juego.getJugadorEnEspera();

        Entidad castilloDeJugadorUno = new Castillo();
        Entidad castilloDeJugadorDos = new Castillo();
        Entidad plazaDeJugadorUno = new Plaza();
        Entidad plazaDeJugadorDos = new Plaza();

        mapa = new Mapa(tamanioMapaAncho,tamanioMapaLargo);
        mapa.colocar(castilloJugadorUno,castilloDeJugadorUno);
        mapa.colocar(castilloJugadorDos,castilloDeJugadorDos);
        mapa.colocar(plazaJugadorUno,plazaDeJugadorUno);
        mapa.colocar(plazaJugadorDos,plazaDeJugadorDos);
        for (int i = 0; i < 3; i++){
            Point aldeanosJugadorUno = new Point(unbicacionDelCastilloAncho + (i*2),unbicacionDelCastilloLargo - 5);
            Point aldeanosJugadorDos = new Point((unbicacionDelCastilloAncho * 3)- (i*2),(unbicacionDelCastilloAncho * 3) + 5);
            mapa.colocar(aldeanosJugadorUno,new Aldeano());
            mapa.colocar(aldeanosJugadorDos,new Aldeano());
        }
        //pruevas varias
        mapa.colocar(new Point(1 ,1),new Espadachin());
        mapa.colocar(new Point(1 ,2),new Arquero());
        mapa.colocar(new Point(1 ,3),new ArmaDeAsedio());
        ArmaDeAsedio montada = new ArmaDeAsedio();
        montada.montarDesmontar();
        mapa.colocar(new Point(1 ,4),montada);
        mapa.colocar(new Point(1 ,8),new Cuartel());
    }

    private void seleccionarOrdenDeJugador(){
        Random primeroUno = new Random();
        if (primeroUno.nextBoolean()){
            this.turnoDeJugador = nombreDeJugadorUno;
            this.juego = new Juego(nombreDeJugadorUno, nombreDeJugadorDos);
        }
        else {
            this.turnoDeJugador = nombreDeJugadorDos;
            this.juego = new Juego(nombreDeJugadorDos, nombreDeJugadorUno);
        }
    }

    public Jugador finDelTurno(){
        if (turnoDeJugador == nombreDeJugadorUno){
            turnoDeJugador = nombreDeJugadorDos;
        }
        else{turnoDeJugador = nombreDeJugadorUno;}
        return juego.terminarTurno();
    }
    public Jugador jugadorActual(){
        return juego.getJugadorDeTurno();
    }


    public boolean finalizarPartida(){
        return juego.acabo();
    }
}
