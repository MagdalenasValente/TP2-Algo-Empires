package juego;

import entidades.Entidad;

public class Jugador {
    private Poblacion poblacion;
    private Entidad[] perteneceAlJugador;
    private String nombre;

    public Jugador(String nombre){
        this.poblacion = new Poblacion();
        this.nombre = nombre;
    }

    public boolean haPerdido(){
        return this.poblacion.perdioElCastillo();
    }

    public void terminarTurno(){
        this.poblacion.actuar();
    }
}
