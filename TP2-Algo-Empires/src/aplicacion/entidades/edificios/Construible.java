package entidades.edificios;
import entidades.edificios.StrategyConstruible.StrategyConstruible;


public interface Construible {

    public void setStrategy(StrategyConstruible strategy);
    public boolean construido();
    public void construirse();

}
