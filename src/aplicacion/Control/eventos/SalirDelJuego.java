package Control.eventos;

import interaz.ConstantesPantalla;
import interaz.botones.Boton;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class SalirDelJuego {
    public SalirDelJuego(Boton botonParaMenuSalir, Stage stage){
        botonParaMenuSalir.setOnMouseClicked(evento -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(ConstantesPantalla.salir);
            alert.setHeaderText(ConstantesPantalla.confirmacionDeSalida);
            alert.setContentText(ConstantesPantalla.preguntarSalir);
            alert.initOwner(stage);
            alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            System.exit(0);
        }
        });
    }
}
