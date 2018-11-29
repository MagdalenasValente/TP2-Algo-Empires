package juego;

import entidades.edificios.*;
import entidades.unidades.*;

public class Poblacion {
    private int limiteMaximoDePobacion;
    private int poblacionActual;
    private Castillo castillo;
    private Aldeano[] aldeanos;
    private Espadachin[] espadachines;
    private Arquero[] arqueros;
    private ArmaDeAsedio[] armasDeAsedio;
    private Plaza[] plazas;
    private Cuartel[] cuarteles;

    public Poblacion(){
        this.limiteMaximoDePobacion = 50;
        this.poblacionActual = 0;

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

    public boolean perdioElCastillo(){
        return true;//Agregar logica
    }

    public void actuar(){

    }
}
