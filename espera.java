
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;  //importar interfaz grafica
import java.io.IOException;
import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import javax.swing.JButton;


public class espera {
    public static void main(String[] args) throws IOException {
        ventanaEspera ventana1 = new ventanaEspera();
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para que al cerrar la ventana no siga ejecutandose
    }
}

class ventanaEspera extends JFrame { //La clase hereda de JFrame para poder crear cuadros(ventanas)
    int posicion =0;

    public ventanaEspera() { //Constructor
        

        System.out.println("Pantalla de espera");
        setBounds(500, 200, 600, 300);
        setResizable(false); //evitar que la ventana se redimencione
        setTitle("Pantalla de Espera");

        Lamina1 lamina1 = new Lamina1();
        add(lamina1);

        setVisible(true); //muestra la ventana 
        
    }        

}    

class Lamina1 extends JPanel {

    
    
    JLabel titulo1 = new JLabel("Jugador 1: "); // instancia para agregar una etiqueta de texto
    JTextField nombre1 = new JTextField(10); //Nos abre un campo para agregar texto
    JButton boton1 = new JButton("Conectar"); // instancia para crear un boton
    JLabel titulo2 = new JLabel("Jugador 2: "); // instancia para agregar una etiqueta de texto
    JTextField nombre2 = new JTextField(10); //Nos abre un campo para agregar texto
    JButton boton2 = new JButton("Conectar"); // instancia para crear un boton
    

    public Lamina1() { //constructor

        add(titulo1);
        add(nombre1);
        add(boton1);
        add(titulo2);
        add(nombre2);
        add(boton2);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            nombre1.getText();
            VentanaJ ventana1 = new VentanaJ();
            
            }
        });


        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            
            Ventana2 ventana2 = new Ventana2();
            ventana2.setVisible(true);
            }
        });
    }

}


class VentanaJ extends javax.swing.JFrame implements Observer { //Al observer se le notifica
    
    int posicion=0;
    int posicion2=0;
    public VentanaJ() {
        ventana.setTitle("Jugador 1");
        ventana.setVisible(true);
        ventana.add(dado);
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
                    botones[posicion].setText("");
                    posicion=posicion+moverse;
                    System.out.println(lista.runner.getData());
                    int runnerA = (int) lista.runner.getData();
                    int movimiento=generador.nextInt(3)+1;
                    while (n==1){
                        System.out.println("Mov: "+movimiento);
                        if (runnerA==1){
                            JOptionPane.showMessageDialog(null, "Has caído en una trampa, retrocedes "+movimiento+" casillas");
                        } else if (runnerA==2) {
                            JOptionPane.showMessageDialog(null, "Has caído en un tunel, avanzas "+movimiento+" casillas");
                        }
                        while (runnerA==1 && num<=movimiento && posicion>0){
                            lista.runner=lista.runner.anterior;
                            posicion--;
                            String posString = Integer.toString(posicion);
                            jugador1.setText("J1: "+posString);
                            num++;
                        } while (runnerA==2 && num<=movimiento){
                            lista.runner=lista.runner.siguiente;
                            posicion++;
                            String posString = Integer.toString(posicion);
                            jugador1.setText("J1: "+posString);
                            num++;
                        }
                        if (runnerA==0){
                            //reto.reto();   //se debe enviar al otro jugador
                            lista.runner=lista.runner.siguiente;
                            posicion++;
                            String mensaje="reto";
                            String posString = Integer.toString(posicion);
                            Cliente c = new Cliente(8000, mensaje);
                            Thread t = new Thread(c);
                            t.start();
                            jugador1.setText("J1: "+posString);
                        }
                        n++;
                        botones[posicion].setText(":)");
                        if (posicion==15){
                            JOptionPane.showMessageDialog(null, "Has ganado");
                        }
                    
                    }
                    System.out.println("*"+lista.runner.getData());
                }catch(java.lang.NullPointerException ex){JOptionPane.showMessageDialog(null, "Has ganado");}
                btnEnviarActionPerformed(actionEvent);
            }
        });
        ventana.add(jugador1);
        jugador1.setEnabled(false);
        ventana.add(jugador2);
        jugador2.setEnabled(false);
        this.getRootPane().setDefaultButton(this.btnEnviar);
        //Hace que la ventana funcione como servidor
        Servidor s = new Servidor(7000); //Puerto
        s.addObserver(this); //Indica que el notifyObservers debe notificar esta clase
        Thread t = new Thread(s);
        t.start();
    }

// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed


        String mensaje = Integer.toString(posicion);
        System.out.println(mensaje);
        //Hace que la ventana funcione como cliente
        Cliente c = new Cliente(8000, mensaje);
        Thread t = new Thread(c);
        t.start();


    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Crea y muestra la ventana */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Declaración de variables - no modificar//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtTexto;
    private javax.swing.JTextField txtTextoEnviar;
    JButton jugador1 = new JButton("J1: "+posicion);//
    JButton dado = new JButton("Dado");//
    JButton jugador2 = new JButton("J2: "+posicion2);//
    Random generador=new Random();//
    Ventana ventana = new Ventana();//
    LinkedList lista = new LinkedList();//
    creartablero tablero = new creartablero(ventana, lista);//
    Reto reto=new Reto();
    JButton botones[]=tablero.botones;
    /**  Fin de la declaración de variables//GEN-END:variables */

    /**
     * A continuación, el update permite que los metodos del servidor se actualicen en la ventana
     *  El Object arg es el mensaje
     */
    @Override
    public void update(Observable o, Object arg) { 
        System.out.println(arg);
        String mensaje=String.valueOf(arg);
        if (mensaje=="false" && posicion!=0){
            System.out.println("Funcionó");
            System.out.println("La posición es: "+posicion);
            botones[posicion].setText("");
            lista.runner=lista.runner.anterior;
            posicion--;
            botones[posicion].setText(":)");
        } else {
            jugador2.setText("J2: "+arg);
        }
        
    }

}