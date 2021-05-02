import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class HangManTester {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter file or directory name for words list");
        Scanner input = new Scanner(System.in);  // get input from user
        String filePath = input.nextLine();

        JFrame frame =  new JFrame("Hang Man");
        int frameWidth = 1000;
        int frameHeight = 1000;
        frame.setSize(1000,1000);
        MainPanel mainPanel = new MainPanel( filePath); // later change to word variable

        frame.setResizable(false);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // the option to close the window
        frame.setVisible(true); //make the whole thing show on screen

        input.close();
    }


}
