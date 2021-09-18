import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket socket = null;
        DataInputStream input;
        DataOutputStream output;

        //PORT del servidor
        int PORT = 5000;

        try {
            //Se crea el socket del servidor
            servidor = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");

            //Siempre estara escuchando peticiones
            while (true) {

                //Espera a que un jugador se conecte
                System.out.println("Esperando jugadores...");
                
                socket = servidor.accept();

                System.out.println("Jugador conectado");
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());

                //Lee el mensaje que le envia el jugador
                String mensaje = input.readUTF();

                System.out.println(mensaje);

                //Le envio un mensaje
                Scanner keyboard = new Scanner(System.in);
                String MensajeParaJugador = keyboard.nextLine();
                output.writeUTF(MensajeParaJugador);

                //Cierro el socket
                socket.close();
                keyboard.close();
                System.out.println("Jugador abandono la partida");

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}