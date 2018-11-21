package entidades.unidades.StrategyAldeano;

import entidades.unidades.Aldeano;

public class RecolectorOro implements StrategyAldeano {

    Aldeano aldeano;
    public RecolectorOro (Aldeano aldeano){
        this.aldeano = aldeano;
    }

    public void juntarOro() {
        aldeano.sumarOro(20);

    }
    public void actuar(){
        juntarOro();
    }
}
