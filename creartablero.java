package Proyecto1;
import java.util.Random;

public class creartablero {
    Random generador=new Random();
    Reto cr=new Reto();
    Trampa tp=new Trampa();
    Tunel tn=new Tunel();
    Casilla inicio=new Casilla();
    int i=1;
    int r=1;
    int tr=1;
    int tu=1;

    public creartablero(Ventana ventana,LinkedList tablero){
        inicio.crear(ventana);
        tablero.insertNode(3);
        while (i <=14){
            int opcion=generador.nextInt(3);
            if ((opcion==0) && (r<=7)){
                tablero.insertNode(0);
                cr.crear(ventana);
                i++;
                r++;
            }
            else if ((opcion==1) && (tr<=3)){
                tablero.insertNode(1);
                tp.crear(ventana);
                i++;
                tr++;
            }
            else if ((opcion==2) && (tu<=4)){
                tablero.insertNode(2);
                tn.crear(ventana);
                i++;
                tu++;}}
        inicio.crear(ventana);
        tablero.insertNode(3);
    }
}
