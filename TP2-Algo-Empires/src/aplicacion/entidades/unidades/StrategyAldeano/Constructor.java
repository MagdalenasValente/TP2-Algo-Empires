package entidades.unidades.StrategyAldeano;

import entidades.edificios.Construible;
import entidades.unidades.Aldeano;

public class Constructor implements StrategyAldeano {

    Aldeano aldeano;
    Construible edificio;
    public Constructor (Construible edificio, Aldeano aldeano){
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
