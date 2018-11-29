package entidadesTest.edificiosTest;

import entidades.unidades.ArmaDeAsedio;
import entidades.unidades.Espadachin;
import entidades.unidades.Unidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastilloEdificioTest {

    @Test
    public void castilloCreaUnidadArmaDeAsedio(){
        Castillo castillo = new Castillo();

        Unidad asedio = castillo.crearAsedio();
        assertEquals(asedio.vida(), 150);/*encontrar otra manera de verificar que sea la unidad correspondiente*/
    }

    @Test
    public void castilloSetearVida(){
        Castillo castillo = new Castillo();

        Unidad asedio = castillo.crearAsedio();
        asedio.setVida(50);
        assertEquals(asedio.vida(), 50);/*encontrar otra manera de verificar que sea la unidad correspondiente*/
    }
    /*Preguntarle al corrector si es nesesario restringir las unidades que se pueden reclutar y hacer pruevas de intentar reclutar unidades invalidas*/

    @Test
    public void castilloAtacarEspadachinCon100DeVidaLeCausa20DeDanio(){
        Castillo castillo = new Castillo();
        Espadachin espadachin = new Espadachin();
        castillo.atacar(espadachin);
        assertEquals(80, espadachin.vida());
    }
}
