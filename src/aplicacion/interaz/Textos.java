package interaz;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Textos {
    public static Text tituloNuevo(String texto, double tamDeLetra, Color colorDeLetra, Color colorDeBorde, int espesorDeBorde){
        Text titulo = new Text(texto);
        titulo.setFont(new Font("TimesRoman", tamDeLetra));
        titulo.setFill(colorDeLetra);
        titulo.setStroke(colorDeBorde);
        titulo.setStrokeWidth(espesorDeBorde);
        return titulo;
    }
}
