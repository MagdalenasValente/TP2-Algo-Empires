package entidades.edificios;

import entidades.unidades.Aldeano;
import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.StateAldeano.RecolectorOro;
import entidades.unidades.Unidad;

import java.awt.Point;

public class Plaza extends Edificio {
    private int vidaMaxima;

    public int reparacion = 15;
    public Plaza() {
        super(450, new Point(2,2), 15);
        this.vidaMaxima = 450;
    }

    public Unidad crearAldeano() {

        Unidad aldeano=  UnidadFactory.crearUnidad(UnidadTipo.UNIDAD_TIPO_ALDEANO);

        return aldeano;

        /*aca estaria el posicionamiento en el terreno de la unidad*/

    }

    @Override
    public void serReparado(Aldeano aldeano){
        int vidaTrasReparacion = this.vida() + 25;
        if(vidaTrasReparacion > this.vidaMaxima){
            super.setVida(vidaMaxima);
            return;
        }
        super.setVida(vidaTrasReparacion);
    }

    public void repararse(Aldeano aldeano){
        if(this.fullVida()) {
            aldeano.setState(new RecolectorOro());
        }
        this.repararVida(reparacion);

    }

    @Override
    public void serConstruido(Aldeano aldeano) {

    }

    public void actuar(){

    }
    
}
