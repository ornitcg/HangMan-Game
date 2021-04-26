import javax.swing.*;
/*
    This class chooses the word to be guessed in the HangMan game
 */


public class GameWord extends JPanel {
    private String _word;
    private String _wordCurtain;
    private int _wordLetters;
    private int _foundLetters;



    public GameWord(String word){
        _word = new String(word);
        _wordLetters = countLetters(_word);
        _wordCurtain = createWordCurtain(_word);
        _foundLetters = 0;

    }

    private int countLetters(String word) {
        int len = get_word().length();
        int count = 0;
        for(int i = 0 ; i < len ; i++){
            if ( word.charAt(i) != '-')
                count+=1;
        }
        return count;
    }

    private String createWordCurtain(String word) {
        String wordCurtain = "";
        int len = get_word().length();
        for(int i = 0 ; i < len ; i++){
            if ( word.charAt(i) == '-')
                wordCurtain = wordCurtain + "-";
            else wordCurtain = wordCurtain + "_";
        }
        return wordCurtain;
    }


    public boolean tryLetter(char letter){
        int len = get_word().length();
        char ansCurLtr , qCurLtr  ; // stand for for answer and question
        for(int i = 0 ; i < len ; i++){
            qCurLtr =  get_word().charAt(i);
            ansCurLtr = get_wordCurtain().charAt(i);
            if (letter == (char) qCurLtr )
                set_wordCurtain(i, letter);
            else return false;
        }
        return true;
    }


////////////////////////////////////// Getters & Setters ////////////////////////////////////////////
    public String get_word() {
        return _word;
    }

    public String get_wordCurtain() {
        return _wordCurtain;
    }

    public void set_wordCurtain(int index, char letter) {
        StringBuilder sb = new StringBuilder(_wordCurtain);
        sb.setCharAt(index, letter);
    }

    public int get_wordLetters() {
        return _wordLetters;
    }



    public int get_foundLetters() {
        return _foundLetters;
    }

    public void set_foundLetters(int _foundLetters) {
        this._foundLetters = _foundLetters;
    }
}
