package entidades.edificios;


import entidades.unidades.Unidad;

import java.awt.Point;

public class Castillo extends Edificio{
    private int vida;
    private Point tamanio;

    public Castillo() {
    	super(1000);
        this.tamanio = new Point(4,4);
    }

    @Override
    public int vida(){
        return this.vida;
    }



    public Point vertamanio() {
    	return this.tamanio;
    }


    @Override
    public Unidad reclutar_unidad(Unidad unidad) {
        Unidad nueva_unidad = unidad.crear_unidad();
        /*aca estaria el posicionamiento en el terreno de la unidad*/
        return nueva_unidad;
    }
}
