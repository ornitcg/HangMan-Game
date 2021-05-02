import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GallowPanel extends JPanel {
    private int _mistakes;

    public void set_mistakes(int _mistakes) {
        this._mistakes = _mistakes;
    }

    protected void paintComponent(Graphics g) {
        int x = 70;
        int y = 70;
        int width = 20;
        int height = 500;
        int xpoints[] = {x - 20 , x - 3 ,  x + 87 , x +70};
        int ypoints[] = {y + 100, y + 115, y + 15,  y };
        int npoints = 4;
        super.paintComponent(g);
        g.setColor(Color.decode("#5E503F"));
        g.fillRect(x,y ,width ,height );  // draw vertical part of gallow
        g.fillRect(x - width ,y +  width ,(int) (height * 0.6) ,width ); // draw horizontal part of gallow
        g.fillPolygon(xpoints , ypoints, npoints); // draw diagonal part of gallow
        int ropeWidth = 4;

        g.fillRect(x + 200 + (int)(ropeWidth/2) , y +20 , ropeWidth, (int) (height * 0.2) ); // draw rope

        int headDiameter = 50;
        if (_mistakes > 0) {
            g.setColor(Color.decode("#CB997E"));
            g.fillOval(x + 200 - (int)(headDiameter/2) + ropeWidth, y + 20 + (int) (height * 0.2), headDiameter, headDiameter);
        }
        int bodyX = x + 200;
        int bodyY = y + 20 + (int) (height * 0.2) + headDiameter;
        int bodyH = headDiameter * 2;
        int bodyW = 10;
        if (_mistakes > 1) {
            g.fillRect(bodyX, bodyY, bodyW, bodyH);
        }
        ((Graphics2D)g).setStroke(new BasicStroke(5));

        if (_mistakes > 2) // draw right arm
            g.drawLine(bodyX + bodyW ,bodyY,bodyX + headDiameter +bodyW , bodyY+headDiameter );
        if (_mistakes > 3) // draw left arm
            g.drawLine(bodyX,bodyY,bodyX - headDiameter , bodyY+headDiameter );

        bodyY += bodyH;
        if (_mistakes > 4)//draw right leg
            g.drawLine(bodyX + bodyW ,bodyY,bodyX + headDiameter+bodyW , bodyY+headDiameter );
        if (_mistakes > 5)//draw left leg
            g.drawLine(bodyX,bodyY,bodyX - headDiameter, bodyY+headDiameter );

    }



}
