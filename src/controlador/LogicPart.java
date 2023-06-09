
package controlador;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;

public class LogicPart {

    private Diccionario palabras;
    private ArrayList<String> listaPalabras;
    private ArrayList<String> correctAndIncorrect;
    private int puntaje;

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }

    //
    public LogicPart() {
        // Constructor metodo que usa la clase para
        this.puntaje = 0;
        this.palabras = new Diccionario();
        listaPalabras = new ArrayList<String>();
        correctAndIncorrect = new ArrayList<String>();
    }


    public void wrongWords(int cantPalabras) {
        for (int i = 0; i < cantPalabras; i++) {
            String word = palabras.getPalabra();
            if(listaPalabras.contains(word)){
                cantPalabras++;
            }
            if (!correctAndIncorrect.contains(word)) {
                correctAndIncorrect.add(word);
            }


        }
        Collections.shuffle(correctAndIncorrect);
    }

    /**
     * Agrega palabras desde el dicionario a los arrays
     *
     * @param cantPalabras int
     */
    public void crearLista(int cantPalabras) {
        int prueba = cantPalabras;
        for (int i = 0; i < cantPalabras; i++) {
            String palabraTemporal = palabras.getPalabra();
            if(listaPalabras.contains(palabraTemporal)){
                cantPalabras++;
            }
            if(!listaPalabras.contains(palabraTemporal)){
                listaPalabras.add(palabraTemporal);
                correctAndIncorrect.add(palabraTemporal);
            }


        }
        wrongWords(prueba);
    }

    public ArrayList<String> getListaPalabras() {

        return listaPalabras;

    }

    public ArrayList<String> getCorrectAndIncorrect() {
        return correctAndIncorrect;
    }


    public void resetListas() {
        correctAndIncorrect.clear();
        listaPalabras.clear();
    }

    public boolean verificador(String palabra) {
        return listaPalabras.contains(palabra);
    }
}
