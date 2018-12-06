package interaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;


public class JuegoInicio extends Application {

    private MenuPrincipal menuPrincipal;
    private Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception {

        this.stage = primaryStage;


        stage.setFullScreen(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setMinWidth(1200);
        stage.setMinHeight(910);
        primaryStage.setTitle("TP2 Algo Empires Grupo D1");


        this.menuPrincipal = new MenuPrincipal(stage);
        Scene scene = new Scene(menuPrincipal);
            stage.setScene(scene);
        stage.show();
    }

}
