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
            try{ 
                int n=1;
                int num=1;
                Reto reto = new Reto();
                moverse=generador.nextInt(4)+1;
                JOptionPane.showMessageDialog(null,"Avanza: "+moverse+" casillas");
                tablero.recorrerDado(moverse);
                System.out.println(tablero.runner.getData());
                int runnerA = (int) tablero.runner.getData();
                int movimiento=generador.nextInt(3)+1;
                while (n==1){
                    System.out.println("Mov: "+movimiento);
                    if (runnerA==1){
                        JOptionPane.showMessageDialog(null, "Has caído en una trampa, retrocedes "+movimiento+" casillas");
                    } else {
                        JOptionPane.showMessageDialog(null, "Has caído en un tunel, avanzas "+movimiento+" casillas");
                    }
                    while (runnerA==1 && num<=movimiento){
                        tablero.runner=tablero.runner.anterior;
                        num++;
                    } while (runnerA==2 && num<=movimiento){
                        tablero.runner=tablero.runner.siguiente;
                        num++;
                    }
                    if (runnerA==0){
                        //reto.reto();   //se debe enviar al otro jugador
                        tablero.runner=tablero.runner.siguiente;
                    }
                    n++;
                }
                System.out.println("*"+tablero.runner.getData());
            }catch(java.lang.NullPointerException ex){JOptionPane.showMessageDialog(null, "Has ganado");}
        }
            
        };

        dado.addActionListener(oyente);
    }
}   
