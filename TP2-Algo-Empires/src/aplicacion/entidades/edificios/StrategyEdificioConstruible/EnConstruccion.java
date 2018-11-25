package entidades.edificios.StrategyEdificioConstruible;

import entidades.edificios.EdificioConstruible;
import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

public class EnConstruccion implements StrategyConstruible {


    private EdificioConstruible edificio;
    private int contadorTurnos = 0;

    public EnConstruccion (EdificioConstruible edificio){
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
