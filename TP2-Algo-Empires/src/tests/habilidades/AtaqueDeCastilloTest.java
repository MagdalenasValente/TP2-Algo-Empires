package habilidades;

import entidades.Entidad;
import entidades.edificios.Cuartel;
import entidades.unidades.Espadachin;
import habilidades.ataques.Ataque;
import habilidades.ataques.AtaqueDeCastillo;
import org.junit.Test;

public class AtaqueDeCastilloTest {

    @Test
    public void arqueroAtacaAUnEspadachinProvocandoUnaDisminuconDeVidaDe20Puntos(){
        Ataque ataque = new AtaqueDeCastillo();
        Entidad espadachin = new Espadachin();
        int vidaInicial = espadachin.vida() + 0;
        ataque.atacar(espadachin);
        int vidaFinal = espadachin.vida() + 0;
        assert (vidaInicial == (vidaFinal + 20));
    }
    @Test
    public void arqueroAtacaAUnCuartelProvocandoUnaDisminuconDeVidaDe20Puntos(){
        Ataque ataque = new AtaqueDeCastillo();
        Entidad cuartel = new Cuartel();
        int vidaInicial = cuartel.vida() + 0;
        ataque.atacar(cuartel);
        int vidaFinal = cuartel.vida() + 0;
        assert (vidaInicial == (vidaFinal + 20));
    }
}
