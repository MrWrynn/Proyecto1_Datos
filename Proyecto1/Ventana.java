package Proyecto1;

import javax.swing.JFrame;


import java.awt.GridLayout;
import javax.swing.JButton;

import java.util.Random;


public class Ventana extends JFrame{
    JButton dado=new JButton("DADO");
    Random generador=new Random();
    int moverse;

    public Ventana(){
        this.setSize(650,650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4,4,0,0));
    }
    
}
