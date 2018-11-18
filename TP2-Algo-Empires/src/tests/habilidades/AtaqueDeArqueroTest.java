package habilidades;

import entidades.Entidad;
import entidades.edificios.Cuartel;
import entidades.unidades.Espadachin;
import habilidades.ataques.Ataque;
import habilidades.ataques.AtaqueDeArquero;
import habilidades.ataques.AtaqueDeEspadachin;
import mapa.Mapa;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void arqueroAtacaAEspadachinQueEstaARango3(){
        Ataque ataque = new AtaqueDeArquero();
        Entidad espadachinAAtacar = new Espadachin();
        Mapa mapa = new Mapa(40,40);
        Point obejetivo = new Point(20,20);
        Point atacante = new Point(17,23);
        mapa.colocar(obejetivo, espadachinAAtacar);
        int vidaInicial = espadachinAAtacar.vida();
        assert(ataque.ejecutarAtaque(mapa,obejetivo,atacante));
        int vidaFinal = espadachinAAtacar.vida();
        assertEquals (vidaInicial, (vidaFinal + 15));
    }

    @Test
    public void arqueroAtacaAEspadachinQueEstaFueraDeAlcanse(){
        Ataque ataque = new AtaqueDeArquero();
        Entidad espadachinAAtacar = new Espadachin();
        Mapa mapa = new Mapa(40,40);
        Point obejetivo = new Point(20,20);
        Point atacante = new Point(15,19);
        mapa.colocar(obejetivo, espadachinAAtacar);
        int vidaInicial = espadachinAAtacar.vida();
        assert(!ataque.ejecutarAtaque(mapa,obejetivo,atacante));
        int vidaFinal = espadachinAAtacar.vida();
        assertEquals (vidaInicial, (vidaFinal));
    }
}
