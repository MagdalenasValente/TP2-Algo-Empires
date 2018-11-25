package interaz;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Borderpane extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        // Create the Text Nodes
        Text centerText = new Text("Center");
        Text topText = new Text("Top");
        Text rightText = new Text("Right");
        Text bottomText = new Text("Bottom");
        Text leftText = new Text("Left");

        // Set the alignment of the Top Text to Center
        javafx.scene.layout.BorderPane.setAlignment(topText,Pos.TOP_CENTER);
        // Set the alignment of the Bottom Text to Center
        javafx.scene.layout.BorderPane.setAlignment(bottomText,Pos.BOTTOM_CENTER);
        // Set the alignment of the Left Text to Center
        javafx.scene.layout.BorderPane.setAlignment(leftText,Pos.CENTER_LEFT);
        // Set the alignment of the Right Text to Center
        javafx.scene.layout.BorderPane.setAlignment(rightText,Pos.CENTER_RIGHT);

        // Create a BorderPane with a Text node in each of the five regions
        javafx.scene.layout.BorderPane root = new javafx.scene.layout.BorderPane(centerText, topText, rightText, bottomText, leftText);
        // Set the Size of the VBox
        root.setPrefSize(800, 600);
        // Set the Style-properties of the BorderPane
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("A simple BorderPane Example");
        // Display the Stage
        stage.show();
    }
}

