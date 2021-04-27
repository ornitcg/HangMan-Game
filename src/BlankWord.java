import javax.swing.*;
/*
    This class chooses the word to be guessed in the HangMan game
 */


public class BlankWord extends JPanel {
    private String _word;
    private String _wordBlanks;
    private int _wordLettersNum;
    private int _correctLettersNum;



    public BlankWord(String word){
        _word = new String(word);
        _wordLettersNum = countLetters(_word);
        _wordBlanks = createWordBlanks(_word);
        _correctLettersNum = 0;

    }

    private int countLetters(String word) {
        int len = get_word().length();
        int count = 0;
        for(int i = 0 ; i < len ; i++){
            if ( word.charAt(i) != ' ')
                count+=1;
        }
        return count;
    }

    /**
     * Creates a  String of blanks for the chosen word to be guessed in the game
     * Assuming valid input
     */
    private String createWordBlanks(String word) {
        String blankWord = "";
        int len = get_word().length();
        for(int i = 0 ; i < len ; i++){
            if ( word.charAt(i) == '-' || word.charAt(i) == ' ')
                blankWord = blankWord + " ";
            else blankWord = blankWord + "_";
        }
        return blankWord;
    }

    public String get_wordDisplay() {
        String blankWord = "";
        int len = get_word().length();
        for(int i = 0 ; i < len ; i++){
            if ( get_word().charAt(i) == ' ')
                blankWord = blankWord + "    ";
            else blankWord = blankWord + "_ ";
        }
        return blankWord;
    }


    /**
     * Checks if a guessed letter is in the questioned word
     * @param letter the guessed letter
     * @return true if letter exists in word and false otherwise
     */
    public boolean tryLetter(char letter){
        int len = get_word().length();
        char charInWord  ; // stand for for answer and question
        for(int i = 0 ; i < len ; i++){
            charInWord =  get_word().charAt(i);
            if (letter == (char) charInWord )
                set_wordBlanks(i, letter);
            else return false;
        }
        return true;
    }


////////////////////////////////////// Getters & Setters ////////////////////////////////////////////
    public String get_word() {
        return _word;
    }

    public String get_wordBlanks() {
        return _wordBlanks;
    }



    public void set_wordBlanks(int index, char letter) {
        StringBuilder sb = new StringBuilder(_wordBlanks);
        sb.setCharAt(index, letter);
    }

    public int get_wordLettersNum() {
        return _wordLettersNum;
    }


    public int get_correctLettersNum() {
        return _correctLettersNum;
    }

    public void set_correctLettersNum(int _correctLettersNum) {
        this._correctLettersNum = _correctLettersNum;
    }
}
