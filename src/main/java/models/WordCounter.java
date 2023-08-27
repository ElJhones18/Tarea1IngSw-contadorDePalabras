package models;

public class WordCounter {

    private String text;
    private String word;

    public WordCounter(String text, String word) {
        this.text = text;
        this.word = word;
    }

    /**
     * Separa el texto en palabras con la función split y una expresión regular con los delimitadores de palabras.
     * Posteriormente, se cuentan las coincidencias con la palabra a buscar.
     * @return el número de coincidencias encontradas
     */
    public int wordCount() {
        String[] words = text.split("[\\s,.();]+");
        int count = 0;

        for (String word: words) {
            if (word.equals(this.word)) {
                count += 1;
            }
        }
        return count;
    }

}
