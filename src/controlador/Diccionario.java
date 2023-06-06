package controlador;

import java.util.ArrayList;
import java.util.Random;

public class Diccionario {
    private ArrayList<String> diccionario = new ArrayList<String>();
    public Diccionario(){
        FileManager fileManager = new FileManager();
        diccionario = fileManager.reader();
    }
    public String getPalabra(){
        //con este objeto puedo generar numeros aleatorios
        Random aleatorio = new Random();

        //metodo size devuelve la cantidad de elementos que tiene la lista
        return diccionario.get(aleatorio.nextInt(diccionario.size()));
    }
}
