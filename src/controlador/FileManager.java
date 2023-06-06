package controlador;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private FileReader fileReader;
    private BufferedReader input;
    private FileWriter fileWriter;
    private BufferedWriter output;

    public ArrayList<String> reader(){
        //clase que me permite crear una lista y poder trabajar con ello
        ArrayList<String> frases= new ArrayList<String>();

        try {
            fileReader = new FileReader("src/myProject/files/fileText.txt");
            input = new BufferedReader(fileReader);
            String line = input.readLine();

            while(line != null){
                frases.add(line);

                line = input.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Estoy dentro de la excepcion");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            }  catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                System.out.println("Estoy dentro del finally");
                e.printStackTrace();
            }
        }

        return frases;
    }

    public void writer(String line){
        try {
            fileWriter = new FileWriter("src/fileManager/files/fileText.txt");
            output = new BufferedWriter(fileWriter);
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
