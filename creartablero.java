package Proyecto1;
import java.util.Random;
import javax.swing.JButton;
import java.awt.Color;

public class creartablero {
    Random generador=new Random();
    Reto cr=new Reto();
    Trampa tp=new Trampa();
    Tunel tn=new Tunel();
    Casilla inicio=new Casilla();
    JButton botones[]=new JButton[16];
    int i=1;
    int r=1;
    int tr=1;
    int tu=1;

    public creartablero(Ventana ventana,LinkedList tablero){
        tablero.insertNode(3);
        botones[0]=new JButton("INICIO");
        botones[0].setBackground(Color.GRAY);
        botones[0].setEnabled(false);
        ventana.add(botones[0]);
        while (i <=14){
            int opcion=generador.nextInt(3);
            if ((opcion==0) && (r<=7)){
                tablero.insertNode(0);
                botones[i]=new JButton();
                botones[i].setBackground(Color.blue);
                botones[i].setEnabled(false);
                ventana.add(botones[i]);
                i++;
                r++;
            }
            else if ((opcion==1) && (tr<=3)){
                tablero.insertNode(1);
                botones[i]=new JButton();
                botones[i].setBackground(Color.red);
                botones[i].setEnabled(false);
                ventana.add(botones[i]);
                i++;
                tr++;
            }
            else if ((opcion==2) && (tu<=4)){
                tablero.insertNode(2);
                botones[i]=new JButton();
                botones[i].setBackground(Color.green);
                botones[i].setEnabled(false);
                ventana.add(botones[i]);
                i++;
                tu++;}}
        botones[15]=new JButton();
        botones[15].setBackground(Color.GRAY);
        botones[15].setEnabled(false);
        ventana.add(botones[15]);
        tablero.insertNode(3);
    }
    

}
