package interaz;

import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ConstantesPantalla {

    private static final int tamanioTablero = 40;

    private static double heightPantalla = Screen.getPrimary().getVisualBounds().getHeight();
    private static double widthPantalla = Screen.getPrimary().getVisualBounds().getWidth();

    //Iamgenes de fondo
    public static final double anchoImagenFondo = widthPantalla;
    public static final double altoImagenFondo = heightPantalla;
    //Titulo del menu
    public static final double tamanioFuenteTituloMenuPrincipal = heightPantalla / 20.0;
    //string
    public static String empezarPartida = "PARTIDA NUEVA";
    public static String opcionesGraficas = "OPCIONES GRAFICAS";
    public static String salir = "SALIR DEL JUEGO";
    public static String preguntarSalir = "¿Esta seguro de salir del juego?";
    public static String confirmacionDeSalida = "Confirmar salir del juego";
    public static String tituloDelJuego = "ALGO EMPIRES";
    public static String empezarMapaPequenio = "INICIAR MAPA PEQUEÑO";
    public static String empezarMapaMedio = "INICIAR MAPA MEDIO";
    public static String empezarMapaGrande = "INICIAR MAPA GRANDE";
    public static String pantallaCompleta = "PANTANLLA COMPLETA";
    public static String retroceder = "ATRAS";

    public static String toolBarSalirPartida = "Salir de la partida";
    public static String toolBarSalirJuego = "Cerrar juego";

    //mapa
    public static int tamanioMapaPequenio = 40;
    public static int tamanioDeIcono1x1 = 10;
    //swap del stage
    public static void actualizarStage(Stage stage, Scene nuevaEscena){
        boolean pantallaCompleta = stage.isFullScreen();
        stage.setScene(nuevaEscena);
        stage.setFullScreen(pantallaCompleta);
    }
}
