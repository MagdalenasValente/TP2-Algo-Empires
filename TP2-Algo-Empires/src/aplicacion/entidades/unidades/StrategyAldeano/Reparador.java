package entidades.unidades.StrategyAldeano;

import entidades.edificios.Edificio;
import entidades.edificios.EdificioReparable;
import entidades.unidades.Aldeano;

public class Reparador implements StrategyAldeano {

    private EdificioReparable edificio;
    private Aldeano aldeano;

    public Reparador (EdificioReparable edificio, Aldeano aldeano){
        this.edificio = edificio;
        this.aldeano = aldeano;
    }


    public void actuar(){
        this.edificio.repararse();
        if(this.edificio.reparado()) {
            this.aldeano.setStrategy(new RecolectorOro(this.aldeano));
        }
    }
}
