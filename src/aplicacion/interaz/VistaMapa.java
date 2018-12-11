package interaz;

import interaz.botones.Boton;
import interaz.botones.BotonEntidad;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import mapa.Mapa;

import java.awt.*;

public class VistaMapa {
    private GridPane vistaDelMapa;
    private Mapa mapa;



    public VistaMapa(Point tamanio, Mapa mapa){
        this.mapa = mapa;

        int tamanioHorizontal = (int) tamanio.getX();
        int tamanioVertical = (int) tamanio.getY();
        //javafx.scene.image.Image imagen = new Image("file:src/interfaz/imagenes/tablero.jpg");
        //ConstantesPantalla.tamanioDeIcono1x1;

        vistaDelMapa = new GridPane();
        vistaDelMapa.setVgap(0);
        vistaDelMapa.setHgap(0);

        for (int i = 0; i < tamanioHorizontal; i++){
            for (int j = 0; j < tamanioHorizontal; j++){
                this.actulizarCelda(i,j);
            }
        }
    }

    public void actulizarCelda(int ubicacionHorizontal, int ubicacionVertical){
        Point ubicacion = new Point(ubicacionHorizontal,ubicacionVertical);
        if (mapa.estaOcupado(ubicacion)) {
            Boton boton = new BotonEntidad(mapa.entidadQueOcupaLaPoscicion(ubicacion),ubicacion);
            vistaDelMapa.add(boton, ubicacionHorizontal, ubicacionVertical);
        }else{
            Boton boton = new BotonEntidad(null,ubicacion);
            vistaDelMapa.add(boton, ubicacionHorizontal, ubicacionVertical);
        }
    }

    public GridPane obtenerGrilla(){
        return vistaDelMapa;
    }
}
