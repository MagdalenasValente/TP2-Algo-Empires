package habilidades;

import entidades.Entidad;
import entidades.edificios.Cuartel;
import entidades.unidades.Espadachin;
import habilidades.ataques.Ataque;
import habilidades.ataques.AtaqueDeArmaDeAsedio;
import habilidades.ataques.AtaqueDeCastillo;
import mapa.Mapa;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void armaDeAsedioAtacaAEspadachinQueEstaARango5(){
        Ataque ataque = new AtaqueDeArmaDeAsedio();
        Entidad espadachinAAtacar = new Espadachin();
        Mapa mapa = new Mapa(40,40);
        Point obejetivo = new Point(20,20);
        Point atacante = new Point(17,23);
        mapa.colocar(obejetivo, espadachinAAtacar);
        int vidaInicial = espadachinAAtacar.vida();
        assert(ataque.ejecutarAtaque(mapa,obejetivo,atacante));
        int vidaFinal = espadachinAAtacar.vida();
        assertEquals (vidaInicial, (vidaFinal));
    }

    @Test
    public void armaDeAsedioAtacaAEspadachinQueEstaFueraDeAlcanse(){
        Ataque ataque = new AtaqueDeArmaDeAsedio();
        Entidad espadachinAAtacar = new Espadachin();
        Mapa mapa = new Mapa(40,40);
        Point obejetivo = new Point(20,20);
        Point atacante = new Point(14,21);
        mapa.colocar(obejetivo, espadachinAAtacar);
        int vidaInicial = espadachinAAtacar.vida();
        assert(!ataque.ejecutarAtaque(mapa,obejetivo,atacante));
        int vidaFinal = espadachinAAtacar.vida();
        assertEquals (vidaInicial, (vidaFinal));
    }
}
