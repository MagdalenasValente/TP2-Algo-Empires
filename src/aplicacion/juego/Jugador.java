package juego;

import entidades.Entidad;
import entidades.edificios.Castillo;

import java.util.List;

public class Jugador {
    private Poblacion poblacion;
    private List perteneceAlJugador;
    private String nombre;
    private Oro oro;

    public Jugador(String nombre){
        this.poblacion = new Poblacion();
        this.nombre = nombre;
        this.oro = new Oro();
    }

    public boolean agregarEntidad(Entidad entidad){
        boolean puedeIncrementarLaPoblacion = poblacion.incrementarPoblacion();
        int costes = entidad.costo();
        boolean hayOroSuficiente = ((oro.verOroActual() - costes) > 0);
        if (!puedeIncrementarLaPoblacion || !hayOroSuficiente) {
            return puedeIncrementarLaPoblacion;
        }
        perteneceAlJugador.add(entidad);
        oro.decrementarOro(costes);
        return puedeIncrementarLaPoblacion;
    }
    public boolean agregarEntidadInicioDePartida(Entidad entidad){
        boolean puedeIncrementarLaPoblacion = poblacion.incrementarPoblacion();
        if (!puedeIncrementarLaPoblacion) {
            return puedeIncrementarLaPoblacion;
        }
        perteneceAlJugador.add(entidad);
        return puedeIncrementarLaPoblacion;
    }

    public boolean haPerdido(){
        //return this.poblacion.perdioElCastillo();
        return false;
    }

    public void terminarTurno(){
        //this.poblacion.actuar();
    }

    public int getOro() {
        return oro.verOroActual();
    }
    public int getPoblacion(){
        return poblacion.verPoblacionActual();
    }
}
