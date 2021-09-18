
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Jugador extends JFrame{
    public static void main 

    public static void main(String[] args) {
        ventanaJugador ventana = new ventanaJugador();
        ventana.setDefaultCloseOperations(JFrame.EXIT_ON_CLOSE); //al cerrar la ventana no siga ejecutandose el programa

        Jugador ventana = new Jugador();


        //Host del servidor
        String HOST = "Localhost";
        //PORT del servidor
        int PORT = 5000;
        DataInputStream input;
        DataOutputStream output;

        try {
            //Se crea el socket para conectarse con el Servidor 
            Socket socket = new Socket(HOST, PORT);

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            //Enviar un mensaje al servidor
            Scanner keyboard = new Scanner(System.in);
            String MensajeParaServidor = keyboard.nextLine();
            output.writeUTF(MensajeParaServidor);

            //Recibir el mensaje del servidor
            String mensaje = input.readUTF();

            System.out.println(mensaje);

            socket.close();
            keyboard.close();

        } catch (IOException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

    

