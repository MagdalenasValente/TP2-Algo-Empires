package entidades.edificios;

import entidades.unidades.Unidad;

import java.awt.Point;

public class Cuartel extends Edificio {
    private int vida;
	private Point tamanio;
    
    public Cuartel() {
        super(250);
        this.tamanio = new Point(2,2);
    }

    @Override
    public int vida(){
        return this.vida;
    }
    
    //@Override
    //public Point vertamanio() {
    //	return this.tamanio;
    //}


    //@Override
    //public Unidad reclutar_unidad(Unidad unidad) {
    //    Unidad nueva_unidad = unidad.crear_unidad();
    //    /*aca estaria el posicionamiento en el terreno de la unidad. se podria usar una fabrica de unidades*/
    //    return nueva_unidad;
    //}

}
