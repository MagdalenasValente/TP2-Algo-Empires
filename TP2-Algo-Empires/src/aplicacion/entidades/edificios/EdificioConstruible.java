package entidades.edificios;
import entidades.edificios.StrategyEdificioConstruible.StrategyConstruible;


public interface EdificioConstruible {

    void setStrategy(StrategyConstruible strategy);
    boolean construido();
    void construirse();

}
