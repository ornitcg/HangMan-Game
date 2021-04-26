import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AbcPanel extends JPanel {
    final int ABC_NUM = 26;
    private JButton[]  lettersArr = new JButton[ABC_NUM];


    public AbcPanel(){
        char ltrLbl;
        String lblStr;


        for(int i=0; i<ABC_NUM; i++) {
            ltrLbl = (char) (i+65);
            lblStr = String.valueOf(ltrLbl);
            lettersArr[i] = new JButton(lblStr);
            add(lettersArr[i]);
        }
        this.setLayout(new GridLayout(11,0, 5,5));

    }

}
