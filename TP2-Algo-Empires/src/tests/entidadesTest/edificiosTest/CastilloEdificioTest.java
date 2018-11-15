package entidadesTest.edificiosTest;

import entidades.unidades.ArmaDeAsedio;
import entidades.unidades.Unidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CastilloEdificioTest {
    @Test
    public void castilloNuevoTiene1000DeVida(){
        Edificio castillo = new Castillo();
        assertEquals(castillo.vida(), 1000);
    }

    @Test
    public void castilloCreaUnidadArmaDeAsedio(){
        ArmaDeAsedio arma_de_asedio_dummy = new ArmaDeAsedio();/*buscar otra forma de crear la unidad sin nesesidad de un dummy*/
        Edificio castillo = new Castillo();
        Unidad arma_de_asedio = castillo.reclutar_unidad(arma_de_asedio_dummy);
        assertEquals(arma_de_asedio.vida(), 150);/*encontrar otra manera de verificar que sea la unidad correspondiente*/
    }
    /*Preguntarle al corrector si es nesesario restringir las unidades que se pueden reclutar y hacer pruevas de intentar reclutar unidades invalidas*/
}
