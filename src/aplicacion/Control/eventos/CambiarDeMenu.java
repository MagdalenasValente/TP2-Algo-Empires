package Control.eventos;

import interaz.MenuPrincipal;
import interaz.botones.Boton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.List;

public class CambiarDeMenu {
    public CambiarDeMenu(Boton botonDeCambio, List menu, BorderPane actual, BorderPane proximo){
        botonDeCambio.setOnMouseClicked(evento -> {
            menu.remove(actual);
            menu.add(proximo);
        });
    }
}
