import excepciones.VidaInvalidaException;
import excepciones.VidaLlenaException;
import org.junit.Test;
import vida.Vida;

import static org.junit.Assert.*;

public class vidaUnitTest {
    @Test
    public void regenerarVidaSinPasarceDelMaximoResultadoCorrecto() {
        Vida vida = new Vida(50, 100);
        vida.regenerarVida(40);
        assertEquals(vida.verVida(), 90);

    }

    @Test
    public void regenerarVidaPasandoseDelMaximoLoDejaConLaVidaLlena() {
        Vida vida = new Vida(80, 100);
        vida.regenerarVida(40);
        assertEquals(vida.verVida(), 100);
    }

    @Test
    public void regenerarVidaConLaVidaLlenaLevantaVidaLlenaException() {
        Vida vida = new Vida(100, 100);
        boolean lanzoLaExcepcion = false;
        try {
            vida.regenerarVida(40);
        } catch (VidaLlenaException e) {
            lanzoLaExcepcion = true;
        }
        assert(lanzoLaExcepcion);
    }

    @Test
    public void crearVidaConMasVidaActualQueVidaMaximaLevantaVidaInvalidaException() {
        boolean lanzoLaExcepcion = false;
        try {
            Vida vida = new Vida(120, 100);
        } catch (VidaInvalidaException e) {
            lanzoLaExcepcion = true;
        }
        assert(lanzoLaExcepcion);
    }

    @Test
    public void quitarVidaDaFalseSiNoLlegaACero(){
        Vida vida = new Vida(100, 100);
        assert (!vida.quitarVida(50));
    }

    @Test
    public void quitarVidaDaTrueSiLlegaACeroOMenos(){
        Vida vida = new Vida(100, 100);
        assert (vida.quitarVida(100));
        assert (vida.quitarVida(120));
    }

    @Test
    public void quitarVidaEnCasoDeLlegarAMenosQueCeroDejaLaVidaEnCero(){
        Vida vida = new Vida(100, 100);
        vida.quitarVida(150);
        assert (vida.verVida() == 0);
    }

    @Test
    public void leQuito20DeVidaA100DebenQuedar80DeVida(){
        Vida vida = new Vida(100, 100);
        vida.quitarVida(20);
        assert (vida.verVida() == 80);
    }
}
