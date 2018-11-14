package aplicacion;

import java.awt.Point;

public class Castillo extends Edificio{
    private int vida;
    private Point tamaño;

    public Castillo() {
    	super(1000);
        this.tamaño = new Point(4,4);
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
        return nueva_unidad;
    }
}
