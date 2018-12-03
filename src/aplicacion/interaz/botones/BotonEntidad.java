package interaz.botones;

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

    public BotonEntidad(Entidad entidad){
        this.entidad = entidad;
        this.ubicacion = this.entidad.verPosicion();
        Point tamanio = entidad.verTamanio();
        this.tamanioHorizontal = (int) tamanio.getX();
        this.tamanioVertical = (int) tamanio.getY();

        int anchoDelBoton = ConstantesPantalla.tamanioDeIcono1x1 * tamanioHorizontal;
        int largoDelBoton = ConstantesPantalla.tamanioDeIcono1x1 * tamanioVertical;
        this.fondo = new Rectangle(anchoDelBoton,largoDelBoton);

        ImageView icono = InfoEntidad.entidadSeleccionadaIcono(this.entidad);

        icono.setFitHeight(anchoDelBoton);
        icono.setFitWidth(largoDelBoton);

        this.getChildren().addAll(icono);


        this.setOnMouseClicked(evento -> {
            //aca iria el actualizar
        });
    }
}
