import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MidPanel extends JPanel {

    public MidPanel(int width, int height){
        HangPanel hangPanel = new HangPanel();

        hangPanel.setBorder(new LineBorder(Color.BLACK));
        hangPanel.setPreferredSize(new Dimension((int)(width * 0.5), 0));

        AbcPanel abcPanel = new AbcPanel();
        abcPanel.setBorder(new LineBorder(Color.BLACK));
        abcPanel.setPreferredSize(new Dimension((int)(width * 0.5), 0));

        add(hangPanel);
        add(abcPanel);


    }
}
