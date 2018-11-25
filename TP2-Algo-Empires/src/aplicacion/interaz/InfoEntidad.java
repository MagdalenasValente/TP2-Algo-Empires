package interaz;

import entidades.Entidad;
import entidades.edificios.Edificio;
import entidades.unidades.Unidad;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class InfoEntidad {

    private void entidadSeleccionada(Unidad unidad){
        String movimiento = "1";
        Text mov = new Text(movimiento);
    }

    private void entidadSeleccionada(Edificio edificio){

    }

    private VBox entidadSeleccionadaInformacion(Entidad entidad){
        //info general
        String nombreDeLaEntidad = "" + entidad.getNombre();
        String vidaActualDeLaEntidad = "vida actual: " + entidad.vida();

        //pasar a text
        Text nombre = new Text(nombreDeLaEntidad);
        Text vidaActual = new Text(vidaActualDeLaEntidad);

        //subrayado
        nombre.setUnderline(true);

        //color
        nombre.setFill(Color.BLUE);
        vidaActual.setFill(Color.GREEN);
        if (!entidad.fullVida()){
            vidaActual.setFill(Color.RED);
        }

        VBox infoDeEntidad = new VBox();
        //espacio entre cosas
        infoDeEntidad.setSpacing(5);

        //Margenes
        infoDeEntidad.setMargin(nombre, new Insets(1, 10, 1, 10));
        infoDeEntidad.setMargin(vidaActual, new Insets(1, 10, 1, 10));

        //agregar a la caja
        ObservableList list = infoDeEntidad.getChildren();
        list.addAll(nombre,vidaActual);

        return infoDeEntidad;
    }

    private ImageView entidadSeleccionadaIcono (Entidad entidad) throws FileNotFoundException {
        String nombre = entidad.getNombre();
        String url = "*/imagenes/" + nombre;

        Image icono = new Image(url);

        ImageView imageView = new ImageView(icono);

        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        return imageView;
    }

    public HBox generarInfo(Entidad entidad){
        //caja horizontal
        HBox infoDeEntidad = new HBox();

        //espacios entre cosas
        infoDeEntidad.setSpacing(10);

        //icono de la entidad
        //ImageView icono = entidadSeleccionadaIcono(entidad);
        //info de la entidad
        VBox info = entidadSeleccionadaInformacion(entidad);

        infoDeEntidad.setMargin(info, new Insets(10, 10, 10, 10));

        //agrego las cosas a la caja horizontalñ
        ObservableList list = infoDeEntidad.getChildren();
        list.addAll(info);
        return infoDeEntidad;

    }

    public void InfoEntidad(){

    }
}
