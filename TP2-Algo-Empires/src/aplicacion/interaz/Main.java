package interaz;

import entidades.Entidad;
import entidades.unidades.Espadachin;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Text centerText = new Text("Center");
        Text topText = new Text("Aca Estaria El menu");
        Text rightText = new Text("Right");
        //Text bottomText = new Text("Bottom");
        Text leftText = new Text("Left");

        //test debe ser borrado
        Entidad espachin = new Espadachin();

        //Caja Inferior con informacion de la entidad
        InfoEntidad generadorDeInfo = new InfoEntidad();
        HBox cajaInferior = generadorDeInfo.generarInfo(espachin);

        javafx.scene.layout.BorderPane root = new javafx.scene.layout.BorderPane(centerText, topText, rightText, cajaInferior, leftText);
        root.setPrefSize(800, 600);//resolucion

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TP2 Algo Empires Grupo D1");
        primaryStage.show();
    }
}
