package habilidades;

import entidades.Entidad;
import entidades.edificios.Cuartel;
import entidades.unidades.Espadachin;
import habilidades.ataques.Ataque;
import habilidades.ataques.AtaqueDeArquero;
import habilidades.ataques.AtaqueDeCastillo;
import habilidades.ataques.AtaqueDeEspadachin;
import mapa.Mapa;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void castilloAtacaAEspadachinQueEstaARango3(){
        Ataque ataque = new AtaqueDeCastillo();
        Entidad espadachinAAtacar = new Espadachin();
        Mapa mapa = new Mapa(40,40);
        Point obejetivo = new Point(20,20);
        Point atacante = new Point(17,23);
        mapa.colocar(obejetivo, espadachinAAtacar);
        int vidaInicial = espadachinAAtacar.vida();
        assert(ataque.ejecutarAtaque(mapa,obejetivo,atacante));
        int vidaFinal = espadachinAAtacar.vida();
        assertEquals (vidaInicial, (vidaFinal + 20));
    }

    @Test
    public void castilloAtacaAEspadachinQueEstaFueraDeAlcanse(){
        Ataque ataque = new AtaqueDeCastillo();
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
