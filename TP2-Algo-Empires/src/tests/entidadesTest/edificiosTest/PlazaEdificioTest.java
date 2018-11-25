package entidadesTest.edificiosTest;

import static org.junit.Assert.*;

import entidades.edificios.Edificio;
import org.junit.Test;

import entidades.unidades.Aldeano;
import entidades.unidades.Unidad;
import entidades.edificios.Plaza;

public class PlazaEdificioTest {
    @Test
    public void plazaNuevaTiene450DeVida(){
        Edificio plaza = new Plaza();
        assertEquals(plaza.vida(), 450);
    }

    @Test
    public void plazaCreaUnidadAldeano(){
        Plaza plaza = new Plaza();
        Unidad aldeano = plaza.crearAldeano();
        assertEquals(aldeano, null);
    }
    /*Preguntarle al corrector si es nesesario restringir las unidades que se pueden reclutar y hacer pruevas de intentar reclutar unidades invalidas*/
}