package entidadesTest.edificiosTest;

import static org.junit.Assert.*;

import entidades.edificios.Edificio;
import org.junit.Test;

import entidades.unidades.Espadachin;
import entidades.unidades.Arquero;
import entidades.unidades.Unidad;
import entidades.edificios.Cuartel;

public class CuartelEdificioTest {

    @Test
    public void cuartelNuevoTiene250DeVida(){
        Edificio cuartel = new Cuartel();
        assertEquals(cuartel.vida(), 250);
    }

    @Test
    public void cuartelCreaUnidadEspadachin(){
        Espadachin espadachin_dummy = new Espadachin();
        Edificio cuartel = new Cuartel();
        Unidad espadachin = cuartel.reclutar_unidad(espadachin_dummy);
        assertEquals(espadachin.vida(), 100);
    }

    @Test
    public void cuartelCreaUnidadArquero(){
        Arquero arquero_dummy = new Arquero();
        Edificio cuartel = new Cuartel();
        Unidad arquero = cuartel.reclutar_unidad(arquero_dummy);
        assertEquals(arquero.vida(), 75);
    }
    /*Preguntarle al corrector si es nesesario restringir las unidades que se pueden reclutar y hacer pruevas de intentar reclutar unidades invalidas*/
}
