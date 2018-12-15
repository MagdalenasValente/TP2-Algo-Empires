package Control;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Edificio;
import entidades.unidades.Aldeano;
import entidades.unidades.ArmaDeAsedio;
import entidades.unidades.Unidad;
import interaz.Partida;
import interaz.botones.Boton;
import interaz.botones.BotonParaOrdenesAEntidades;
import javafx.scene.layout.GridPane;
import juego.Jugador;
import mapa.Mapa;

import javax.swing.*;
import java.awt.*;
import javafx.scene.paint.Color;

public class InformacionDeControl {
    public static Partida partida;
    public static String darUbicacionDeIconoDeEntidad(Entidad entidad){
        String url = "imagenes/" + entidad.getNombre() + ".png";
        return url;
    }
    public static String darUbicacionDeIconoDeEntidadParaFx(Entidad entidad){
        String url = "file:src/interfaz/imagenes/" + entidad.getNombre() + ".png";
        return url;
    }
    //datos jugador
    public static void jugadorPoblacion(Jugador jugador){}
    public static void jugadorOro(Jugador jugador){}
    //vista de la informacion de las entidades
    public static void visorDeInformacion(Point ubicacion){}
    public static void visorDeInformacion(Entidad entidad) {
        /*if (entidad != null){
            entidad.informacionBasica();
        }*/
        partida.actulizarInfoEntidad(entidad);
        entidad.informacionBasica();
    }
    public static void visorDeInformacion(Edificio edificio){
        //partida.agregarBotonera(null);
    }
    public static void visorDeInformacion(Castillo castillo){
        GridPane botonera = new GridPane();
        InformacionDeControl.crearBotonDeAtaque();
        //botonera
        partida.agregarBotonera(botonera);}
    public static void visorDeInformacion(Aldeano aldeano){}
    public static void visorDeInformacion(ArmaDeAsedio armaDeAsedio){}
    public static void visorDeInformacion(Unidad unidad){}
    private static Boton crearBotonDeAtaque(){
        Boton atacar = new BotonParaOrdenesAEntidades("ATQ", Color.RED, Color.PINK);
        return atacar;
    }
}
