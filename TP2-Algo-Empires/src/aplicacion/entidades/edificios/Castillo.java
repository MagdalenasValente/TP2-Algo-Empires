package entidades.edificios;


import entidades.unidades.Unidad;

import java.awt.Point;

public class Castillo extends Edificio{

    private Point tamanio;

    public Castillo() {
    	super(1000, new Point(4,4));
    }


    @Override
    public Unidad reclutar_unidad(Unidad unidad) {
        Unidad nueva_unidad = unidad.crear_unidad();
        /*aca estaria el posicionamiento en el terreno de la unidad*/
        return nueva_unidad;
    }
}
