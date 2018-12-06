package interaz;

import Control.IniciarJuego;
import Control.eventos.PantallaCompleta;
import Control.eventos.SalirDelJuego;
import interaz.botones.BotonParaMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuPrincipal extends StackPane {

    public Stage stage;
    //private BorderPane menuRaiz;
    private BorderPane menuPrincipal;
    private BorderPane menuJuego;
    private BorderPane menuOpcionesGraficas;
    //public Stage juego;
    private BorderPane tableroDeJuego;

    public MenuPrincipal(Stage stage) {
        this.stage = stage;
        //fondo
        Image imagenDeFondoDelMenu = new Image("file:src/interaz/imagenes/menu.jpg");
        BackgroundSize size = new BackgroundSize(ConstantesPantalla.altoImagenFondo,ConstantesPantalla.anchoImagenFondo, false,false,true,true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagenDeFondoDelMenu, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,size);
        this.setBackground(new Background(imagenDeFondo));


        this.crearPrincipal();
        this.crearJuego();
        this.crearOpcionesGraficas();

        this.getChildren().addAll(menuPrincipal);
    }

    private void crearPrincipal(){

        //top
        Text titulo = Textos.tituloNuevo(ConstantesPantalla.tituloDelJuego, ConstantesPantalla.tamanioFuenteTituloMenuPrincipal, Color.LIGHTBLUE, Color.GREEN,2);
        //
        //left
        VBox opciones = new VBox();

        BotonParaMenu botonParaMenuEmpezar = new BotonParaMenu(ConstantesPantalla.empezarPartida);
        //new CambiarDeMenu(botonParaMenuEmpezar, this , menuPrincipal, menuJuego);
        botonParaMenuEmpezar.setOnMouseClicked(evento -> {
            this.getChildren().remove(menuPrincipal);
            this.getChildren().add(menuJuego);
        });

        BotonParaMenu botonParaOpcionesGraficas = new BotonParaMenu(ConstantesPantalla.opcionesGraficas);
        botonParaOpcionesGraficas.setOnMouseClicked(evento -> {
            this.getChildren().remove(menuPrincipal);
            this.getChildren().add(menuOpcionesGraficas);
        });

        BotonParaMenu botonParaMenuSalir = new BotonParaMenu(ConstantesPantalla.salir);
        new SalirDelJuego(botonParaMenuSalir,stage);

        opciones.getChildren().addAll(botonParaMenuEmpezar,botonParaOpcionesGraficas,botonParaMenuSalir);
        //agregar al menu
        menuPrincipal = new javafx.scene.layout.BorderPane(null, titulo, null, null, opciones);
        menuPrincipal.setAlignment(titulo,Pos.TOP_CENTER);
        menuPrincipal.setMargin(opciones, new Insets(12,12,12,20));
    }

    private void crearJuego(){
        //top
        /*
        Text titulo = new Text(ConstantesPantalla.empezarPartida);
        titulo.setFont(new Font("TimesRoman", ConstantesPantalla.tamanioFuenteTituloMenuPrincipal));
        titulo.setFill(Color.LIGHTBLUE);
        titulo.setStroke(Color.GREEN);
        titulo.setStrokeWidth(2);*/

        Text titulo = Textos.tituloNuevo(ConstantesPantalla.empezarPartida, ConstantesPantalla.tamanioFuenteTituloMenuPrincipal, Color.LIGHTBLUE, Color.GREEN,2);

        //left
        VBox opciones = new VBox();
        BotonParaMenu botonParaMapaPequenio = new BotonParaMenu(ConstantesPantalla.empezarMapaPequenio);
        botonParaMapaPequenio.setOnMouseClicked(evento -> {
            this.iniciarMapaPequenio();
        });
        //this.juego
        //botonParaMapaPequenio.deshabilitarBoton();

        BotonParaMenu botonParaMapaMedio = new BotonParaMenu(ConstantesPantalla.empezarMapaMedio);
        botonParaMapaMedio.deshabilitarBoton();
        BotonParaMenu botonParaMapaGrande = new BotonParaMenu(ConstantesPantalla.empezarMapaGrande);
        botonParaMapaGrande.deshabilitarBoton();


        BotonParaMenu botonRetroceso = new BotonParaMenu(ConstantesPantalla.retroceder);
        //new CambiarDeMenu(botonRetroceso,this.getChildren(), menuJuego, menuPrincipal);//para simplificar codigo arreglar el bug
        botonRetroceso.setOnMouseClicked(evento -> {
            this.getChildren().remove(menuJuego);
            this.getChildren().add(menuPrincipal);
        });

        opciones.getChildren().addAll(botonParaMapaPequenio,botonParaMapaMedio,botonParaMapaGrande,botonRetroceso);
        //agregar al menu
        menuJuego = new javafx.scene.layout.BorderPane(null, titulo, null, null, opciones);
        menuJuego.setAlignment(titulo,Pos.TOP_CENTER);
        menuJuego.setMargin(opciones, new Insets(12,12,12,20));
    }

    private void crearOpcionesGraficas(){
        //top
        Text titulo = Textos.tituloNuevo(ConstantesPantalla.opcionesGraficas, ConstantesPantalla.tamanioFuenteTituloMenuPrincipal, Color.LIGHTBLUE, Color.GREEN,2);
        //left
        VBox opciones = new VBox();
        BotonParaMenu botonParaPantallaCompleta = new BotonParaMenu(ConstantesPantalla.pantallaCompleta);
        //botonParaPantallaCompleta.deshabilitarBoton();
        new PantallaCompleta(botonParaPantallaCompleta, stage);


        BotonParaMenu botonRetroceso = new BotonParaMenu(ConstantesPantalla.retroceder);
        //new CambiarDeMenu(botonRetroceso,this.getChildren(), menuJuego, menuPrincipal);//para simplificar codigo arreglar el bug
        botonRetroceso.setOnMouseClicked(evento -> {
            this.getChildren().remove(menuOpcionesGraficas);
            this.getChildren().add(menuPrincipal);
        });

        opciones.getChildren().addAll(botonParaPantallaCompleta,botonRetroceso);
        //agregar al menu
        menuOpcionesGraficas = new javafx.scene.layout.BorderPane(null, titulo, null, null, opciones);
        menuOpcionesGraficas.setAlignment(titulo,Pos.TOP_CENTER);
        menuOpcionesGraficas.setMargin(opciones, new Insets(12,12,12,20));
    }

    private void iniciarMapaPequenio(){
        PedirNombre pedirNombre = new PedirNombre();
        pedirNombre.obtenerNombreDeJugador();
        while (!pedirNombre.completo()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String nombreJugadorUno = pedirNombre.jugadorUno;
        String nombreJugadorDos = pedirNombre.jugadorDos;
        //hay un bug no toma los nombres
        IniciarJuego juego = new IniciarJuego(ConstantesPantalla.tamanioMapaPequenio,ConstantesPantalla.tamanioMapaPequenio,nombreJugadorUno,nombreJugadorDos);
        Partida partida = new Partida(stage,juego);
        tableroDeJuego = partida.crearPartida();
        this.getChildren().remove(menuJuego);
        this.getChildren().add(tableroDeJuego);

        partida.anterior.setOnMouseClicked(evento -> {
            this.getChildren().remove(tableroDeJuego);
            this.getChildren().add(menuJuego);
        });
    }

   /* private IniciarJuego crearInicioDePartida(int tamanio){
        return new IniciarJuego(tamanio, tamanio,);
    }*/

}
