package interaz.botones;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Boton extends StackPane {
    public Text texto;//tube que ponerlo public para acceder en los efectos
    public Rectangle fondo;
    public Color colorActualDelBoton;
    public Color colorSecundarioDelBoton;
    private Color colorDesabilitado = Color.GRAY;

    public void deshabilitarBoton(){
        this.fondo.setFill(colorDesabilitado);
        this.setDisable(true);
    }
    public void habilitarBoton(){
        this.fondo.setFill(colorActualDelBoton);
        this.setDisable(false);
    }
}
