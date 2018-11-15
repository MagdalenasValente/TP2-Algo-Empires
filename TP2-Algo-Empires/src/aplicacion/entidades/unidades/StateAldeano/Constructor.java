package entidades.unidades.StateAldeano;

import entidades.edificios.Edificio;
import entidades.unidades.Aldeano;

public class Constructor implements StateAldeano{

    Edificio edificio;
    public Constructor (Edificio edificio){
        this.edificio = edificio;
    }

    public int juntarOro() {
        return 0;
    }

    @Override
    public int actuar(Aldeano aldeano) {
        edificio.serConstruido(aldeano);
        return juntarOro();

    }
}
