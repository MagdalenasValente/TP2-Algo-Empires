package entidades.StrategyConstruible;

import entidades.unidades.FactoryUnidades.UnidadFactory;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

public class Construido implements StrategyConstruible {

    public void construirse(){
        return;
    }
    public boolean construido() {
        return true;
    }

    public Unidad crearUnidad(UnidadTipo tipo) {
        return UnidadFactory.crearUnidad(tipo);
    }

    public void actuar(){

    }


}
