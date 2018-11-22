package entidades.edificios.StrategyEdificioConstruible;

import entidades.unidades.FactoryUnidades.UnidadTipo;
import entidades.unidades.Unidad;

public interface StrategyConstruible {

    public Unidad crearUnidad(UnidadTipo tipo);
    public boolean construido();
    public void construirse();

}