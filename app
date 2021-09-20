package Proyecto1;
import java.util.Random;

public class app {
    public static void main(String[] args){
        Ventana ventana=new Ventana();
        LinkedList lista=new LinkedList();
        Dado dado=new Dado(ventana,lista);
        Random generador=new Random();
        creartablero tablero=new creartablero(ventana, lista);
       
    ventana.setVisible(true);
}
}
