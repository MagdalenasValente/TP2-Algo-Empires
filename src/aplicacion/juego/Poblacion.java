package juego;

public class Poblacion {
    private int limiteMaximoDePobacion;
    private int poblacionActual;

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
}
