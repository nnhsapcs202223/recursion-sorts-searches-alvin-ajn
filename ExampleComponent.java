import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;
/**
 * Fractal Tree Lab
 *
 * @author TDebnath06
 * @version (a version number or a date)
 */
public class ExampleComponent extends JPanel
{
    private final int WIDTH = 800;
    private final int HEIGHT = 800;
    private int branchLength = 100;
    private double startX = 400.0;
    private double startY = 750.0;
    private final double ANGLE = 90.0;
    
    private int current;
    public ExampleComponent(int currentOrder, int branchSize)
    {
        current = currentOrder;
        branchLength = branchSize;
        setBackground (Color.black);
        setPreferredSize (new Dimension(WIDTH, HEIGHT));
    }

    public void drawFractalTree(double x, double y, double angle, double length, Graphics g) 
    {
        Graphics2D g2 = (Graphics2D) g;
        double deltaX;
        double deltaY;
        if (length < 5)
        {
            return;
        }
        else {
            if(length >= 33)
            {
                g.setColor(Color.CYAN);
            }
            else if (length >= 16)
            {
                g.setColor(Color.MAGENTA);
            }
            else
            {
                g.setColor(Color.BLUE);
            }
            deltaX = x + (Math.cos(Math.toRadians(angle))*length);
            deltaY = y - (Math.sin(Math.toRadians(angle))*length);
            
            Line2D.Double line = new Line2D.Double(x,y, deltaX, deltaY);
            g2.draw(line);
            
            drawFractalTree(deltaX, deltaY, angle - 20, length*0.8, g);
            drawFractalTree(deltaX, deltaY, angle + 20, length*0.8, g);
        }
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        drawFractalTree(startX, startY, ANGLE, branchLength, g);
    }
} 