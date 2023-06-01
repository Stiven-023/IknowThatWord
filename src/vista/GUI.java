package myProject;
import  javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    JPanel panelImagen, panelBotton;
    JButton jugar, comoJuega, paQueSirve;
    Container contenedor;


    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("The Title app");
        contenedor = this.getContentPane();
        this.setSize(600,400);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Instanciando los paneles
        panelBotton = new JPanel();
        panelImagen = new JPanel();
        /*
        Mas adelante los voy a necesitar
        panelImagen.setFocusable(true);
        panelImagen.requestFocusInWindow();
        */
         //Instanciando los botones
        jugar = new JButton("Jugar");
        comoJuega = new JButton("Como se juega");
        paQueSirve = new JButton("Para que sirve");

        panelBotton.add(jugar);
        panelBotton.add(comoJuega);
        panelBotton.add(paQueSirve);

        contenedor.add(panelImagen,BorderLayout.CENTER);
        contenedor.add(panelBotton,BorderLayout.SOUTH);

        repaint();
        revalidate();
    }



    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        headerProject = new Header("Header ...", Color.BLACK);


        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout
    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}
