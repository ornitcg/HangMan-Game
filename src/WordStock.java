import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordStock {
    private ArrayList<String> _wordsArr = new ArrayList<String>();

    /**
     * Construcor of array list of game words
     * @param sc - reads the words from a text file
     * @param filePath
     */
    public WordStock(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String word = new String(sc.nextLine());
            _wordsArr.add(word);
            System.out.println(word);
        }
    }


    /**
     * Gets a random word from the input list
     * @return the randomly chosen word for game
     */
    public String getRandomWord() {
        int randIndex = ((int) (Math.random() * 12345) % _wordsArr.size());
        return _wordsArr.get(randIndex);
    }

    /**
     * for debugging
     */
    public void printWords(){
        int size = _wordsArr.size();
        for(int i = 0 ; i < size; i++){
            System.out.println(_wordsArr.get(i));
        }
    }
}
