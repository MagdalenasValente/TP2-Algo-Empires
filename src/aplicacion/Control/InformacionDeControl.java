package Control;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import entidades.unidades.Aldeano;
import entidades.unidades.ArmaDeAsedio;
import entidades.unidades.Unidad;
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
    //vista de la informacion de las entidades
    public static void visorDeInformacion(Entidad entidad) {
        if (entidad != null){
            entidad.informacionBasica();
        }
    }
    public static void visorDeInformacion(Edificio edificio){}
    public static void visorDeInformacion(Castillo castillo){}
    public static void visorDeInformacion(Aldeano aldeano){}
    public static void visorDeInformacion(ArmaDeAsedio armaDeAsedio){}
    public static void visorDeInformacion(Unidad unidad){}

    private void ventanaDelVisorDeInformacion(){
        JFrame ventana = new JFrame("Introdusca nombre de jugadores");
    }
}
