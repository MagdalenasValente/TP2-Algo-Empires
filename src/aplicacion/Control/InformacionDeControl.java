package Control;

import entidades.Entidad;
import mapa.Mapa;

import javax.swing.*;
import java.awt.*;

public class InformacionDeControl {
    public static String darUbicacionDeIconoDeEntidad(Entidad entidad){
        String url = "imagenes/" + entidad.getNombre() + ".png";
        return url;
    }
    public static String darUbicacionDeIconoDeEntidadParaFx(Entidad entidad){
        String url = "file:src/interfaz/imagenes/" + entidad.getNombre() + ".png";
        return url;
    }
}
