import javax.swing.*;
import java.awt.Color;

public class Trampa extends Casilla {
    public void crear (Ventana ventana){
        JLabel casilla=new JLabel("TRAMPA",SwingConstants.CENTER);
        casilla.setOpaque(true);
        casilla.setBackground(Color.RED);
        ventana.add(casilla);
    }

}
