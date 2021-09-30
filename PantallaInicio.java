package Proyecto1;

import javax.swing.*;  //importar interfaz grafica 

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

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


public class PantallaInicio{
    public static void main (String [] args){
        ventanaInicio ventana1 = new ventanaInicio();
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para que al cerrar la ventana no siga ejecutandose
        
    }
    
}

class ventanaInicio extends JFrame{ //La clase hereda de JFrame para poder crear cuadros(ventanas)
    
    public ventanaInicio() { //Constructor
        System.out.println("PantalaInicio");
        setBounds(500, 200, 400, 300);
        setResizable(false); //evitar que la ventana se redimencione
        setTitle("Pantalla Inicio");
        
        Lamina1 lamina1 = new Lamina1();
        add(lamina1);
        setVisible(true); //muestra la ventana 
        RecibirMensaje(lamina1);

        
    }
    public void RecibirMensaje(Lamina1 lamina1){
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
            
                //Espera a que un jugador se una
                System.out.println("Esperando jugadores...");
                socket = servidor.accept(); //acepta un segundo jugador
                input = new DataInputStream(socket.getInputStream());
                
                
                //Leo el mensaje que me envia
                String mensaje = input.readUTF();

                System.out.println(mensaje);
                //lamina1.datos.setText(mensaje);
                JOptionPane.showMessageDialog( lamina1 , "Jugador: "+ mensaje + " está conectado");

                //Abre el tablero cuando se conecta el jugador 2
                Ventana ventana=new Ventana();
               LinkedList lista=new LinkedList();
               Dado dado =new Dado(ventana,lista);
               creartablero tablero =new creartablero(ventana, lista);
        ventana.setVisible(true);
                
               

                //Cierro el socket
                socket.close();
                
                System.out.println("Mensaje Recibido:"+ mensaje);
                

            
        }catch(IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

class Lamina1 extends JPanel implements Runnable{

    JLabel datos = new JLabel("Esperando jugadores..."); // instancia para agregar una etiqueta de texto
    
    
    public Lamina1(){ //constructor
    
        add(datos); // se añade el texto a la lamina
    
        
    }
    
}
