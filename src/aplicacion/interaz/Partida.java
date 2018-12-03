package interaz;

import Control.IniciarJuego;
import Control.eventos.PantallaCompleta;
import Control.eventos.SalirDelJuego;
import entidades.Entidad;
import entidades.unidades.Espadachin;
import interaz.botones.Boton;
import interaz.botones.BotonParaMenu;
import interaz.botones.BotonParaToolBar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class Partida {

    private ToolBar toolBar;
    private ImageView fondoTablero;
    private HBox infoEntidades;
    private Stage stage;
    public Boton anterior;
    public Boton fin;
    private IniciarJuego juego;

    public Partida(Stage stage, IniciarJuego juego)/* throws Exception*/ {
        this.stage = stage;
        this.juego = juego;
/*
        this.crearBarraDeOpciones();
        Text centerText = new Text("Center");
        Text topText = new Text("Aca Estaria El menu");
        Text rightText = new Text("Right");
        Text leftText = new Text("Left");

        //test debe ser borrado
        Entidad espachin = new Espadachin();

        //Caja Inferior con informacion de la entidad
        InfoEntidad generadorDeInfo = new InfoEntidad();
        HBox cajaInferior = generadorDeInfo.generarInfo(espachin);

        javafx.scene.layout.BorderPane root = new javafx.scene.layout.BorderPane(centerText, toolBar, rightText, cajaInferior, leftText);
        root.setPrefSize(800, 600);//resolucion

        Scene scene = new Scene(root);*/
    }

    public BorderPane crearPartida(){
        this.crearBarraDeOpciones();
        InfoEntidad infoEntidad = new InfoEntidad();

        //Espadachin espadachin = new Espadachin();//debug
        HBox cajaInferior = infoEntidad.generarInfo(null);

        javafx.scene.layout.BorderPane root = new javafx.scene.layout.BorderPane(null/*mapa*/, toolBar, null, cajaInferior, null);
        return root;
    }

    private void crearBarraDeOpciones(){

        VBox opcionesDeSalida = new VBox();
        Boton salirDeLaPartida = new BotonParaToolBar(ConstantesPantalla.toolBarSalirPartida);
        Boton salirDelJuego = new BotonParaToolBar(ConstantesPantalla.toolBarSalirJuego);
        opcionesDeSalida.getChildren().addAll(salirDeLaPartida,salirDelJuego);
        anterior = salirDeLaPartida;
        new SalirDelJuego(salirDelJuego,stage);

        VBox opcionesDePantalla = new VBox();
        Boton pantallaCompleta = new BotonParaToolBar(ConstantesPantalla.pantallaCompleta);
        opcionesDePantalla.getChildren().addAll(pantallaCompleta);
        new PantallaCompleta(pantallaCompleta, stage);

        Boton finalizarTurno = new BotonParaMenu("FIN DEL TURNO");
        fin = finalizarTurno;

        Text jugadorActual = new Text(juego.turnoDeJugador);
        jugadorActual.setFont(Font.font(24));
        jugadorActual.setFill(Color.BLACK);
        ToolBar tools = new ToolBar(opcionesDeSalida,opcionesDePantalla,finalizarTurno);

        //tools.getChildrenUnmodifiable().addAll(opcionesDeSalida,opcionesDePantalla,finalizarTurno,jugadorActual);

        this.toolBar = tools;
    }
/*
    private void crearMapa(){


        InputStream entradaImagen;
        try {
            entradaImagen = Files.newInputStream(Paths.get("file:src/interaz/imagenes/tablero.jpg"));
            Image imagen = new Image(entradaImagen);
            entradaImagen.close();
            ImageView vistaImagen = new ImageView(imagen);
            vistaImagen.setFitWidth(ConstantesPantalla.anchoImagenFondo);
            vistaImagen.setFitHeight(ConstantesPantalla.altoImagenFondo);
            this.fondoTablero =  vistaImagen;
        } catch (IOException e) {
        }

    }*/

    public void actualizarMapa(){}
}

