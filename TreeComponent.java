import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

public class TreeComponent extends JPanel
{
    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 400;

    private final double ANGLE = Math.PI/3;
    private final double RAND = 1/5;
    
    private final int TOPX = 200, TOPY = 20;
    private final int LEFTX = 60, LEFTY = 300;
    private final int RIGHTX = 340, RIGHTY = 300;

    private int current; //current order

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public TreeComponent (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.white);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractal (int order, int x, int y, int endX, int endY, int length, Graphics page)
    {
        Graphics2D g2 = (Graphics2D) page;

        if (order == 1)
        {
            return
        }
        else
        {
            
        }
    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    @Override
    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        page.setColor (Color.green);

        drawFractal (current, TOPX, TOPY, LEFTX, LEFTY, page);
        drawFractal (current, LEFTX, LEFTY, RIGHTX, RIGHTY, page);
        drawFractal (current, RIGHTX, RIGHTY, TOPX, TOPY, page);
    }

    //-----------------------------------------------------------------
    //  Sets the fractal order to the value specified.
    //-----------------------------------------------------------------
    public void setOrder (int order)
    {
        current = order;
    }

    //-----------------------------------------------------------------
    //  Returns the current order.
    //-----------------------------------------------------------------
    public int getOrder ()
    {
        return current;
    }
}
