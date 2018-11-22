package entidades.unidades.StrategyAldeano;

import entidades.edificios.EdificioConstruible;
import entidades.unidades.Aldeano;

public class Constructor implements StrategyAldeano {

    private Aldeano aldeano;
    private Construible edificio;

    public Constructor (EdificioConstruible edificio, Aldeano aldeano){
        this.edificio = edificio;
        this.aldeano = aldeano;
    }



    public void actuar(){
        this.edificio.construirse();
        if(this.edificio.construido()) {
            this.aldeano.setStrategy(new RecolectorOro(this.aldeano));
        }

    }
}
