package interaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedirNombre implements ActionListener {
    private JTextField jugador1;
    private JTextField jugador2;
    private JButton botonOk;
    private JFrame ventana;
    public String jugadorUno;
    public String jugadorDos;
    private boolean completo;

    public PedirNombre(){}

    public void obtenerNombreDeJugador(){
        ventana = new JFrame("Introdusca nombre de jugadores");

        jugador1 = new JTextField("jugador uno");
        jugador1.setBounds(50,50, 200,30);
        ventana.add(jugador1);

        jugador2 = new JTextField("jugador dos");
        jugador2.setBounds(50,100, 200,30);
        ventana.add(jugador2);

        ventana.setSize(300,300);
        ventana.setLayout(null);
        ventana.setVisible(true);

        botonOk = new JButton("Ok");
        botonOk.setBounds(50,200,50,50);
        botonOk.addActionListener(this);
        ventana.add(botonOk);

        completo = false;
    }

    public boolean completo(){
        return completo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String jugadorUno = jugador1.getText();
        String jugadorDos = jugador2.getText();
        if(e.getSource() == botonOk){
            this.jugadorUno = jugadorUno;
            this.jugadorDos = jugadorDos;
            ventana.dispose();
            completo = true;
        }
        }
}
