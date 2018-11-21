package juego;

public class Poblacion {
    int limiteMaximoDePobacion;
    int poblacionActual;

    public Poblacion(){
        limiteMaximoDePobacion = 50;
        poblacionActual = 0;
    }

    public boolean incrementarPoblacion(){
        if (poblacionActual == limiteMaximoDePobacion){
            return false;
        }
        poblacionActual++;
        return true;
    }

    public boolean decrementarPoblacion(){
        if (poblacionActual == 0){
            return false;
        }
        poblacionActual--;
        return true;
    }

    public int verPoblacionActual(){
        return poblacionActual;
    }
}
