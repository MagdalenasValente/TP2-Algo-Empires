package entidades.unidades.StrategyAldeano;

import entidades.edificios.Edificio;
import entidades.unidades.Aldeano;

public class Reparador implements StrategyAldeano {

    private Edificio edificio;
    private Aldeano aldeano;

    public Reparador (Edificio edificio, Aldeano aldeano){
        this.edificio = edificio;
        this.aldeano = aldeano;
    }


    public void actuar(){
        this.edificio.repararse();
        if(this.edificio.fullVida()) {
            this.aldeano.setStrategy(new RecolectorOro(this.aldeano));
        }
    }
}
