
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private JLabel _gameTitle;
    private JButton _startButton;
    private JButton _exitButton;
    private ArrayList<JButton> _lettersArr = new ArrayList<JButton>();

    private JLabel _mysteryWordLabel;
    private JLabel _msgToUser;

//    private BlankWord _word;
    private GallowPanel _gallowPanel;
    private JPanel _abcPanel;

    private JPanel _titleP = new JPanel();
    private WordStock _wordStock;
    private BlankWord _word = null;
    int _mistakesCount;

    final String HAPPY_GREEN = "#2b9348";



    /**
     * Constructor
     * @param
     */
    public MainPanel(String filPath) throws FileNotFoundException {
        _wordStock = new WordStock(filPath);
        ButtonListener lis = new ButtonListener();

        // *************** TITLE **********
        _gameTitle = new JLabel("HANG MAN GAME");
        _gameTitle.setFont(new Font("Arial", Font.BOLD, 60));
        _gameTitle.setForeground(Color.decode("#009f93"));

        _titleP.add(_gameTitle);

        // *************** START BUTTON **************
        _startButton = new JButton("START");
        _startButton.setForeground(Color.white);
        _startButton.setBackground(Color.decode("#007200"));

        _startButton.setFont(new Font("Arial", Font.BOLD, 20));
        _startButton.addActionListener(lis);
        JPanel rButtonP = new JPanel();
        rButtonP.add(_startButton, new GridLayout(1,1));

        // ******************* EXIT BUTTON ****************
        _exitButton = new JButton("EXIT");
        _exitButton.setForeground(Color.white);
        _exitButton.setBackground(Color.decode("#f21b3f"));
        _exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        _exitButton.addActionListener(lis);
        JPanel lButtonP = new JPanel();
        lButtonP.add(_exitButton, new GridLayout(1,1));

        // ******************* TITLE PANEL ****************
        JPanel titleP = new JPanel();

        titleP.add(lButtonP);
        titleP.add(_titleP);
        titleP.add(rButtonP);

        // ******************* MSG PANEL ****************

        _msgToUser = new JLabel("CLICK START");
        _msgToUser.setFont(new Font("Arial",   Font.BOLD, 50));
        _msgToUser.setForeground(Color.BLUE);
        _msgToUser.setAlignmentX(CENTER_ALIGNMENT);

        JPanel topP = new JPanel();
        topP.setLayout(new BoxLayout(topP, BoxLayout.Y_AXIS));
        topP.add(titleP);
        topP.add(_msgToUser);

        // ******************* GALLOW ****************
        _gallowPanel = new GallowPanel();

        // ******************* ABC BUTTONS ****************
        _abcPanel = new JPanel();
        for(int i=0 ; i < 26; i++) { // this loop builds the array list of letters buttons
            JButton letterButton = new  JButton(String.valueOf((char) (i + 65))); // create the button
            letterButton.setFont(new Font("Arial",   Font.BOLD, 20));
            letterButton.addActionListener(lis); // add listener to button
            letterButton.setEnabled(false);
            _lettersArr.add(letterButton); // add button to buttons list
            _abcPanel.add(letterButton);  // add button to abc panel

        }
        _abcPanel.setLayout(new GridLayout(10,4, 7,7));

        // ******************* MIDDLE PANEL ****************

        JPanel middleP = new JPanel();
        middleP.setLayout(new BoxLayout(middleP ,BoxLayout.LINE_AXIS));

        middleP.add(_abcPanel);
        middleP.add(_gallowPanel);


        // ******************* WORD BLANKS ****************

        _mysteryWordLabel = new JLabel("HELLO!");
        _mysteryWordLabel.setFont(new Font("Arial", Font.BOLD, 50));
        _mysteryWordLabel.setAlignmentX(CENTER_ALIGNMENT);


        // ******************* BOTTOM PANEL ****************
        JPanel bottomP = new JPanel();
        bottomP.setLayout(new BoxLayout(bottomP,BoxLayout.Y_AXIS));
        bottomP.add(_mysteryWordLabel);

        // ******************* ALL IN MAIN PANEL ****************
        setLayout(new BorderLayout());
        add(topP, BorderLayout.NORTH);
        add(middleP, BorderLayout.CENTER);
        add(bottomP, BorderLayout.SOUTH);
    }

    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton pressedButton = (JButton) e.getSource();
            int len = _lettersArr.size();

            if (pressedButton == _exitButton){            // ********** EXIT BUTTON ***********
                System.out.println("You chose to exit");
                System.exit(0);
            }
            else if (pressedButton == _startButton){     // ********** START BUTTON ***********
                String randWord = _wordStock.getRandomWord();
                _startButton.setText("PLAY AGAIN");
                _mistakesCount = 0;
                _gallowPanel.set_mistakes(_mistakesCount);
                _gallowPanel.repaint();


                System.out.println("DEBUG - the random word is: " + randWord); // generate new word from words list
                set_word( randWord); // generate new word from words list

                String mysteryWord = _word.getWordDisplay();
                _mysteryWordLabel.setText(mysteryWord);         // updates the word panel
                _mysteryWordLabel.setForeground(Color.BLACK);
                _msgToUser.setForeground(Color.decode(HAPPY_GREEN));

                _msgToUser.setText("GUESS A LETTER");
                blockLtrButtons(false ); // to unblock the letter buttons

            }

            else {  // ********** GUESS LETTER ***********
                for (int i = 0; i < len; i++) {
                    JButton tmpButton = _lettersArr.get(i);
                    if (pressedButton == tmpButton) {
                        tmpButton.setBackground(Color.CYAN);
                        tmpButton.setEnabled(false); // to block a single button
                        String letter = pressedButton.getText().toLowerCase();
                        System.out.println(letter);
                        boolean isLetterInWord = _word.tryLetter(letter);

                        if (isLetterInWord){   // ********** RIGHT GUESS  ***********
                            _word.updateWordBlanks(letter);

                            _msgToUser.setText("VERY GOOD! CONTINUE!");
                            _msgToUser.setForeground(Color.decode(HAPPY_GREEN));

                            String wordDisplay = _word.getWordDisplay();
                            System.out.println("DEBUG " + wordDisplay);
                            _mysteryWordLabel.setText(_word.getWordDisplay() );
                            if (! wordDisplay.contains("_")){
                                _msgToUser.setText("YOU ARE ALIVE!");
                                _msgToUser.setForeground(Color.decode(HAPPY_GREEN));

                                _mysteryWordLabel.setForeground(Color.decode(HAPPY_GREEN));
                                blockLtrButtons(true);
                            }
                        }
                        else {                 // ********** WRONG GUESS  ***********
                            _msgToUser.setText("WRONG! TRY AGAIN!");
                            _msgToUser.setForeground(Color.RED);

                            _mistakesCount++;
                            if (_mistakesCount == 6){
                                _gallowPanel.set_mistakes(_mistakesCount);
                                _gallowPanel.repaint();
                                _msgToUser.setText("YOU ARE DEAD!");
                                _msgToUser.setForeground(Color.RED);
                                _mysteryWordLabel.setForeground(Color.RED);
                                blockLtrButtons(true);
                            }
                            else {
                                _gallowPanel.set_mistakes(_mistakesCount);
                                _gallowPanel.repaint();
                                System.out.println("DEBUG - hang");

                            }
                        }
                    }

                }
            }

        }

    } // end ButtonListener class

    private void blockLtrButtons(boolean b) {
        int len = _lettersArr.size();
        for (int i = 0; i < len; i++) {
            JButton tmpButton = _lettersArr.get(i);
            tmpButton.setBackground(null);
            tmpButton.setEnabled(!b);
        }

    }
    public void addBodyPart(int mistakesCount) {
        switch (mistakesCount){
            case 1:
            case 2:

            case 3:
            case 4:
            case 5:
            case 6:
        }
    }

    public void set_word(String word) {
        this._word = new BlankWord(word);
    }


}
