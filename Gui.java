import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame
{

    Drawing drw = new Drawing();


    JPanel canvas = new JPanel();

    public Gui()
    {
        setTitle("Draw Frame");
        setSize(650,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        prepareCanvas();
    }

    public void prepareCanvas()
    {
        JLabel name = new JLabel("Created By: Norberto Studios");
        canvas.setLayout(null);
        canvas.setBounds(50,0,600,600);
        canvas.setBackground(Color.LIGHT_GRAY);
        name.setBounds(300,520,200,50);

        toolsPanel();
        //drawPanel();

        drw.setLayout(null);
        drw.setBackground(Color.WHITE);
        drw.setBounds(100,30,500,500);

        canvas.add(name);
        canvas.add(drw);
        add(canvas);
    }

    public void toolsPanel()
    {
        JPanel toolPanel = new JPanel();

        JLabel toolTitle = new JLabel("  Tools");

        JButton pencilBtn = new JButton("Pencil");
        JButton inkBtn = new JButton("Ink");
        JButton eraseBtn = new JButton("Erase");
        JButton clearBtn = new JButton("Clear");

        toolPanel.setLayout(null);
        toolPanel.setBounds(0,0,50,600);
        toolPanel.setBackground(new Color(168, 202, 255));

        toolTitle.setBounds(0,10,50,20);
        pencilBtn.setBounds(0,100,50,100);
        inkBtn.setBounds(0,200,50,100);
        eraseBtn.setBounds(0,300,50,100);
        clearBtn.setBounds(0,400,50,100);

        drw.isPencil = true;

        pencilBtn.addActionListener((actionEvent)-> {
            System.out.println("Pencil");
            drw.isPencil = true;
            drw.isInk = false;
            drw.isErasing = false;
        });
        inkBtn.addActionListener((actionEvent)-> {
            System.out.println("Ink");
            drw.drawCircle(10,10);
            drw.isInk = true;
            drw.isPencil = false;
            drw.isErasing = false;
        });
        eraseBtn.addActionListener((actionEvent)-> {
            drw.drawCircle(30,30);
            drw.isInk = false;
            drw.isPencil = false;
            drw.isErasing = true;
        });
        clearBtn.addActionListener((actionEvent)-> repaint());

        toolPanel.add(toolTitle);
        toolPanel.add(pencilBtn);
        toolPanel.add(inkBtn);
        toolPanel.add(eraseBtn);
        toolPanel.add(clearBtn);

        canvas.add(toolPanel);

    }

    public void drawPanel()
    {
        JPanel drawPanel = new JPanel();

        drawPanel.setLayout(null);
        drawPanel.setBounds(100,10,150,150);
        drawPanel.setBackground(Color.WHITE);

        canvas.add(drawPanel);

    }


}
