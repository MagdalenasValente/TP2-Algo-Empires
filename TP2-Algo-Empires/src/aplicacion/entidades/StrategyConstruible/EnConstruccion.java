package entidades.StrategyConstruible;

import entidades.edificios.Construible;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

public class EnConstruccion implements StrategyConstruible {


    Construible edificio;
    private int contadorTurnos = 0;

    public EnConstruccion (Construible edificio){
        this.edificio = edificio;
    }

    public void construirse() {
        contadorTurnos++;
        if(construido()) {
            edificio.setStrategy(new Construido());
        }
    }

    public boolean construido() {
        return (contadorTurnos == 3);
    }

    public Unidad crearUnidad(UnidadTipo tipo) {
        return null;
    }
    public void actuar(){

    }
}
