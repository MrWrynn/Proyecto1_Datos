import java.util.Random;
import javax.swing.*;
import java.awt.Color;

public class Casilla {
     Random generador=new Random();
     int moverse;

    public int getMoverse() {
        moverse=generador.nextInt(3)+1;
        return moverse;
    }

    public void crear(Ventana ventana) {
        JLabel casilla=new JLabel();
        casilla.setOpaque(true);
        casilla.setBackground(Color.GRAY);
        ventana.add(casilla);
       
    }
}
