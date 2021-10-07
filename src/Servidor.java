import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;  //importar interfaz grafica
import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import javax.swing.JButton;

public class Servidor extends Observable implements Runnable {

    private int puerto;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;

        try {
            /**Se crea el socket del servidor */
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            /**El while true es para que siempre esté escuchando peticiones */
            while (true) {

                /**Espera a que un cliente se conecte */
                sc = servidor.accept();

                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
               
                /**Lee el mensaje enviado */
                String mensaje = in.readUTF();
                System.out.println("Mensaje server:"+mensaje);
                if (mensaje.equals("reto")){
                    Reto reto=new Reto();
                    //reto.reto();
                    if (reto.reto()==false){
                        JOptionPane.showMessageDialog(null, "Respuesta incorrecta");
                        mensaje="false";
                        
                    }
                }
                
                
                /**
                 * A continuación el codigo se encarga de preguntar si el mensaje enviado
                 * tiene el formato de un calculo (",valor,peso,porcentaje") para realizar
                 * el calculo, en caso de no tenerlo solo envía el mensaje.
                 */

                
                
                /**el notifyObservers es el encargado de hacer llegar el mensaje enviado por la ventana emisora
                 * hasta la ventana receptora
                 */
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                /**Para cerrar el socket */
                sc.close();
                System.out.println("Cliente desconectado");

            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}