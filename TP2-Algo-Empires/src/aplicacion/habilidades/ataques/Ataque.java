package habilidades.ataques;

import entidades.Entidad;
import habilidades.Habilidad;

public abstract class Ataque implements Habilidad {

    protected int danio_a_unidades;
    protected int danio_a_edificios;
    private int[] danio = {danio_a_unidades, danio_a_edificios};/*caso de que el danio sea 0 o -1 invalidar el ataque antes de que ocurra*/
    protected int rango;/*el rango debe ser >=1*/
    protected boolean se_deve_montar;


    @Override
    public boolean activarHabilidad(){
        /* pedir coordenadas*/
        /*verificar valides del ataque*/
        /*entidad a atacar debe ser dada por el mapa */
        /*atacar(entidad);*/
        return true;
    }

    public boolean atacar(Entidad entidad){
        entidad.esAtacado(danio);
        return true;
    }

    /*protected boolean elAtaqueEsValido(Ataque ataque){}*/
}
