
package Client;

import Utils.*;

import javax.swing.*;  //importar interfaz grafica

import java.awt.event.*;
import java.io.IOException;
import java.util.Random;
import java.lang.NullPointerException;


public class Client {
    public static void main(String[] args) throws IOException {
        Communication server = new Communication(7777, 8888);

        Window ventana1 = new Window(server);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para que al cerrar la ventana no siga ejecutandose


    }

}

class Window extends JFrame { //La clase hereda de JFrame para poder crear cuadros(ventanas)
    public Window(Communication communication) { //Constructor
        System.out.println("Pantalla del jugador");
        setBounds(500, 200, 400, 300);
        setResizable(false); //evitar que la ventana se redimencione
        setTitle("Jugador");
        Panel panel = new Panel(communication);
        add(panel);
        setVisible(true); //muestra la ventana
    }
}

class Panel extends JPanel implements Runnable {

    JLabel datos = new JLabel("Ingrese su nombre: "); // instancia para agregar una etiqueta de texto
    JButton boton1 = new JButton("Conectar"); // instancia para crear un boton
    JButton dado = new JButton("Dado"); 
    LinkedList lista;
    Ventana ventana;
    JTextField nombre1 = new JTextField(10); //Nos abre un campo para agregar texto
    Communication server;

    public Panel(Communication server) { //constructor
        ventana = new Ventana();
        this.server = server;
        add(datos); // se añade el texto a la lamina

        add(nombre1);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                server.EnviarMensaje(nombre1.getText(), 8888);
                

            }
        });


        add(boton1); //se añade el boton a la lamina

        Thread thread = new Thread(this);
        thread.start();

    }

    private LinkedList generateList(String[] list) {
        LinkedList result = new LinkedList();
        for (String i :
                list) {
            int x = Integer.parseInt(i);
            result.insertNode(x);
        }
        return result;
    }

    public void createTable(Ventana ventana, String[] info) {

        for (String i : info) {
            System.out.println(i);
            switch (i) {

                case "0":
                    new Reto().crear(ventana);
                    break;
                case "1":
                    new Trampa().crear(ventana);
                    break;
                case "2":
                    new Tunel().crear(ventana);
                    break;
                case "3":
                    new Casilla().crear(ventana);
                    break;
            }
        }
    }

    @Override
    public void run() {
        Random generador=new Random();
        int contador=0;
        while (true) {
//            ventana.removeAll();
            System.out.println("GETTING HERE");
            String message = server.RecibirMensaje();
            if (!message.equals("ERROR")) {
                String[] list = message.split(",");
                lista = generateList(list);
                createTable(ventana, list);
                ventana.setVisible(true);
                ventana.setTitle("Jugador: "+nombre1.getText());
                ventana.add(dado);
                dado.setBounds(100, 50, 10, 10);
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
                            if (contador%2!=0){
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
                                }
                                n++;
                            }

                            System.out.println("*"+lista.runner.getData());
                        }catch(java.lang.NullPointerException ex){JOptionPane.showMessageDialog(null, "Has ganado");}
                    }
                });
                
            } else break;
        }
    }
}