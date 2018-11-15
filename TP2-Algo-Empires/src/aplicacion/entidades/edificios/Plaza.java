package entidades.edificios;

import entidades.unidades.Unidad;

import java.awt.Point;

public class Plaza extends Edificio {
    private int vidaMaxima;


    public Plaza() {
        super(450, new Point(2,2));
        this.vidaMaxima = 450;
    }

    @Override
    public Unidad reclutar_unidad(Unidad unidad) {
        Unidad nueva_unidad = unidad.crear_unidad();
        /*aca estaria el posicionamiento en el terreno de la unidad*/
        return nueva_unidad;
    }

    @Override
    public void serReparado(){
        int vidaTrasReparacion = this.vida() + 25;
        if(vidaTrasReparacion > this.vidaMaxima){
            super.setVida(vidaMaxima);
            return;
        }
        super.setVida(vidaTrasReparacion);
    }
    
}
