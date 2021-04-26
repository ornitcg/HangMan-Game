import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordStock {
    private ArrayList<String> _wordsArr = new ArrayList<String>();

    /**
     * Construcor of array list of game words
     * @param sc - reads the words from a text file
     */
    public WordStock(Scanner sc) {
        while (sc.hasNext()){
            _wordsArr.add(new String(sc.nextLine()));
            System.out.println();
        }
    }


    /**
     * Gets a random word from the input list
     * @return the randomly chosen word for game
     */
    public String getRandomWord() {
        int randIndex = ((int) Math.random() * 1000) % _wordsArr.size();
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
