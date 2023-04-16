import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class ExampleViewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ExampleViewer
{
     private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private ExampleComponent drawing;
    private JFrame frame;
    private JPanel panel;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        ExampleViewer viewer = new ExampleViewer();
    }

    public  ExampleViewer()
    {
        //panel = new JPanel();
        frame = new JFrame();
        drawing = new ExampleComponent(1, 100);
        //panel.add(drawing);
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(drawing);
        //frame.add(panel)
        frame.setVisible(true);
    }

}