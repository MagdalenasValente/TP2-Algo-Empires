/*@class FactoryUnidades
 * Clase que implementa el patrón Factory para crear Unidades.
 * */

package entidades.unidades.FactoryUnidades;
import entidades.unidades.*;

public class UnidadFactory {


    public static Unidad crearUnidad(UnidadTipo tipo) throws InvalidUnidadTipoException{
        if (tipo.equals(UnidadTipo.UNIDAD_TIPO_ALDEANO))
            return new Aldeano();
        else if (tipo.equals(UnidadTipo.UNIDAD_TIPO_ARMA_DE_ASEDIO))
            return new ArmaDeAsedio();
        else if (tipo.equals(UnidadTipo.UNIDAD_TIPO_ARQUERO))
            return new Arquero();
        else if (tipo.equals(UnidadTipo.UNIDAD_TIPO_ESPADACHIN))
            return new Espadachin();


        else throw new InvalidUnidadTipoException();
    }
}