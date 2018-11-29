package entidades.edificios;
import entidades.edificios.StrategyEdificioConstruible.StrategyConstruible;


public interface EdificioConstruible {

    public void setStrategy(StrategyConstruible strategy);
    public boolean construido();
    public void construirse();

}
