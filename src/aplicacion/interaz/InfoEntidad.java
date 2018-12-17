package interaz;

import Control.InformacionDeControl;
import entidades.Entidad;
import entidades.unidades.Unidad;
import interaz.botones.Boton;
import interaz.botones.BotonParaOrdenesAEntidades;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InfoEntidad {

    private HBox infoDeEntidad;
    private int tamanioLetra = 16;

    public InfoEntidad(){}


    private VBox entidadSeleccionadaInformacionGeneral(Entidad entidad){
        Text nombre,vidaActual;
        if (entidad != null) {
            //info general
            String nombreDeLaEntidad = "" + entidad.getNombre();
            String vidaActualDeLaEntidad = "vida actual: " + entidad.vida();
            String danioAUnidades = "danio " + entidad.vida();

            //pasar a text
            nombre = new Text(nombreDeLaEntidad);
            vidaActual = new Text(vidaActualDeLaEntidad);

            //subrayado
            nombre.setUnderline(true);

            //color
            vidaActual.setFill(Color.GREEN);
            if (!entidad.fullVida()) {
                vidaActual.setFill(Color.RED);
            }
        }else {
            String nombreDeLaEntidad = "";
            String vidaActualDeLaEntidad = "vida actual: -";
            nombre = new Text(nombreDeLaEntidad);
            vidaActual = new Text(vidaActualDeLaEntidad);
            vidaActual.setFill(Color.GREEN);
        }
        nombre.setFont(Font.font(tamanioLetra));
        vidaActual.setFont(Font.font(tamanioLetra));
        nombre.setFill(Color.BLUE);

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

    private VBox entidadSeleccionadaInformacionAtaque(Entidad entidad){
        Text vsUnidad,vsEdificio,rango;
        String danio = "daño";
        Text danios = new Text(danio);
        if (entidad != null) {
            //info general
            String rangoDeAtaque = "rango: " + entidad.getRango();
            String danioAEdificios = "vs edificio: " + entidad.getDanioAEdificios();
            String danioAUnidades = "vs unidad: " + entidad.getDanioAUnidades();

            //pasar a text
            rango = new Text(rangoDeAtaque);
            vsEdificio = new Text(danioAEdificios);
            vsUnidad = new Text(danioAUnidades);

        }else{
            String rangoDeAtaque = "rango: -";
            String danioAEdificios = "vs edificio: -";
            String danioAUnidades = "vs unidad: -";

            //pasar a text
            rango = new Text(rangoDeAtaque);
            vsEdificio = new Text(danioAEdificios);
            vsUnidad = new Text(danioAUnidades);
        }
        vsEdificio.setFont(Font.font(tamanioLetra));
        vsUnidad.setFont(Font.font(tamanioLetra));
        rango.setFont(Font.font(tamanioLetra));
        danios.setFont(Font.font(tamanioLetra));
        rango.setFill(Color.RED);
        vsEdificio.setFill(Color.RED);
        vsUnidad.setFill(Color.RED);
        danios.setFill(Color.RED);

        VBox infoDeEntidad = new VBox();
        //espacio entre cosas
        infoDeEntidad.setSpacing(5);

        //Margenes
        infoDeEntidad.setMargin(rango, new Insets(1, 10, 1, 10));
        infoDeEntidad.setMargin(vsUnidad, new Insets(1, 10, 1, 10));
        infoDeEntidad.setMargin(vsEdificio, new Insets(1, 10, 1, 10));

        //agregar a la caja
        ObservableList list = infoDeEntidad.getChildren();
        list.addAll(danios,vsUnidad,vsEdificio,rango);

        return infoDeEntidad;
    }

    public static ImageView entidadSeleccionadaIcono (Entidad entidad){
        String url;
        if (entidad == null) {
            //url = "file:src/interaz/imagenes/vacio.png";
            url = InformacionDeControl.darUbicacionDeIconoDeEntidadParaFx("vacio.png");
        }else {
            //String nombre = entidad.getNombre();
            //url = "file:src/interaz/imagenes/" + nombre + ".png";
            url = InformacionDeControl.darUbicacionDeIconoDeEntidadParaFx(entidad);
        }

        Image icono = new Image(url);

        ImageView imageView = new ImageView(icono);

        double tamanioDeImagen = 70;
        imageView.setFitHeight(tamanioDeImagen);
        imageView.setFitWidth(tamanioDeImagen);

        return imageView;
    }

    public HBox generarInfo(Entidad entidad){
        //caja horizontal
        HBox infoDeEntidad = new HBox();
        this.acctualizarInfo(entidad,infoDeEntidad);
        this.infoDeEntidad = infoDeEntidad;
        return infoDeEntidad;

    }

    public void acctualizarInfo(Entidad entidad, HBox infoDeEntidad){

        infoDeEntidad.getChildren().clear();
        //espacios entre cosas
        infoDeEntidad.setSpacing(10);

        //icono de la entidad
        ImageView icono = this.entidadSeleccionadaIcono(entidad);
        //info de la entidad
        VBox infoGeneral = entidadSeleccionadaInformacionGeneral(entidad);
        VBox infoAtaque = entidadSeleccionadaInformacionAtaque(entidad);

        infoDeEntidad.setMargin(infoGeneral, new Insets(10, 10, 10, 10));
        infoDeEntidad.setMargin(infoAtaque, new Insets(10, 10, 10, 10));

        //botones
        /*Boton ataque = new BotonParaOrdenesAEntidades("ATQ",Color.RED,Color.PINK);
        ataque.deshabilitarBoton();
        Boton movimiento = new BotonParaOrdenesAEntidades("MOV",Color.BLUE,Color.LIGHTBLUE);
        movimiento.deshabilitarBoton();
        Boton montar = new BotonParaOrdenesAEntidades("MON",Color.RED,Color.PINK);
        montar.deshabilitarBoton();
        Boton construir = new BotonParaOrdenesAEntidades("CON",Color.GREEN,Color.LIGHTGREEN);
        construir.deshabilitarBoton();*/
/*se debe rehacer de alguna forma sin getclass
        if (entidad != null) {
            ataque.habilitarBoton();
            construir.habilitarBoton();
            if (entidad.getClass().isInstance(Unidad) ) {
                montar.habilitarBoton();
                movimiento.habilitarBoton();
            }
        }
*/
        //agrego las cosas a la caja horizontal
        infoDeEntidad.getChildren().addAll(icono,infoGeneral,infoAtaque/*,ataque,movimiento,montar,construir*/);

        this.infoDeEntidad = infoDeEntidad;
    }
    public void agregarBotonera(GridPane botonera){
        //this.acctualizarInfo(entidad, infoDeEntidad);
        this.infoDeEntidad.getChildren().addAll(botonera);
    }

}
