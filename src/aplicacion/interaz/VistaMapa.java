package interaz;

import javafx.scene.image.Image;

import java.awt.*;

public class VistaMapa {



    public void vistaMapa(Point tamanio){

        int tamanioHorizontal = (int) tamanio.getX() * ConstantesPantalla.tamanioDeIcono1x1;
        int tamanioVertical = (int) tamanio.getY() * ConstantesPantalla.tamanioDeIcono1x1;
        javafx.scene.image.Image imagen = new Image("file:src/interfaz/imagenes/tablero.jpg");
        Rectangle mapaVisual = new Rectangle();

        mapaVisual.setSize(tamanioHorizontal,tamanioVertical);
        //BackgroundSize size = new BackgroundSize(tamanioHorizontal,tamanioVertical,false,false,true,true);
        //BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,size);

    }
}
