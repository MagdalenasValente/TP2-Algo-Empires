package interaz;

import Control.InformacionDeControl;
import entidades.Entidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;

public class CasillasGUI extends javax.swing.JPanel implements MouseListener {

    private TableroGUI tablero;
    private ImageIcon fondo;
    private static int [] casillaMarcada = new int[2];
    private Entidad entidad;

    public CasillasGUI() {
        // este constructor no se usará, se deja para poder crear el bean.
    }

    public CasillasGUI(TableroGUI t) {
        initComponents();
        this.entidad = null;
        this.tablero = t;
        if(this.tablero.getTipoTablero() == true){// tablero responde a clics?
            this.addMouseListener(this);
        }
    }

    public void setFondo(ImageIcon fondo){
        this.fondo = fondo;
    }

    public ImageIcon getFondo(){
        return this.fondo;
    }


    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 161, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 193, Short.MAX_VALUE)
        );
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0,0,this.getWidth(),this.getHeight(),this);
    }

    public void mouseClicked(MouseEvent e){
        //Point ubicacion = e.getPoint();
        java.awt.Point ubicacion = e.getPoint();
        Entidad ente;
        if (tablero.mapa.estaOcupado(ubicacion)) {
            ente = tablero.mapa.entidadQueOcupaLaPoscicion(ubicacion);
        }else {ente = null;}
        tablero.seleccionarEnte(ente);
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
        java.awt.Point ubicacion = e.getPoint();
        Entidad ente;
        if (tablero.mapa.estaOcupado(ubicacion)) {
            ente = tablero.mapa.entidadQueOcupaLaPoscicion(ubicacion);
        }else {ente = null;}
        tablero.seleccionarEnte(ente);
    }
    public void mouseReleased(MouseEvent e){}

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
        ImageIcon icono;
        if (entidad != null) {
            icono = tablero.cargarFondo(InformacionDeControl.darUbicacionDeIconoDeEntidad(entidad));
            //icono = new ImageIcon("imagenes/" + entidad.getNombre() + ".png");
        }else {
            icono = tablero.fondo;
        }
        this.setFondo(icono);
    }

    public static int[] getCasillaMarcada() {
        return casillaMarcada;
    }
    public static void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }
}
