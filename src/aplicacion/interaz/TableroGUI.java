package interaz;

import Control.InformacionDeControl;
import entidades.Entidad;
import javafx.scene.effect.Effect;
import mapa.Mapa;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;

public class TableroGUI extends javax.swing.JPanel {
    public ImageIcon fondo;
    private boolean tipoTablero;
    private CasillasGUI [][] casillas ;
    private int tamanioDeCasilleros = ConstantesPantalla.tamanioDeIcono1x1;
    private int tamanioTablero;
    private Partida partida;
    public Mapa mapa;

    public TableroGUI() {
        initComponents();
    }
    public TableroGUI(int tamanio, boolean tipo, Partida partida, Mapa mapa) {
        this.partida = partida;
        this.mapa = mapa;
        this.tamanioTablero = tamanio;
        initComponents();
        int x,y;
        setLayout(new java.awt.GridLayout(tamanio, tamanio));
        this.tipoTablero = tipo;
        cargarImagenes();
        casillas = new CasillasGUI[tamanio][tamanio];
        for (int i = 0; i < tamanio; i++){
            for (int j = 0; j < tamanio; j++){
                casillas[i][j] = new CasillasGUI(this);
                casillas[i][j].setFondo(fondo);
                x = (i * tamanioDeCasilleros)+1;
                y = (j * tamanioDeCasilleros)+1;
                casillas[i][j].setBounds(x, y, (tamanioDeCasilleros)-1, (tamanioDeCasilleros)-1);
                this.add(casillas[i][j]);
                this.actulizarCelda(i,j,casillas[i][j]);
            }
        }
    }

    public boolean getTipoTablero(){
        return this.isTipoTablero();
    }

    public void pintar(int x, int y, ImageIcon enteSobreTerreno){
        this.casillas[x][y].setFondo(enteSobreTerreno);
        this.repaint();
    }

    public void colocar(int x, int y, Entidad entidad){
        this.casillas[x][y].setEntidad(entidad);
        String url = InformacionDeControl.darUbicacionDeIconoDeEntidad(entidad);
        ImageIcon icono = new ImageIcon(url);
        this.casillas[x][y].setFondo(icono);
        this.repaint();
    }

    private void cargarImagenes() {
        String url = "imagenes/vacio.png";
        this.fondo =  this.cargarFondo(url);
    }

    public static ImageIcon cargarFondo(String ruta) {
        java.net.URL localizacion = TableroGUI.class.getResource(ruta);
        if (localizacion != null) {
            return new ImageIcon(localizacion);
        } else {
            System.err.println("No se ha encontrado el archivo: " + ruta);
            return null;
        }
    }

    public int[] getCoordenadas(CasillasGUI casilla) {
        int [] coordenadas = new int[2];
        for (int i=0; i < this.casillas.length; i++) {
            for (int j=0; j < this.casillas.length; j++) {
                if (this.casillas[i][j] == casilla) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }

    public CasillasGUI[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(CasillasGUI[][] casillas) {
        this.casillas = casillas;
    }

    public boolean isTipoTablero() {
        return tipoTablero;
    }
    public void setTipoTablero(boolean tipoTablero) {
        this.tipoTablero = tipoTablero;
    }

    private void initComponents() {
        setLayout(null);
        setBackground(new java.awt.Color(2, 2, 2));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        setPreferredSize(new java.awt.Dimension((this.tamanioDeCasilleros * this.tamanioTablero) + 1, (this.tamanioDeCasilleros * this.tamanioTablero) + 1));
    }

    public void actulizarCelda(int ubicacionHorizontal, int ubicacionVertical, CasillasGUI casilla){
        Point ubicacion = new Point(ubicacionHorizontal,ubicacionVertical);
        if (mapa.estaOcupado(ubicacion)){
            casilla.setEntidad(mapa.entidadQueOcupaLaPoscicion(ubicacion));
        }
    }

    public void seleccionarEnte(Entidad entidad){
        partida.actulizarInfoEntidad(entidad);
    }
}
