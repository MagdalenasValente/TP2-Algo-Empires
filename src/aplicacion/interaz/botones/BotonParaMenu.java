package interaz.botones;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BotonParaMenu extends Boton {

    public BotonParaMenu(String nombre){
        //el texto del boton
        texto = new Text(nombre);
        texto.setFont(Font.font(20));
        texto.setFill(Color.WHITE);
        texto.setStroke(Color.BLACK);
        texto.setStrokeWidth(1);
        //el fondo y forma del boton
        this.colorActualDelBoton = Color.ORANGE;
        this.colorSecundarioDelBoton = Color.GRAY;
        this.fondo = new Rectangle(200,24);
        this.fondo.setOpacity(0.5);
        this.fondo.setFill(colorActualDelBoton);
        //agregar el texto al fondo
        this.setAlignment(Pos.CENTER);
        this.setRotate(-0.5);
        this.getChildren().addAll(fondo,texto);
        //efectos
        EfectosDeBotones.pasarElPunteroPorEnsima(this,5, null);
        DropShadow iluminacion = new DropShadow(50,Color.WHITE);
        iluminacion.setInput(new Glow());
        EfectosDeBotones.presionarConElPuntero(this,iluminacion);

    }
}
