import javax.swing.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class HangManTester {

    public static void main(String[] args) throws IOException {
        JFrame frame =  new JFrame("Hang Man");
        Scanner input = new Scanner(Paths.get("words.txt"));
        WordStock wordStock = new WordStock(input);


        int width = 1000;
        int height = 1000;



        String word = wordStock.getRandomWord();
        MainPanel mainPanel = new MainPanel(width, height, word);
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);

        frame.setSize(1000,1000);
        mainPanel.setLayout(boxLayout);

        frame.setResizable(false);
        frame.add(mainPanel);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // the option to close the window
        frame.setVisible(true); //make the whole thing show on screen


    }



}
