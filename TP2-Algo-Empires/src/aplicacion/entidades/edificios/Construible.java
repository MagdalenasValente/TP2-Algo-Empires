package entidades.edificios;
import entidades.StrategyConstruible.StrategyConstruible;


public interface Construible {

    public void actuar();
    public void setStrategy(StrategyConstruible strategy);
    public boolean construido();
    public void construirse();

}
