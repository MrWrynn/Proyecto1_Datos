
package Server;

import Utils.*;

import javax.swing.*;  //importar interfaz grafica
import java.io.IOException;
import java.awt.event.*;
import java.util.Random;
import java.lang.NullPointerException;


public class PantallaInicio {


    public static void main(String[] args) throws IOException {
        Communication server = new Communication(8888, 7777);
        ventanaInicio ventana1 = new ventanaInicio(server);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para que al cerrar la ventana no siga ejecutandose

    }

}

class ventanaInicio extends JFrame { //La clase hereda de JFrame para poder crear cuadros(ventanas)


    public ventanaInicio(Communication server) { //Constructor
        JButton dado = new JButton("Dado");
        int posicion =0;
        Random generador=new Random(); 
        System.out.println("PantalaInicio");
        setBounds(500, 200, 400, 300);
        setResizable(false); //evitar que la ventana se redimencione
        setTitle("Pantalla Inicio");

        Lamina1 lamina1 = new Lamina1();
        add(lamina1);
        setVisible(true); //muestra la ventana 
        String mensaje = server.RecibirMensaje();

        JOptionPane.showMessageDialog(lamina1, "Jugador: " + mensaje + " está conectado");


        //Abre el tablero cuando se conecta el jugador 2
        Ventana ventana = new Ventana();
        LinkedList lista = new LinkedList();
        creartablero tablero = new creartablero(ventana, lista);
        ventana.setTitle("Host");
        ventana.setVisible(true);
        ventana.add(dado);

        server.EnviarMensaje(lista.printList(), 7777);
        dado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{ 
                    int n=1;
                    int num=1;
                    Reto reto = new Reto();
                    int moverse=generador.nextInt(4)+1;
                    JOptionPane.showMessageDialog(null,"Avanza: "+moverse+" casillas");
                    lista.recorrerDado(moverse);
                    System.out.println(lista.runner.getData());
                    int runnerA = (int) lista.runner.getData();
                    int movimiento=generador.nextInt(3)+1;
                    while (n==1){
                        System.out.println("Mov: "+movimiento);
                        if (runnerA==1){
                            JOptionPane.showMessageDialog(null, "Has caído en una trampa, retrocedes "+movimiento+" casillas");
                        } else {
                            JOptionPane.showMessageDialog(null, "Has caído en un tunel, avanzas "+movimiento+" casillas");
                        }
                        while (runnerA==1 && num<=movimiento){
                            lista.runner=lista.runner.anterior;
                            num++;
                        } while (runnerA==2 && num<=movimiento){
                            lista.runner=lista.runner.siguiente;
                            num++;
                        }
                        if (runnerA==0){
                            //reto.reto();   //se debe enviar al otro jugador
                            lista.runner=lista.runner.siguiente;
                        }
                        n++;
                    }
                    System.out.println("*"+lista.runner.getData());
                }catch(java.lang.NullPointerException ex){JOptionPane.showMessageDialog(null, "Has ganado");}
            }
        });
}
}
class Lamina1 extends JPanel {

    JLabel datos = new JLabel("Esperando jugadores..."); // instancia para agregar una etiqueta de texto


    public Lamina1() { //constructor

        add(datos); // se añade el texto a la lamina


    }

}