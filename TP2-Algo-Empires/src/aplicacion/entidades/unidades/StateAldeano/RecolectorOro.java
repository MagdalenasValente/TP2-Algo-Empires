package entidades.unidades.StateAldeano;

import entidades.unidades.Aldeano;

public class RecolectorOro implements StateAldeano {

    @Override
    public int juntarOro() {
        return 20;

    }
    public int actuar(Aldeano aldeano){
        return juntarOro();
    }
}
