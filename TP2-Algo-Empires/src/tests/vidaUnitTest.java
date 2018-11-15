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
}
