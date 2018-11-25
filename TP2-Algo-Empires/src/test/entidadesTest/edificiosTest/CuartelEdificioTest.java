package entidadesTest.edificiosTest;

import static org.junit.Assert.*;

import entidades.edificios.Edificio;
import org.junit.Test;

import entidades.unidades.Unidad;
import entidades.edificios.Cuartel;

public class CuartelEdificioTest {

    @Test
    public void cuartelNuevoTiene250DeVida(){
        Edificio cuartel = new Cuartel();
        assertEquals(cuartel.vida(), 250);
    }


//
//    @Test
//    public void cuartelCreaUnidadEspadachin(){
//        Cuartel cuartel = new Cuartel();
//        Unidad espadachin = cuartel.crearEspadachin();
//        assertEquals(espadachin.vida(), 100);
//    }
//    @Test
//    public void cuartelCreaUnidadArquero(){
//        Cuartel cuartel = new Cuartel();
//        Unidad arquero = cuartel.crearArquero();
//        assertEquals(arquero.vida(), 75);
//    }

    @Test
    public void alCrearCuartelEstaEnConstruccionDevuelveNullAlCreaUnidadArquero(){
        Cuartel cuartel = new Cuartel();
        Unidad arquero = cuartel.crearArquero();
        assertEquals(arquero, null);
    }

    @Test
    public void alCrearCuartelEstaEnConstruccionDevuelveNullAlCreaUnidadEspadachin(){
        Cuartel cuartel = new Cuartel();
        Unidad espadachin = cuartel.crearEspadachin();
        assertEquals(espadachin, null);
    }

    /*Preguntarle al corrector si es nesesario restringir las unidades que se pueden reclutar y hacer pruebas de intentar reclutar unidades invalidas*/
}
