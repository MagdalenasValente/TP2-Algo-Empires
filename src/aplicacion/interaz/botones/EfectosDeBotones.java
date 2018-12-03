package interaz.botones;

import javafx.scene.effect.Effect;
import javafx.scene.paint.Color;

public class EfectosDeBotones {
    public static void pasarElPunteroPorEnsima(Boton boton, int movimiento, Effect auxiliar){

        Color colorPrimarioDelBoton = boton.colorActualDelBoton;
        Color colorSecundarioDelBoton = boton.colorSecundarioDelBoton;

        boton.setOnMouseEntered(evento -> {
            //cambio de posicion
            boton.fondo.setTranslateX(movimiento);
            boton.texto.setTranslateX(movimiento);
            //cambio de color
            boton.fondo.setFill(colorSecundarioDelBoton);
            boton.texto.setFill(colorPrimarioDelBoton);
            //auxiliar
            boton.setEffect(auxiliar);
        });

        boton.setOnMouseExited(event ->{
            boton.fondo.setTranslateX(0);
            boton.texto.setTranslateX(0);
            boton.fondo.setFill(colorPrimarioDelBoton);
            boton.texto.setFill(colorSecundarioDelBoton);
        });
    }

    public static void presionarConElPuntero(Boton boton, Effect efecto){
        boton.setOnMousePressed(evento -> boton.setEffect(efecto));
        boton.setOnMouseReleased(evento -> boton.setEffect(null));
    }
}
