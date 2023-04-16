import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

public class TreeComponent extends JPanel
{
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 800;

    private final double INITIAL_ANGLE = Math.PI / 2;
    private final double INITIAL_X = 400;
    private final double INITIAL_Y = 700;
    private final double INITIAL_LENGTH = 220;
    private final double CHANGE_IN_ANGLE = Math.PI / 8;
    private final double PERCENT_CHANGE_IN_LENGTH = .75;

    private final Color BLUE = new Color(101, 152, 244);
    private final Color LIGHT_BLUE = new Color(181, 212, 222);
    private final Color DARK_BLUE = new Color(16, 75, 141);
    private final int BLUE_INDICATOR = 1;
    private final int LIGHT_BLUE_INDICATOR = 2;
    private final int DARK_BLUE_INDICATOR = 3;

    private int current; //current order

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public TreeComponent (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.BLACK);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractal (double x, double y, double angle, double length, Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        if (length < 1)
        {
            return;
        }
        else
        {
            if(length < 220)
            {
                int rand = (int) (Math.random() * 3) + 1;
                if(rand == BLUE_INDICATOR)
                {
                    g.setColor(BLUE);
                }
                else if(rand == LIGHT_BLUE_INDICATOR)
                {
                    g.setColor(LIGHT_BLUE);
                }
                else if(rand == DARK_BLUE_INDICATOR)
                {
                    g.setColor(DARK_BLUE);
                }
            }

            double newLength;
            newLength = length * PERCENT_CHANGE_IN_LENGTH;

            double dx, dy;
            dx = x + (newLength * Math.cos(angle));
            dy = y - (newLength * Math.sin(angle));

            Line2D.Double line = new Line2D.Double(x, y, dx, dy);
            g2.draw(line);

            drawFractal(dx, dy, angle - CHANGE_IN_ANGLE, newLength, g);
            drawFractal(dx, dy, angle + CHANGE_IN_ANGLE, newLength, g);
        }
    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent (g);
        g.setColor(Color.WHITE);
        drawFractal(INITIAL_X, INITIAL_Y, INITIAL_ANGLE, INITIAL_LENGTH, g);
    }
}