package control;

import models.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AppControl {

    private FolderScanner folderScanner;
    private FileReader fileReader;
    private WordCounter wordCounter;

    /**
     * Método para iniciar la aplicación de conteo de palabras en directorios.
     * Se pide la ruta del directorio y la palabra a buscar.
     * Posteriormente, se verifica que la ruta sea de un directorio existente y
     * que existan documentos de texto en él.
     */
    public void start() {

        folderScanner = new FolderScanner(pathInput());
        String word = wordInput();

        if (!folderScanner.folderExists()) {
            System.err.println("La ruta dada no existe o no es una carpeta.");
            return;
        }

        ArrayList<File> textFiles = folderScanner.getTextFiles();

        if (textFiles.isEmpty()) {
            return;
        }

        showWordCount(textFiles, word);

    }

    /**
     * Se pide al usuario la ruta del directorio
     * @return la ruta ingresada
     */
    public String pathInput() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Ingrese la ruta de la carpeta: ");
        return keyboard.nextLine();
    }

    /**
     * Se pide al usuario la palabra a buscar
     * @return la palabra ingresada
     */
    public String wordInput() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Ingrese la palabra que desea buscar: ");
        return keyboard.nextLine();
    }

    /**
     * Mostrar por consola el resultado de la búsqueda de palabras.
     * @param textFiles archivos de texto donde se buscará la palabra
     * @param word palabra a buscar
     */
    public void showWordCount(ArrayList<File> textFiles, String word) {
        int total = 0;

        for (File f: textFiles) {
            fileReader = new FileReader(f);
            wordCounter = new WordCounter(fileReader.readText(), word);
            System.out.println(f.getName() + ": " + wordCounter.wordCount() + " veces");
            total += wordCounter.wordCount();
        }

        System.out.println("Total: " + total + " veces");

    }
}
