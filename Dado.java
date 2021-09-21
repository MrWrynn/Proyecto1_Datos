package Proyecto1;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Dado {
    JButton dado=new JButton("DADO");
    Random generador=new Random();
    int moverse;


    public Dado(Ventana ventana, LinkedList tablero){
        ventana.add(dado);
        

        ActionListener oyente=new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e) { //0 es reto, 1 es trampa y 2 es tunel
            int i=1;
            int n=1;
            int num=1;
            moverse=generador.nextInt(4)+1;
            JOptionPane.showMessageDialog(null,"Avanza: "+moverse+" casillas");
            tablero.recorrerDado(moverse);
            System.out.println(tablero.runner.getData());
            int runnerA = (int) tablero.runner.getData();
            int movimiento=generador.nextInt(3)+1;
            while (n==1){
                System.out.println("Mov: "+movimiento);
                if (runnerA==1 && num<=movimiento){
                    tablero.runner=tablero.runner.anterior;
                    System.out.println("retrocede");
                    num++;
                } else if(runnerA==2 && num<=movimiento){
                    tablero.runner=tablero.runner.siguiente;
                    System.out.println("avanza");
                    num++;
                }
                n++;
            }
            System.out.println(tablero.runner.getData());
            //tablero.runner=tablero.runner.anterior;
            System.out.println("*"+tablero.runner.getData());
        }
            
        };

        dado.addActionListener(oyente);
    }
}   
