
package controlador;

import java.util.ArrayList;
import java.util.Collections;

public class LogicPart {

    private Diccionario palabras;
    private ArrayList<String> listaPalabras;
    private ArrayList<String> correctAndIncorrect;

    //
    public LogicPart() {
        // Constructor metodo que usa la clase para
        this.palabras = new Diccionario();
        listaPalabras = new ArrayList<String>();
        correctAndIncorrect = new ArrayList<String>();
    }

    public void wrongWords(int cantPalabras) {
        for (int i = 0; i < cantPalabras; i++) {
            String word = palabras.getPalabra();
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
        for (int i = 0; i < cantPalabras; i++) {
            listaPalabras.add(palabras.getPalabra());
            correctAndIncorrect.add(palabras.getPalabra());
        }
        wrongWords(cantPalabras);
    }

    public ArrayList<String> getListaPalabras() {

        return listaPalabras;

    }

    public ArrayList<String> getCorrectAndIncorrect() {
        return correctAndIncorrect;
    }


    public void resetGodWord() {
        correctAndIncorrect.clear();
    }

    public boolean verificador(String palabra) {
        return listaPalabras.contains(palabra);
    }
}
