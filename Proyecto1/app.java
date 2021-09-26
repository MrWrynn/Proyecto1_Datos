package Proyecto1;


public class app {
    public static void main(String[] args){
        Ventana ventana=new Ventana();
        LinkedList lista=new LinkedList();
        Dado dado=new Dado(ventana,lista);
        creartablero tablero=new creartablero(ventana, lista);
       
    ventana.setVisible(true);
}
}
