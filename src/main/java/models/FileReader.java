package models;

import java.io.*;

public class FileReader {

    private File file;

    public FileReader(File file) {
        this.file = file;
    }

    /**
     * Se lee el texto interno del archivo de texto
     * @return el texto extraído del archivo
     */
    public String readText() {
        String filePath = this.file.getAbsolutePath();
        String text = "";

        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(filePath));
            StringBuilder temp = new StringBuilder();
            String bfRead;
            while ((bfRead = br.readLine()) != null) {
                temp.append(bfRead);
            }
            text = temp.toString();
        } catch (Exception e) {
            //
        }
        return text;
    }

}
