package vista;

import controlador.LogicPart;
import myProject.Header;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is used for ...
 * 
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {
    private static final String MENSAJE_INICIO = "Bienvenido palabra me suena \n"
            + "Se te presentara una secuencia de palabras, una detras de otra, \"\n" +
            "memorizarlas todas. El orden no es relevante.\n"
            + "\n" +
            "Tras la serie de palabras a memorizar, el juego te presentara un listado con el doble de palabras\n" +
            "Si la palabra pertenece al listado que has memorizado, pulsa sobre la miad DERECHA de la pantalla. Si no, "
            + "\nPulsa sobre la mitad IZQUIERDA. Hagamos una prueba...";

    private Header headerProject;
    JPanel panelImagen, panelBotton, panelJuego;
    JButton jugar, comoJuega, paQueSirve, level1, level2, level3, level4, level5, level6, level7, level8, level9,
            level10;
    JLabel labelPalabras;
    Container contenedor;
    private Escucha escucha;
    private ArrayList<String> goodWords;
    private ArrayList<String> godBadWords;
    private static LogicPart logic;
    private int index = 0;

    /**
     * Constructor of GUI class
     */
    public GUI() {
        initGUI();

        // Default JFrame configuration
        this.setTitle("The Title app");
        contenedor = this.getContentPane();
        this.setSize(600, 400);
        // this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Instanciando los paneles
        panelBotton = new JPanel();
        panelImagen = new JPanel();
        /*
         * Mas adelante los voy a necesitar
         * panelImagen.setFocusable(true);
         * panelImagen.requestFocusInWindow();
         */
        // Instanciando los botones
        jugar = new JButton("Jugar");
        comoJuega = new JButton("Como se juega");
        paQueSirve = new JButton("Para que sirve");
        level1 = new JButton("1");
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

        panelImagen.add(level1);
        panelImagen.add(level2);
        panelImagen.add(level3);
        panelImagen.add(level4);
        panelImagen.add(level5);
        panelImagen.add(level6);
        panelImagen.add(level7);
        panelImagen.add(level8);
        panelImagen.add(level9);
        panelImagen.add(level10);

        contenedor.add(panelImagen, BorderLayout.CENTER);
        contenedor.add(panelBotton, BorderLayout.SOUTH);

        repaint();
        revalidate();
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

        panelJuego = new JPanel();
        panelJuego.setBackground(Color.GRAY);

        labelPalabras = new JLabel("");
        labelPalabras.setFont(new Font("Arial", Font.BOLD, 20));

        panelJuego.add(labelPalabras);

    }

    private void changeWord() {
        System.out.println(index);
        labelPalabras.setText(goodWords.get(index));
    }

    /**
     * Change word every 5 seconds
     */
    private void changeWordTimer() {
        Thread hilo = new Thread(() -> {
            try {
                while (index < goodWords.size() - 1) {
                    Thread.sleep(5000); // Esperar 5 segundos
                    SwingUtilities.invokeLater(() -> {
                        changeWord();
                        index++;
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        hilo.start();
    }

    public void goGame(int level) {
        logic.crearLista(level);
        goodWords = logic.getListaPalabras();
        contenedor.remove(panelImagen);
        contenedor.add(panelJuego, BorderLayout.CENTER);
        changeWordTimer(); // Llamar a changeWordTimer() aquí
        repaint();
        revalidate();
        resetGame();
    }

    public void resetGame() {
        index = 0;
        logic.resetGodWord();
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    public void initGUI() {
        // Set up JFrame Container's Layout
        // Create Listener Object and Control Object
        // Set up JComponents
        headerProject = new Header("ESA PALABRA ME SUENA", Color.BLACK);

        this.add(headerProject, BorderLayout.NORTH); // Change this line if you change JFrame Container's Layout
    }

    /**
     * Main process of the Java program
     * 
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
            logic = new LogicPart();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI
     * class
     */
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == comoJuega) {
                logic.crearLista(0);
                ArrayList<String> buenas = logic.getListaPalabras();
                String general = "";
                for (String str : buenas) {
                    general += str + "\n";
                }
                JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
            }

            if (actionEvent.getSource() == level1) {
                System.out.println("hola");
                goGame(10);
            }

            if (actionEvent.getSource() == level2) {
                System.out.println("hola");
                goGame(20);
            }
            if (actionEvent.getSource() == level3) {
                System.out.println("hola");
                goGame(25);
            }
            if (actionEvent.getSource() == level4) {
                System.out.println("hola");
                goGame(30);
            }
            if (actionEvent.getSource() == level5) {
                System.out.println("hola");
                goGame(35);
            }
            if (actionEvent.getSource() == level6) {
                System.out.println("hola");
                goGame(40);
            }
            if (actionEvent.getSource() == level7) {
                System.out.println("hola");
                goGame(50);
            }
            if (actionEvent.getSource() == level8) {
                System.out.println("hola");
                goGame(60);
            }
            if (actionEvent.getSource() == level9) {
                System.out.println("hola");
                goGame(70);
            }
            if (actionEvent.getSource() == level10) {
                System.out.println("hola");
                goGame(100);
                // System.exit(0);
            }

        }
    }
}
