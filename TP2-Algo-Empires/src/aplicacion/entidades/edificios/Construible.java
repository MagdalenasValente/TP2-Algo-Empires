package entidades.edificios;
import entidades.edificios.StrategyEdificioConstruible.StrategyConstruible;


public interface Construible {

    public void setStrategy(StrategyConstruible strategy);
    public boolean construido();
    public void construirse();

}
