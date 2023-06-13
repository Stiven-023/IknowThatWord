package vista;

import controlador.LogicPart;
import myProject.Header;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

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
    JPanel panelImagen, panelBotton, panelBotton2, panelJuego, panelContinuidad, si_no, panelPuntaje;
    JButton jugar, comoJuega, volver, level1, level2, level3, level4, level5, level6, level7, level8, level9,
            level10,continuar, btnSi,btnNo;
    JLabel labelPalabras,labelSiNo,labelPuntaje, fondo;
    JTextArea memorizar;
    Container contenedor;
    private Escucha escucha;
    private ArrayList<String> goodWords;
    private ArrayList<String> godBadWords;
    private int juegoPuntaje;
    private static LogicPart logic;
    private int indexGodWords = 0,indexBadWords = 0;

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
        panelBotton2 = new JPanel();
        panelImagen = new JPanel();
        panelContinuidad = new JPanel();
        si_no = new JPanel();
        panelPuntaje = new JPanel();
        /*
         * Mas adelante los voy a necesitar
         * panelImagen.setFocusable(true);
         * panelImagen.requestFocusInWindow();
         */
        // Instanciando los botones
        jugar = new JButton("Jugar");
        comoJuega = new JButton("Como se juega");
        volver = new JButton("Volver");
        continuar = new JButton("Continuar");
        btnNo = new JButton("No");
        btnSi = new JButton("Si");

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
        panelBotton2.add(volver);


        //fondo.setIcon(new ImageIcon("/resources/esaPalabraSuena.png"));
        //fondo.setIcon( new ImageIcon( getClass().getResource( "/resources/esaPalabraSuena.png" ) ) );
      //  fondo.setBounds( 0, 0, fondo.getIcon().getIconWidth(), fondo.getIcon().getIconHeight() );
        //panelImagen.add(fondo);
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

        memorizar = new JTextArea("¿Seguro que ya has memorizado todas las palabras?"+"\n"+" Demuestralo!!");
        labelSiNo = new JLabel();
        labelPuntaje = new JLabel("Puntaje:"+juegoPuntaje);
        fondo = new JLabel();

        memorizar.setFont(new Font("Arial", Font.BOLD, 20));
        memorizar.setEditable(false);

        panelContinuidad.setLayout(new BorderLayout());
        panelContinuidad.add(continuar, BorderLayout.SOUTH);
        panelContinuidad.add(memorizar,BorderLayout.CENTER);
        si_no.setLayout(new BorderLayout());

        si_no.add(labelSiNo, BorderLayout.CENTER);
        panelPuntaje.add(btnSi);
        panelPuntaje.add(btnNo);
        panelPuntaje.add(labelPuntaje);

        si_no.add(panelPuntaje,BorderLayout.SOUTH);


        //contenedor.add(fondo);
        contenedor.add(panelBotton2, BorderLayout.SOUTH);
        //contenedor.add(panelImagen, BorderLayout.CENTER);
        contenedor.add(panelBotton, BorderLayout.SOUTH);
        /*contenedor.add(panelBotton2, BorderLayout.SOUTH);*/

        repaint();
        revalidate();
        comoJuega.addActionListener(escucha);
        jugar.addActionListener(escucha);
        volver.addActionListener(escucha);
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
        continuar.addActionListener(escucha);
        btnSi.addActionListener(escucha);
        btnNo.addActionListener(escucha);



        panelJuego = new JPanel();
        panelJuego.setBackground(Color.GRAY);

        labelPalabras = new JLabel("");
        labelPalabras.setFont(new Font("Arial", Font.BOLD, 20));


        panelJuego.add(labelPalabras);

    }

    /**
     *
     */
    private void changeWord() {
        System.out.println(indexGodWords);
        labelPalabras.setText(goodWords.get(indexGodWords));
    }
    private void changeBadWord() {
        System.out.println(indexBadWords);
        labelSiNo.setText(godBadWords.get(indexBadWords));
    }


    /**
     * Change word every 5 seconds
     */
    private void changeWordTimer() {
        Thread hilo = new Thread(() -> {
            try {

                while (indexGodWords < goodWords.size() - 1) {
                    Thread.sleep(5000); // Esperar 5 segundos
                    SwingUtilities.invokeLater(() -> {
                        changeWord();
                        indexGodWords++;
                    });
                }
                goContinuar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        hilo.start();
    }
    private void changeBadWordTimer(){
        Thread hilo = new Thread(() -> {
            try {

                while (indexBadWords < godBadWords.size() - 1) {
                    Thread.sleep(5000); // Esperar 5 segundos
                    SwingUtilities.invokeLater(() -> {
                        changeBadWord();
                        indexBadWords++;
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
        godBadWords = logic.getCorrectAndIncorrect();
        juegoPuntaje = logic.getPuntaje();

        contenedor.remove(panelImagen);
        contenedor.add(panelJuego, BorderLayout.CENTER);
        repaint();
        revalidate();
        //resetGame();
        changeWordTimer(); // Llamar a changeWordTimer() aquí

    }
    public void goSi_No() {
        contenedor.remove(panelContinuidad);
        contenedor.add(si_no, BorderLayout.CENTER);
        repaint();
        revalidate();
        //resetGame();
        changeBadWordTimer(); // Llamar a changeWordTimer() aquí

    }

    /**
     * metodo para agregar frase despues de que se termine de mostrar las palabras por nivel
     *
     */

    public void goContinuar(){
        contenedor.remove(panelJuego);
        contenedor.add(panelContinuidad, BorderLayout.CENTER);
        repaint();
        revalidate();

    }


    public void resetGame() {
        indexBadWords = 0;
        indexGodWords = 0;
        logic.resetListas();
    }

    /**
     * Metodo para actualizar el puntaje
     */
    public void updatePuntaje(int indicador){
        System.out.println("badWords: "+indexBadWords);
        String palabra = godBadWords.get(indexBadWords);
        if(indicador ==1 && logic.verificador(palabra)){
            juegoPuntaje += 10;
            labelPuntaje.setText("Puntaje: "+juegoPuntaje);
        }
        if(indicador ==2 && !logic.verificador(palabra)) {
            juegoPuntaje += 10;
            labelPuntaje.setText("Puntaje: "+juegoPuntaje);

        }
        System.out.println("This: "+juegoPuntaje);

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
    public class Imagen extends javax.swing.JPanel {
        int x, y;

        public Imagen(JPanel jPanel1) {
            this.x = jPanel1.getWidth();
            this.y = jPanel1.getHeight();
            this.setSize(x, y);
        }

        @Override
        public void paint(Graphics g) {
            ImageIcon Img = new ImageIcon(getClass().getResource("/resources/esaPalabraSuena.png"));
            g.drawImage(Img.getImage(), 0, 0, x, y, null);
        }

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
            if (actionEvent.getSource() == jugar) {
                panelBotton.setVisible(false);
                contenedor.add(panelImagen, BorderLayout.CENTER);
                panelImagen.setVisible(true);
                contenedor.add(panelBotton2, BorderLayout.SOUTH);
                panelBotton2.setVisible(true);
            }
            if (actionEvent.getSource() == volver) {
                panelBotton2.setVisible(false);
                panelJuego.setVisible(false);
                panelBotton.setVisible(true);
                panelImagen.setVisible(false);
            }
            if (actionEvent.getSource() == continuar){
                goSi_No();

            }
            if(actionEvent.getSource() ==btnSi){
                System.out.println("SI");
                updatePuntaje(1);

            }
            if(actionEvent.getSource() ==btnNo){
                System.out.println("NO");
                updatePuntaje(2);
            }
            if (actionEvent.getSource() == level1) {
                System.out.println("hola");
                goGame(10);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/

            }

            if (actionEvent.getSource() == level2) {
                System.out.println("hola");
                goGame(20);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
            }
            if (actionEvent.getSource() == level3) {
                System.out.println("hola");
                goGame(25);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
            }
            if (actionEvent.getSource() == level4) {
                System.out.println("hola");
                goGame(30);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
            }
            if (actionEvent.getSource() == level5) {
                System.out.println("hola");
                goGame(35);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
            }
            if (actionEvent.getSource() == level6) {
                System.out.println("hola");
                goGame(40);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
            }
            if (actionEvent.getSource() == level7) {
                System.out.println("hola");
                goGame(50);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
            }
            if (actionEvent.getSource() == level8) {
                System.out.println("hola");
                goGame(60);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
            }
            if (actionEvent.getSource() == level9) {
                System.out.println("hola");
                goGame(70);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
            }
            if (actionEvent.getSource() == level10) {
                System.out.println("hola");
                goGame(100);
                panelBotton2.setVisible(false);
                /*panelBotton.setVisible(false);
                panelBotton2.setVisible(true);
                panelImagen.setVisible(true);*/
                // System.exit(0);
            }


        }
    }
}
