import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MainPanel2 extends JPanel {
    private TopPanel _topPanel;
    private MidPanel _midPanel;
    private BottomPanel _bottomPanel;
    private String _word;



    public MainPanel2(int width, int height, String word){
        _topPanel = new TopPanel(width,height,"HANG MAN GAME");
        _topPanel.setBorder(new LineBorder(Color.BLACK));
        _topPanel.setPreferredSize(new Dimension(width,(int)(height * 0.1)));


        _midPanel = new MidPanel(width,height);
        BoxLayout boxLayout = new BoxLayout(_midPanel, BoxLayout.X_AXIS);
        _midPanel.setPreferredSize(new Dimension(width,(int)(height * 0.7)));
        _midPanel.setLayout(boxLayout);

        _word = new String(word);
        GameWord gameWord = new GameWord(_word);
        _bottomPanel = new BottomPanel(width,height, gameWord);
        _bottomPanel.setBorder(new LineBorder(Color.BLACK));
        _bottomPanel.setPreferredSize(new Dimension(width,(int)(height * 0.2)));

        add(_topPanel);
        add(_midPanel);
        add(_bottomPanel);

    }
}
