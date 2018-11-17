package habilidades;

import entidades.Entidad;
import entidades.edificios.Cuartel;
import entidades.unidades.Espadachin;
import habilidades.ataques.Ataque;
import habilidades.ataques.AtaqueDeArmaDeAsedio;
import org.junit.Test;

public class AtaqueDeArmaDeAsedioTest {

    @Test
    public void armaDeAsedioAtacaAUnEspadachinProvocandoUnaDisminuconDeVidaDe0Puntos(){
        /*modificar la prueva para que o pueda atacar unidades*/
        Ataque ataque = new AtaqueDeArmaDeAsedio();
        Entidad espadachin = new Espadachin();
        int vidaInicial = espadachin.vida();
        ataque.atacar(espadachin);
        int vidaFinal = espadachin.vida();
        assert (vidaInicial == (vidaFinal + 0));
    }
    @Test
    public void armaDeAsedioAtacaAUnCuartelProvocandoUnaDisminuconDeVidaDe75Puntos(){
        Ataque ataque = new AtaqueDeArmaDeAsedio();
        Entidad cuartel = new Cuartel();
        int vidaInicial = cuartel.vida();
        ataque.atacar(cuartel);
        int vidaFinal = cuartel.vida();
        assert (vidaInicial == (vidaFinal + 75));
    }
}
