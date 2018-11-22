package habilidades.montar;


import excepciones.OrdenDeMontajeFallidaException;
import habilidades.Habilidad;

public class Montado implements Habilidad {
    private boolean estaMontado = false;

    @Override
    public boolean activarHabilidad(){
        /*try {
            if (estaMontado){
                desMontar();
            }
            else desMontar();
        }
        catch (return false;);*/
        return true;
    }

    public void montar(){
        if (estaMontado){
            throw new OrdenDeMontajeFallidaException();
        }
        estaMontado = true;
    }

    public void desMontar(){
        if (!estaMontado){
            throw new OrdenDeMontajeFallidaException();
        }
        estaMontado = false;
    }
}
