package controlador;

import controlador.Diccionario;

import java.util.ArrayList;

public class LogicPart {

    private Diccionario palabras;
    private ArrayList <String> listaPalabras;
    private ArrayList <String> correctAndIncorrect;

    public LogicPart(ArrayList<String> listaPalabras, ArrayList<String> correctAndIncorrect) {
        this.palabras = new Diccionario();
        this.listaPalabras = listaPalabras;
        this.correctAndIncorrect = correctAndIncorrect;
    }

    public ArrayList<String> getListaPalabras() {
        return listaPalabras;
    }

    public ArrayList<String> getCorrectAndIncorrect() {
        return correctAndIncorrect;
    }
    public boolean verificador (){

    }
}



