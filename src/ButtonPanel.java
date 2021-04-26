import javax.swing.*;

public class ButtonPanel extends JPanel {

    public ButtonPanel() {
        int count = 0;
        JLabel labelCount = new JLabel("Click:" + count);
        JButton cmdPlus = new JButton("+");
        JButton cmdCancel = new JButton("Cancel");

        add(cmdPlus);
        add(cmdCancel);
        add(labelCount);
    }

}
