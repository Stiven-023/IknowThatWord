package vista;
import controlador.LogicPart;
import myProject.Header;

import  javax.swing.*;
import  java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {
    private static final String MENSAJE_INICIO = "Bienvenido a Craps \n"
            + "De los 10 dados que trae el juego se toman 3 y se colocan en el sector de \"Dados\n" +
            "Inactivos\". Los otros 7 dados se tiran y pasan a ser los \"Dados Activos\".\n"
            + "\n" +
            "Se van eligiendo los dados a utilizar según las habilidades de sus caras y se pasan al sector\n" +
            "de \"Dados Utilizados"
            + "\nSi como último dado activo queda un Dragón, se perderán todos los puntos acumulados."+
            "\n"
            + "\nEste juego lo jugará un único jugador y ganará si logra sumar 30 puntos o más en 5 rondas\n" +
            "consecutivas de juego";


    private Header headerProject;
    JPanel panelImagen, panelBotton, panelJuego;
    JButton jugar, comoJuega, paQueSirve,level1,level2,level3,level4,level5,level6,level7,level8,level9,level10;
    Container contenedor;
    private JPanel panelUno, panelDos;
    private Escucha escucha;
    private CardLayout cardLayout;
    private  ArrayList<String>nombre = new ArrayList<String>();


    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("The Title app");
        contenedor = this.getContentPane();
        this.revalidate();
        this.setSize(600,400);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();

        panelUno = new JPanel();
        panelUno.setBackground(Color.RED);

        panelDos = new JPanel();
        panelDos.setBackground(Color.BLUE);

        //Instanciando los paneles
        panelBotton = new JPanel();
        panelImagen = new JPanel();
        //panelImagen.setLayout(cardLayout);
        panelJuego = new JPanel();
        //panelJuego.setLayout(cardLayout);
        /*
        Mas adelante los voy a necesitar
        panelImagen.setFocusable(true);
        panelImagen.requestFocusInWindow();
        */
         //Instanciando los botones
        jugar = new JButton("Jugar");
        comoJuega = new JButton("Como se juega");
        paQueSirve = new JButton("Para que sirve");
        level1  = new JButton("1");
        level2 = new JButton("2");
        level3 = new JButton("3");
        level4 = new JButton("4");
        level5 = new JButton("5");
        level6 = new JButton("6");
        level7 = new JButton("7");
        level8 = new JButton("8");
        level9 = new JButton("9");
        level10 = new JButton("10");
        escucha = new Escucha();

        /**
         * Agrego los botoenes al panelBotton se encuentra situado en el sur del panel
         */
        panelBotton.add(jugar);
        panelBotton.add(comoJuega);
        panelBotton.add(paQueSirve);

        panelJuego.add(level1);
        panelJuego.add(level2);
        panelJuego.add(level3);
        panelJuego.add(level4);
        panelJuego.add(level5);
        panelJuego.add(level6);
        panelJuego.add(level7);
        panelJuego.add(level8);
        panelJuego.add(level9);
        panelJuego.add(level10);

        contenedor.add(panelImagen,BorderLayout.CENTER);
        contenedor.add(panelBotton,BorderLayout.SOUTH);
       // contenedor.add(panelJuego);

        jugar.addActionListener(escucha);
        comoJuega.addActionListener(escucha);
        level1.addActionListener(escucha);
        level2.addActionListener(escucha);
        level3.addActionListener(escucha);
        level4.addActionListener(escucha);
        level5.addActionListener(escucha);
        level6.addActionListener(escucha);
        level7.addActionListener(escucha);
        level8.addActionListener(escucha);
        level9.addActionListener(escucha);
        level10.addActionListener(escucha);

    }

    private void mostrarNuevoPanel(){
        JPanel nuevoPanel = new JPanel();
        nuevoPanel.setBackground(Color.RED);

        panelBotton.remove(level1);

        panelBotton.add(nuevoPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
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
            LogicPart logic = new LogicPart();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements ActionListener {
    LogicPart logicPart = new LogicPart();

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource() == jugar){
                contenedor.remove(panelImagen);
                contenedor.add(panelJuego, BorderLayout.CENTER);
                contenedor. revalidate();
                contenedor.repaint();

                System.out.println("RRRR");
            }

            if (actionEvent.getSource()==comoJuega) {
                logicPart.crearLista(0);
            ArrayList<String> buenas = logicPart.getListaPalabras();
            String general = "";
                for (String str: buenas) {
                    general += str + "\n";
                }
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            }

            if (actionEvent.getSource()==level1) {
                logicPart.crearLista(10);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general1 = "";

                for (String str: buenas) {
                    general1 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general1);
            }

            if (actionEvent.getSource()==level2) {
                logicPart.crearLista(20);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }
            if (actionEvent.getSource()==level3) {
                logicPart.crearLista(25);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }
            if (actionEvent.getSource()==level4) {
                logicPart.crearLista(30);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }
            if (actionEvent.getSource()==level5) {
                logicPart.crearLista(35);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }
            if (actionEvent.getSource()==level6) {
                logicPart.crearLista(40);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }
            if (actionEvent.getSource()==level7) {
                logicPart.crearLista(50);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }
            if (actionEvent.getSource()==level8) {
                logicPart.crearLista(60);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }
            if (actionEvent.getSource()==level9) {
                logicPart.crearLista(70);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }
            if (actionEvent.getSource()==level10) {
                logicPart.crearLista(100);
                ArrayList<String> buenas = logicPart.getListaPalabras();
                String general2 = "";
                for (String str: buenas) {
                    general2 += str + "\n";
                }
                JOptionPane.showMessageDialog(null, general2);
            }else{
                //System.exit(0);
            }



        }
    }
}
