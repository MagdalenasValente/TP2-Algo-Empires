package entidades.unidades.StateAldeano;

import entidades.edificios.Edificio;
import entidades.unidades.Aldeano;

public class Reparador implements StrategyAldeano {

    Edificio edificio;
    Aldeano aldeano;
    public Reparador (Edificio edificio, Aldeano aldeano){
        this.edificio = edificio;
        this.aldeano = aldeano;
    }



    public void actuar(){

        edificio.repararse();
        if(edificio.fullVida()) {
            aldeano.setStrategy(new RecolectorOro(aldeano));
        }



    }
}
