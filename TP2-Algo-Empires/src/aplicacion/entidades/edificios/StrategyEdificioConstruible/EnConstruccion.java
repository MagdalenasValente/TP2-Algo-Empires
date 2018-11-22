package entidades.edificios.StrategyEdificioConstruible;

import entidades.edificios.Construible;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

public class EnConstruccion implements StrategyConstruible {


    private Construible edificio;
    private int contadorTurnos = 0;

    public EnConstruccion (Construible edificio){
        this.edificio = edificio;
    }

    public void construirse() {
        this.contadorTurnos++;
        if(construido()) {
            this.edificio.setStrategy(new Construido());
        }
    }

    public boolean construido() {
        return (this.contadorTurnos == 3);
    }

    public Unidad crearUnidad(UnidadTipo tipo) {
        return null;
    }

}
