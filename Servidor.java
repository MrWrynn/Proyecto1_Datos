package Proyecto1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {
    public static void main(String[] args) {
        ventanaServidor ventana2 = new ventanaServidor();
        ventana2.setVisible(true);
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // para que al cerrar la ventana no siga ejecutandose el programa
        
        ServerSocket servidor = null;
        Socket socket = null;
        DataInputStream input;
        DataOutputStream output;
        
        //PORT del servidor
        int PORT = 8888;

        try{
            //Se crea el socket del servidor
            servidor = new ServerSocket(PORT);
            System.out.println("Jugador 1 listo");

            //Siempre estara esperando solicitudes
            while(true){
                //Espera a que un jugador se una
                System.out.println("Esperando jugadores...");
                socket = servidor.accept(); //acepta un segundo jugador
                System.out.println("Jugador 2 ingreso a la partida");
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
                
                //Leo el mensaje que me envia
                String mensaje = input.readUTF();

                System.out.println(mensaje);

                //Le envio un mensaje
                Scanner keyboard = new Scanner(System.in);
                String MensajeParaCliente = keyboard.nextLine();
                output.writeUTF(MensajeParaCliente);

                //Cierro el socket
                socket.close();
                keyboard.close();
                System.out.println("Jugador 2 abandono la partida");
                

            }
        }catch(IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

class ventanaServidor extends JFrame implements Runnable{ //hereda de JFrame para crear la ventana
    public ventanaServidor () {  //Constructor
        setBounds(500,200,400,300); //define ubicacion en x, y , ancho, alto del cuadro
        JPanel lamina2 = new JPanel ();
        lamina2.setLayout(new BorderLayout());
        setResizable(false); //evitar que la ventana se redimencione
        setTitle("Servidor");
        setVisible(true); //mostrar en pantalla
     
 
    }
}    
        

class Lamina2 extends JPanel implements Runnable{

    public Lamina2(){ //constructor
        JLabel notificacion = new JLabel("Jugador 1 conectado"); // instancia para agregar una etiqueta de texto
        add(notificacion); // se añade el texto a la lamina
        
        
    }

}
