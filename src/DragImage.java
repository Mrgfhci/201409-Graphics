
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DragImage extends JComponent
        implements MouseMotionListener {
    static int nW = 60, nH = 60;
    int nGrid = 10;
    int nX, nY;
    Image imgZappa;

    public DragImage(Image _imgZappa) {
        imgZappa = _imgZappa;
        addMouseMotionListener(this);
    }
    public void mouseDragged(MouseEvent e) {
        nX = e.getX();
        nY = e.getY();
        repaint();
    }
    public void mouseMoved(MouseEvent e) {
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imgZappa, nX, nY, this);
    }
    public static void main(String[] args) {
        String sImageFile = "Zappa1.jpg";
        Image imgZappa = Toolkit.getDefaultToolkit().getImage(
        DragImage.class.getResource(sImageFile));
        imgZappa = imgZappa.getScaledInstance(nW, nH, Image.SCALE_DEFAULT);
        JFrame frame = new JFrame("DragImage");
        frame.getContentPane().add(new DragImage(imgZappa));
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
