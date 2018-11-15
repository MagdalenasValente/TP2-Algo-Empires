package entidades.edificios;


import entidades.unidades.Unidad;

import java.awt.Point;

public class Castillo extends Edificio{

    private int vidaMaxima;

    public Castillo() {
    	super(1000, new Point(4,4));
    	this.vidaMaxima = 1000;
    }


    @Override
    public Unidad reclutar_unidad(Unidad unidad) {
        Unidad nueva_unidad = unidad.crear_unidad();
        /*aca estaria el posicionamiento en el terreno de la unidad*/
        return nueva_unidad;
    }
}
