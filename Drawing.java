import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Drawing extends JPanel implements MouseMotionListener, MouseListener {

    int mx, my;

    Graphics g;

    BufferedImage offscreen;
    Graphics offscreen_g;

    int x, y, z, q;

    boolean isInk = false, isPencil = false, isErasing = false;

    Line r1;
    Circle c1;

    public Drawing() {

        offscreen = new BufferedImage(1000,700,BufferedImage.TYPE_4BYTE_ABGR_PRE);
        offscreen_g = offscreen.getGraphics();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    public void drawCircle(int w, int h)
    {
        c1 = new Circle(x,y,w,h);

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        int nx = e.getX();
        int ny = e.getY();

       //  int dx = nx - mx;
       // int dy = ny - my;

        x = nx;
        y = ny;

        if(isInk) {
            c1.setStartPosition(x,y);
            c1.draw(offscreen_g);
        }

        if(isPencil) {
//            int size = 4;
//            offscreen_g.setColor(Color.BLUE);
//            offscreen_g.fillRect(x,y,size,size);
//            offscreen_g.drawRect(x, y, size,size);
            offscreen_g.drawLine(x,y,z,q);
        }

        if(isErasing)
        {
            c1.setStartPosition(x,y);
            c1.erasedraw(offscreen_g);
        }

        z = x;
        q = y;

        mx = nx;
        my = ny;

        //repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mx = e.getX();
        my = e.getY();

        x = mx;
        y = my;

        //c1.setStartPosition(x,y);
        //c1.draw(g);
        offscreen_g = getGraphics();

        z = x;
        q = y;

        //repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
}
