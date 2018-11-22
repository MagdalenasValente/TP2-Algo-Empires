import juego.Poblacion;
import org.junit.Test;

public class PoblacionTest {

    @Test
    public void seIniciaCon0DePoblacion(){
        Poblacion poblacion = new Poblacion();
        assert(poblacion.verPoblacionActual() == 0);
    }

    @Test
    public void seIncrementaLaPoblacionA50YNosePuedeIncrementarMas(){
        Poblacion poblacion = new Poblacion();
        for (int i = 0; i < 50; i++){
            assert(poblacion.incrementarPoblacion());
        }
        assert(poblacion.verPoblacionActual() == 50);
        assert(!poblacion.incrementarPoblacion());
        assert(poblacion.verPoblacionActual() == 50);
    }

    @Test
    public void seTrataDeDecrementarLaPoblacionAMenosDe0YNosePuedeDecrementarMas(){
        Poblacion poblacion = new Poblacion();
        assert(poblacion.incrementarPoblacion());
        assert(poblacion.verPoblacionActual() == 1);
        assert(poblacion.decrementarPoblacion());
        assert(poblacion.verPoblacionActual() == 0);
        assert(!poblacion.decrementarPoblacion());
        assert(poblacion.verPoblacionActual() == 0);
    }
}
