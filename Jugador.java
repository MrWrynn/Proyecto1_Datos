
package Proyecto1;

import javax.swing.*;  //importar interfaz grafica 

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

package Proyecto1;

import javax.swing.*;  //importar interfaz grafica 

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
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

        
    }
    
}

class ventanaJugador extends JFrame{ //La clase hereda de JFrame para poder crear cuadros(ventanas)
    public ventanaJugador() { //Constructor
        System.out.println("Pantalla del jugador");
        setBounds(500, 200, 400, 300);
        setResizable(false); //evitar que la ventana se redimencione
        setTitle("Jugador");
        Lamina lamina1 = new Lamina();
        add(lamina1);
        setVisible(true); //muestra la ventana 
    
    }
}

class Lamina extends JPanel implements Runnable{
    
    JLabel datos = new JLabel("Ingrese su nombre: "); // instancia para agregar una etiqueta de texto
    JButton boton1 = new JButton("Conectar"); // instancia para crear un boton 
    
    
    
    JTextField nombre1 = new JTextField(10); //Nos abre un campo para agregar texto
    public Lamina(){ //constructor
        
        add(datos); // se añade el texto a la lamina
        
        add(nombre1);
        
        GetText click = new GetText(); //instancia que servira para obtener el texto al presionar el boton
        boton1.addActionListener(click);


        add(boton1); //se añade el boton a la lamina 

        
        
    }

    public  class GetText implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
               EnviarMensaje(nombre1.getText());
               Ventana ventana=new Ventana();
               LinkedList lista=new LinkedList();
               Dado dado =new Dado(ventana,lista);
               creartablero tablero =new creartablero(ventana, lista);
        ventana.setVisible(true);
            
    }


    public void EnviarMensaje(String message){
        String HOST ="localhost";

        //Port del servidor
        int PORT = 8888;
        //DataInputStream input;
        DataOutputStream output;

        try{
            //Se crea el socket para conectarse con el servidor
            Socket socket = new Socket(HOST, PORT);
            //input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            
            output.writeUTF(message);

            

            System.out.println("Mensaje enviado: " + message);

            socket.close();
           

        }catch (IOException ex){
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


   
 
}   
}



