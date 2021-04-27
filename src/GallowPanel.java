import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class GallowPanel extends JPanel {
    private Shape _bodyParts[] = new Shape[6];


    protected void paintComponent(Graphics g) {
        int x = 70;
        int y = 70;
        int width = 20;
        int height = 400;
        int xpoints[] = {x - 20 , x - 3 ,  x + 87 , x +70};
        int ypoints[] = {y + 100, y + 115, y + 15,  y };
        int npoints = 4;
        super.paintComponent(g);
        g.setColor(Color.decode("#5E503F"));
        g.fillRect(x,y ,width ,height );
        g.fillRect(x - width ,y +  width ,(int) (height * 0.6) ,width );
        g.fillPolygon(xpoints , ypoints, npoints);
        g.fillRect(x + 200 , y +20 ,5, (int) (height * 0.2) );

    }



}
