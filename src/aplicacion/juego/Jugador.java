package juego;

import entidades.Entidad;
import entidades.edificios.Castillo;

import java.util.List;

public class Jugador {
    private Poblacion poblacion;
    private List perteneceAlJugador;
    private String nombre;
    public int oro;

    public Jugador(String nombre){
        this.poblacion = new Poblacion();
        this.nombre = nombre;
    }

    public void agregarEntidad(Entidad entidad){
        perteneceAlJugador.add(entidad);
    }

    public boolean haPerdido(){
        //return this.poblacion.perdioElCastillo();
        return false;
    }

    public void terminarTurno(){
        //this.poblacion.actuar();
    }
}
