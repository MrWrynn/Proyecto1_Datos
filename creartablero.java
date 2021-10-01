package Proyecto1;
import java.util.Random;

public class creartablero {
    Random generador=new Random();
    Reto cr=new Reto();
    Trampa tp=new Trampa();
    Tunel tn=new Tunel();
    Casilla inicio=new Casilla();
    int[] arreglo=new int[16];
    int i=1;
    int r=1;
    int tr=1;
    int tu=1;

    public creartablero(Ventana ventana,LinkedList tablero){
        inicio.crear(ventana);
        tablero.insertNode(3);
        arreglo[0]=3;
        while (i <=14){
            int opcion=generador.nextInt(3);
            if ((opcion==0) && (r<=7)){
                tablero.insertNode(0);
                cr.crear(ventana);
                arreglo[i+1]=0;
                i++;
                r++;
            }
            else if ((opcion==1) && (tr<=3)){
                tablero.insertNode(1);
                tp.crear(ventana);
                arreglo[i+1]=1;
                i++;
                tr++;
            }
            else if ((opcion==2) && (tu<=4)){
                tablero.insertNode(2);
                tn.crear(ventana);
                arreglo[i+1]=2;
                i++;
                tu++;}}
        inicio.crear(ventana);
        tablero.insertNode(3);
        arreglo[15]=3;}
   
}
