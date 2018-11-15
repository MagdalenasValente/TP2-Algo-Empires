package entidades.unidades.StateAldeano;

import entidades.edificios.Edificio;
import entidades.unidades.Aldeano;

public class Reparador implements StateAldeano {

    Edificio edificio;
    public Reparador (Edificio edificio){
        this.edificio = edificio;
    }
    public int juntarOro() {
        return 0;

    }

    public int actuar(Aldeano aldeano){
        edificio.repararse(aldeano);
        return juntarOro();


    }
}
