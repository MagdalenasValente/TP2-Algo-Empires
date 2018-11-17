package habilidades;

import entidades.Entidad;
import entidades.edificios.Cuartel;
import entidades.unidades.Espadachin;
import habilidades.ataques.Ataque;
import habilidades.ataques.AtaqueDeArquero;
import org.junit.Test;

public class AtaqueDeArqueroTest {

    @Test
    public void arqueroAtacaAUnEspadachinProvocandoUnaDisminuconDeVidaDe15Puntos(){
        Ataque ataque = new AtaqueDeArquero();
        Entidad espadachin = new Espadachin();
        int vidaInicial = espadachin.vida();
        ataque.atacar(espadachin);
        int vidaFinal = espadachin.vida();
        assert (vidaInicial == (vidaFinal + 15));
    }
    @Test
    public void arqueroAtacaAUnCuartelProvocandoUnaDisminuconDeVidaDe10Puntos(){
        Ataque ataque = new AtaqueDeArquero();
        Entidad cuartel = new Cuartel();
        int vidaInicial = cuartel.vida();
        ataque.atacar(cuartel);
        int vidaFinal = cuartel.vida();
        assert (vidaInicial == (vidaFinal + 10));
    }
}
