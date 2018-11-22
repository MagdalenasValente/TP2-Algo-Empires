package entidades.unidades.StrategyAldeano;

import entidades.edificios.EdificioConstruible;
import entidades.unidades.Aldeano;

public class Constructor implements StrategyAldeano {

    Aldeano aldeano;
    EdificioConstruible edificio;

    public Constructor (EdificioConstruible edificio, Aldeano aldeano){
        this.edificio = edificio;
        this.aldeano = aldeano;
    }



    public void actuar(){
        this.edificio.construirse();
        if(edificio.construido()) {
            aldeano.setStrategy(new RecolectorOro(aldeano));
        }

    }
}
