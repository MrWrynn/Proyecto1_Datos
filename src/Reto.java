import java.util.Random;
import java.lang.NumberFormatException;
import javax.swing.*;
import java.awt.Color;


public class Reto{
    Random generador=new Random();
    int x;
    int y;
    int tipo;
    float respuesta;
    float operacion;

    public boolean reto() {

        x=generador.nextInt(50)+1;
        y=generador.nextInt(50)+1;
        tipo=generador.nextInt(4);
        try{ switch (tipo){
            case 0: respuesta=Integer.parseInt(JOptionPane.showInputDialog(null, "cuanto es la resultado de: "+x+"+"+y));
                    operacion=x+y;
            break;
            case 1: respuesta=Integer.parseInt(JOptionPane.showInputDialog(null, "cuanto es el resultado de: "+x+"-"+y));
                    operacion=x-y;
            break;
            case 2: respuesta=Integer.parseInt(JOptionPane.showInputDialog(null, "cuanto es el resultado de: "+x+"x"+y));
                    operacion=x*y;
            break;
            case 3: respuesta=Integer.parseInt(JOptionPane.showInputDialog(null, "cuanto es el resultado de: "+x+"/"+y));
            operacion=x/y;
        }}catch(NumberFormatException ex){return false;}
        int operacionE=(int)operacion;
        return operacionE==respuesta;
    }



    
}