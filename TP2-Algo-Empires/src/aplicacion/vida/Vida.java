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

    public void regenerarVida(int puntosDeVida){
        if (this.vidaActual == this.vidaMaxima){
            throw new VidaLlenaException();
        }
        int vidaRegenerada = this.vidaActual+ puntosDeVida;
        if(vidaRegenerada > this.vidaMaxima){
            this.vidaActual = vidaMaxima;
            return;
        }
        this.vidaActual = vidaRegenerada;
    }

    public Object verVida() {
        return this.vidaActual;
    }
}
