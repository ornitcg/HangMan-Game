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

    public String getWordDisplay() {
        String blankWord = "";
        int len = _wordBlanks.length();
        for(int i = 0 ; i < len ; i++){
            char letter = _wordBlanks.charAt(i);
            if ( letter == ' ')
                blankWord = blankWord + "    ";
            else if ( letter == '_')
                blankWord = blankWord + "_ ";
            else blankWord = blankWord + letter + " ";
        }
        return blankWord;
    }


    /**
     * Checks if a guessed letter is in the questioned word
     * @param letter the guessed letter
     * @return true if letter exists in word and false otherwise
     */
    public boolean tryLetter(String letter){
        Boolean res = _word.contains(letter);
        return (res);
    }

    /**
     * updates the correctly guessed letters in the _wordBlanks
     * @param letterStr
     */
    public void updateWordBlanks(String letterStr) {
        char letter = letterStr.charAt(0);
        for (int i=0 ; i < _wordLettersNum; i++){
            if (_word.charAt(i) == letter)
                set_wordBlanks(i , letter);
        }
        System.out.println(_wordBlanks);
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
        _wordBlanks = sb.toString();
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
