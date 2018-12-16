package Control;

import entidades.Entidad;
import entidades.edificios.Castillo;
import entidades.edificios.Cuartel;
import entidades.edificios.Edificio;
import entidades.edificios.Plaza;
import entidades.unidades.Aldeano;
import entidades.unidades.ArmaDeAsedio;
import entidades.unidades.Espadachin;
import entidades.unidades.Unidad;
import interaz.Partida;
import interaz.botones.Boton;
import interaz.botones.BotonParaOrdenesAEntidades;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    public static void visorDeInformacion(Plaza plaza){
        GridPane botonera = new GridPane();
        Boton construirAldeano = InformacionDeControl.crearBotonDeCreacionDeAldeano();
        Text construccion = construccion();
        //botonera
        botonera.add(construirAldeano,2,1);
        botonera.add(construccion,1,1);
        partida.agregarBotonera(botonera);}
    public static void visorDeInformacion(Cuartel cuartel){
        GridPane botonera = new GridPane();
        Boton construirArquero = InformacionDeControl.crearBotonDeCreacionDeArquero();
        Boton construirEspadachin = InformacionDeControl.crearBotonDeCreacionDeEspadachin();
        Text construccion = construccion();
        //botonera
        botonera.add(construirArquero,3,1);
        botonera.add(construirEspadachin,2,1);
        botonera.add(construccion,1,1);
        partida.agregarBotonera(botonera);
    }
    public static void visorDeInformacion(Castillo castillo){
        GridPane botonera = new GridPane();
        Boton atacar = InformacionDeControl.crearBotonDeAtaque();
        Boton construir = InformacionDeControl.crearBotonDeCreacionDeArmaDeAsedio();
        Text construccion = construccion();
        //botonera
        botonera.add(atacar,1,1);
        botonera.add(construir,2,2);
        botonera.add(construccion,1,2);
        partida.agregarBotonera(botonera);
    }
    public static void visorDeInformacion(Aldeano aldeano){
        GridPane botonera = new GridPane();
        Boton mover = InformacionDeControl.crearBotonDeMovimiento();
        //botonera
        botonera.add(mover,1,1);
        partida.agregarBotonera(botonera);
    }
    public static void visorDeInformacion(ArmaDeAsedio armaDeAsedio){
        GridPane botonera = new GridPane();
        Boton atacar = InformacionDeControl.crearBotonDeAtaque();
        Boton montar = InformacionDeControl.crearBotonDeMontarArma();
        Boton mover = InformacionDeControl.crearBotonDeMovimiento();
        if (armaDeAsedio.estaMontada()){
            mover.deshabilitarBoton();
            atacar.habilitarBoton();
        }else{
            atacar.deshabilitarBoton();
            mover.habilitarBoton();
        }
        //botonera
        botonera.add(mover,1,1);
        botonera.add(atacar,2,1);
        botonera.add(montar,3,1);
        partida.agregarBotonera(botonera);}
    public static void visorDeInformacion(Unidad unidad){
        GridPane botonera = new GridPane();
        Boton atacar = InformacionDeControl.crearBotonDeAtaque();
        Boton mover = InformacionDeControl.crearBotonDeMovimiento();
        //botonera
        botonera.add(mover,1,1);
        botonera.add(atacar,2,1);
        partida.agregarBotonera(botonera);
    }
    //en la creacion de botones se deve crear algo para bloquearlos cuando el jugador de turno actual seleccione un enemigo
    private static Text construccion(){
        Text texto = new Text("Construir:");
        texto.setFont(Font.font(20));
        texto.setFill(Color.LIGHTGREEN);
        return texto;
    }
    private static Boton crearBotonDeAtaque(){
        Boton atacar = new BotonParaOrdenesAEntidades("ATQ", Color.RED, Color.PINK);
        return atacar;
    }
    private static Boton crearBotonDeCreacionDeArmaDeAsedio(){
        return crearBotonDeCreacion("Arma de asedio");
    }
    private static Boton crearBotonDeCreacionDeEspadachin(){
        return crearBotonDeCreacion("Espadachin");
    }
    private static Boton crearBotonDeCreacionDeArquero(){
        return crearBotonDeCreacion("Arquero");
    }
    private static Boton crearBotonDeCreacionDeAldeano(){
        return crearBotonDeCreacion("Aldeano");
    }
    private static Boton crearBotonDeCreacion(String nombre){
        Boton construir = new BotonParaOrdenesAEntidades(nombre,Color.GREEN,Color.LIGHTGREEN);
        return construir;
    }
    private static Boton crearBotonDeMovimiento(){
        Boton movimiento = new BotonParaOrdenesAEntidades("MOV",Color.BLUE,Color.LIGHTBLUE);
        return movimiento;
    }
    private static Boton crearBotonDeMontarArma(){
        Boton montar = new BotonParaOrdenesAEntidades("MON",Color.RED,Color.PINK);
        return montar;
    }
}
