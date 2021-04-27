
import javax.swing.*;
import javax.swing.border.LineBorder;
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

    private JLabel _mysteryWord;
    private JLabel _msgToUser;

//    private BlankWord _word;
    private GallowPanel _gallowPanel;
    private JPanel _abcPanel;

    private JPanel _titleP = new JPanel();
    private WordStock _wordStock;

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
        _msgToUser.setFont(new Font("Arial",   Font.BOLD, 40));
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

        _mysteryWord = new JLabel("HELLO!");
        _mysteryWord.setFont(new Font("Arial", Font.BOLD, 50));
        _mysteryWord.setAlignmentX(CENTER_ALIGNMENT);


        // ******************* BOTTOM PANEL ****************
        JPanel bottomP = new JPanel();
        bottomP.setLayout(new BoxLayout(bottomP,BoxLayout.Y_AXIS));
        bottomP.add(_mysteryWord);

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

            if (pressedButton == _exitButton){
                System.out.println("You chose to exit");
                System.exit(0);
            }
            else if (pressedButton == _startButton){
                BlankWord word = new BlankWord(_wordStock.getRandomWord()); // generate new word from words list
                String mysteryWord = word.get_wordDisplay();
                _mysteryWord.setText(mysteryWord);
                _msgToUser.setText("GUESS A LETTER");
                for (int i = 0; i < len; i++) {
                    JButton tmpButton = _lettersArr.get(i);
                    tmpButton.setBackground(null);
                    tmpButton.setEnabled(true);
                }
            }

            else {
                for (int i = 0; i < len; i++) {
                    JButton tmpButton = _lettersArr.get(i);
                    if (pressedButton == tmpButton) {
                        tmpButton.setBackground(Color.CYAN);
                        tmpButton.setEnabled(false);

//                        word.tryLetter(pressedButton.getText().charAt(0));
                    }

                }
            }

        }

    }


}
