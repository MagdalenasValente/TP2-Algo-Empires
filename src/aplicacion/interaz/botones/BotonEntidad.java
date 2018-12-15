package interaz.botones;

import Control.InformacionDeControl;
import entidades.Entidad;
import interaz.ConstantesPantalla;
import interaz.InfoEntidad;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class BotonEntidad extends Boton {
    private Entidad entidad;
    private Point ubicacion;
    private int tamanioHorizontal;
    private int tamanioVertical;

    public BotonEntidad(Entidad entidad, Point ubicacion){
        this.entidad = entidad;
        //this.ubicacion = this.entidad.verPosicion();
        this.ubicacion = ubicacion;
        //Point tamanio = entidad.verTamanio();
        //this.tamanioHorizontal = (int) tamanio.getX();
        //this.tamanioVertical = (int) tamanio.getY();

        int anchoDelBoton = ConstantesPantalla.tamanioDeIcono1x1 -1/* * tamanioHorizontal*/;
        int largoDelBoton = ConstantesPantalla.tamanioDeIcono1x1 -1/* * tamanioVertical*/;
        this.fondo = new Rectangle(anchoDelBoton,largoDelBoton);

        ImageView icono;
        if(entidad != null) {
            icono = InfoEntidad.entidadSeleccionadaIcono(this.entidad);
        }else {
            icono = new ImageView("file:src/interfaz/imagenes/blanco.png");
        }

        icono.setFitHeight(anchoDelBoton);
        icono.setFitWidth(largoDelBoton);

        this.getChildren().addAll(icono);


        this.setOnMouseClicked(evento -> {
            if (this.entidad == null){
                InformacionDeControl.visorDeInformacion(this.ubicacion);
            }else {
                InformacionDeControl.visorDeInformacion(this.entidad);
            }
        });
    }
}
