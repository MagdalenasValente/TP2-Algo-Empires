package habilidades;

import entidades.Entidad;
import entidades.edificios.Cuartel;
import entidades.unidades.Espadachin;
import habilidades.ataques.Ataque;
import habilidades.ataques.AtaqueDeEspadachin;
import mapa.Mapa;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class AtaqueDeEspadachinTest {

    @Test
    public void espadachinAtacaAUnEspadachinProvocandoUnaDisminuconDeVidaDe25Puntos(){
        Ataque ataque = new AtaqueDeEspadachin();
        Entidad espadachin = new Espadachin();
        assertEquals(espadachin.vida(),100);
        /* int vidaInicial = espadachin.vida();*/
        ataque.atacar(espadachin);
        /*int vidaFinal = espadachin.vida();*/
        /* assert (vidaInicial == (vidaFinal + 25));*/
        assertEquals(75,espadachin.vida());
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

    @Test
    public void espadachinAtacaAEspadachinQueEstaAlLado(){
        Ataque ataque = new AtaqueDeEspadachin();
        Entidad espadachinAAtacar = new Espadachin();
        Mapa mapa = new Mapa(40,40);
        Point obejetivo = new Point(20,20);
        Point atacante = new Point(19,19);
        mapa.colocar(obejetivo, espadachinAAtacar);
        int vidaInicial = espadachinAAtacar.vida();
        assert(ataque.ejecutarAtaque(mapa,obejetivo,atacante));
        int vidaFinal = espadachinAAtacar.vida();
        assertEquals (vidaInicial, (vidaFinal + 25));
    }

    @Test
    public void espadachinAtacaAEspadachinQueEstaFueraDeAlcanse(){
        Ataque ataque = new AtaqueDeEspadachin();
        Entidad espadachinAAtacar = new Espadachin();
        Mapa mapa = new Mapa(40,40);
        Point obejetivo = new Point(20,20);
        Point atacante = new Point(18,19);
        mapa.colocar(obejetivo, espadachinAAtacar);
        int vidaInicial = espadachinAAtacar.vida();
        assert(!ataque.ejecutarAtaque(mapa,obejetivo,atacante));
        int vidaFinal = espadachinAAtacar.vida();
        assertEquals (vidaInicial, (vidaFinal));
    }
}
