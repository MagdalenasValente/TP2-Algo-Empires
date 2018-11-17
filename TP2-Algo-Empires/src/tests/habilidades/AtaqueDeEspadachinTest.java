package habilidades;

import entidades.Entidad;
import entidades.edificios.Cuartel;
import entidades.unidades.Espadachin;
import habilidades.ataques.Ataque;
import habilidades.ataques.AtaqueDeEspadachin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtaqueDeEspadachinTest {

    @Test
    public void espadachinAtacaAUnEspadachinProvocandoUnaDisminuconDeVidaDe25Puntos(){
        Ataque ataque = new AtaqueDeEspadachin();
        Entidad espadachin = new Espadachin();
       /* int vidaInicial = espadachin.vida();*/
        ataque.atacar(espadachin);
        /*int vidaFinal = espadachin.vida();*/
       /* assert (vidaInicial == (vidaFinal + 25));*/
        assertEquals(espadachin.vida(),75);
    }
    @Test
    public void espadachinAtacaAUnCuartelProvocandoUnaDisminuconDeVidaDe15Puntos(){
        Ataque ataque = new AtaqueDeEspadachin();
        Entidad cuartel = new Cuartel();
        int vidaInicial = cuartel.vida();
        ataque.atacar(cuartel);
        int vidaFinal = cuartel.vida();
        assert (vidaInicial == (vidaFinal + 15));
    }
}
