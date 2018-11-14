package aplicacion;

import java.awt.Point;

public class Cuartel extends Edificio{
    private int vida;
	private Point tamaño;
    
    public Cuartel() {
        super(250);
        this.tamaño = new Point(2,2);
    }

    @Override
    public int vida(){
        return this.vida;
    }
    
    @Override
    public Point verTamaño() {
    	return this.tamaño;
    }


    @Override
    public Unidad reclutar_unidad(Unidad unidad) {
        Unidad nueva_unidad = unidad.crear_unidad();
        /*aca estaria el posicionamiento en el terreno de la unidad. se podria usar una fabrica de unidades*/
        return nueva_unidad;
    }

}
