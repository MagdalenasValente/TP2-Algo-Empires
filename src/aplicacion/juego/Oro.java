package juego;

public class Oro {
    private int oroActual;

    public Oro(){
        this.oroActual = 100;
    }

    public boolean incrementarOro(int cantidad){
        this.oroActual = this.oroActual + cantidad;
        return true;
    }

    public boolean decrementarOro(int cantidad){
        if (this.oroActual -  cantidad < 0){
            return false;
        }
        this.oroActual = this.oroActual - cantidad;
        return true;
    }

    public int verOroActual(){
        return this.oroActual;
    }
}
