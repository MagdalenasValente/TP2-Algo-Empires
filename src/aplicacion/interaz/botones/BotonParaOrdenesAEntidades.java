package interaz.botones;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BotonParaOrdenesAEntidades extends Boton {
    public BotonParaOrdenesAEntidades(String nombre, Color colorBase, Color colorMenor/*, Image imagen*/){

        //el texto del boton
        texto = new Text(nombre);
        texto.setFont(Font.font(20));
        texto.setFill(Color.BLACK);
        this.setAlignment(Pos.CENTER);
        ImageView icono = new ImageView();
       /* icono.setImage(imagen);
        icono.setFitWidth(30);
        icono.setPreserveRatio(true);
        icono.setSmooth(true);
        icono.setCache(true);*/
        //el fondo y forma del boton
        this.colorActualDelBoton = colorBase;
        this.colorSecundarioDelBoton = colorMenor;
        this.fondo = new Rectangle(40,40);
        this.fondo.setOpacity(0.75);
        this.fondo.setFill(colorActualDelBoton);
        this.getChildren().addAll(fondo,texto/*, icono*/);
        //efectos
        EfectosDeBotones.pasarElPunteroPorEnsima(this,0, null);
        DropShadow iluminacion = new DropShadow(20,colorBase);
        iluminacion.setInput(new Glow());
        EfectosDeBotones.presionarConElPuntero(this,iluminacion);

    }
}
