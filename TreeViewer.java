import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TreeViewer
{
    private final int WIDTH = 800;
    private final int HEIGHT = 800;

    private final int MIN = 1, MAX = 16;

    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    private TreeComponent drawing;
    private JPanel panel, tools;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }

    public TreeViewer()
    {
        frame = new JFrame();
        drawing = new TreeComponent(16);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(drawing);
        frame.setVisible(true);
    }

}