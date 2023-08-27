package models;

import java.io.*;
import java.util.ArrayList;

public class FolderScanner {

    private String folderPath;
    private File folder;

    public FolderScanner(String folderPath) {
        this.folderPath = folderPath;
        this.folder = new File(folderPath);
    }

    /**
     * Método para verificar que la ruta dada corresponde a un directorio y que este existe
     * @return true si lo anterior se cumple, false de otro modo
     */
    public boolean folderExists() {
        return this.folder.isDirectory() && this.folder.exists();
    }

    /**
     * Obtiene los archivos de texto encontrados en el directorio.
     * Se verifica que existan archivos, luego se verifica la extension de cada uno de ellos.
     * Si el archivo tiene una extensión de texto se agrega al array list.
     * @return array list con los archivos de texto
     */
    public ArrayList<File> getTextFiles() {
        File[] files = this.folder.listFiles();
        ArrayList<File> textFiles = new ArrayList<File>();
        if (files != null) {
            for (File f : files) {
                String extension = "";
                String filePath = f.getAbsolutePath();
                int index = filePath.lastIndexOf(".");
                if (index != -1) {
                    extension = filePath.substring(index + 1);
                    if (extension.equals("txt") || extension.equals("xml") || extension.equals("json") || extension.equals("csv")) {
                        textFiles.add(f);
                    }
                } else {
                    System.err.println("El archivo no tiene extension");
                }
            }
            if (textFiles.isEmpty()) {
                System.err.println("No se encontraron archivos de texto en la carpeta");
            }
        } else {
            System.err.println("No se encontraron archivos en la carpeta");
        }
        return textFiles;
    }

}
