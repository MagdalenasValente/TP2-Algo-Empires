package vida;

import excepciones.VidaInvalidaException;
import excepciones.VidaLlenaException;

public class Vida {
    private int vidaMaxima;
    private int vidaActual;

    public Vida(int vidaActual, int vidaMaxima){
        if (vidaActual > vidaMaxima || vidaMaxima < 0 || vidaActual < 0){
            throw new VidaInvalidaException();
        }
        this.vidaActual = vidaActual;
        this.vidaMaxima = vidaMaxima;
    }
    public Vida(int vidaMaxima){
        this.vidaActual = vidaMaxima;
        this.vidaMaxima = vidaMaxima;
    }

    public boolean regenerarVida(int puntosDeVida){
        if (fullVida() || puntosDeVida < 0){
            return false;
        }
        this.vidaActual = this.vidaActual+ puntosDeVida;
        if(this.vidaActual > this.vidaMaxima){ this.vidaActual = vidaMaxima;}
        return true;
    }

    public boolean quitarVida(int puntosDeVida){
        this.vidaActual = this.vidaActual - puntosDeVida;
        if (this.vidaActual <= 0){
            this.vidaActual = 0;
            return true;
        }
        return false;
    }

    public void setVida(int vida){
        this.vidaActual=vida;
    }

    public boolean fullVida(){
        return (this.vidaActual == this.vidaMaxima);
    }
    public int verVida() {
        return this.vidaActual;
    }
}
