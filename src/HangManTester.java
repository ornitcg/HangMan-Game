import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class HangManTester {

    public static void main(String[] args) throws IOException {
        JFrame frame =  new JFrame("Hang Man");
        System.out.println("Enter file or directory name for words list");
        Scanner input = new Scanner(System.in);  // get input from user
        String filePath = input.nextLine();
        WordStock wordStock = new WordStock(filePath);



        int width = 1000;
        int height = 1000;



     //   String word = wordStock.getRandomWord();
        MainPanel2 mainPanel = new MainPanel2(width, height, "word"); // later change to wrd vatiable
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);

        frame.setSize(1000,1000);
        mainPanel.setLayout(boxLayout);

        frame.setResizable(false);
        frame.add(mainPanel);


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // the option to close the window
        frame.setVisible(true); //make the whole thing show on screen


    }

    private static void buildWordStock() {
    }


}
