
import javax.swing.*;  //importar interfaz grafica 
import java.awt.*;
import java.awt.event.*;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*; 


public class Jugador{
    public static void main (String [] args){
        ventanaJugador ventana1 = new ventanaJugador();
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para que al cerrar la ventana no siga ejecutandose


        //Host del servidor
        String HOST ="Localhost";

        //Port del servidor
        int PORT = 8888;
        DataInputStream input;
        DataOutputStream output;

        try{
            //Se crea el socket para conectarse con el servidor
            Socket socket = new Socket(HOST, PORT);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            //Envio un mensaje al servidor
            Scanner keyboard = new Scanner(System.in);
            String MensajeParaServidor = keyboard.nextLine();
            output.writeUTF(MensajeParaServidor);

            //Recibo el mensaje del servidor
            String mensaje = input.readUTF();

            System.out.println(mensaje);

            socket.close();
            keyboard.close();

        }catch (IOException ex){
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class ventanaJugador extends JFrame{ //La clase hereda de JFrame para poder crear cuadros(ventanas)
    public ventanaJugador() { //Constructor
        setBounds(500, 200, 400, 300);
        setResizable(false); //evitar que la ventana se redimencione
        setTitle("Jugador");
        Lamina lamina1 = new Lamina();
        add(lamina1);
        setVisible(true); //muestra la ventana 
    }
}

class Lamina extends JPanel implements Runnable{

    public Lamina(){ //constructor
        
        
    }

}
    
    

