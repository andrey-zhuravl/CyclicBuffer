package model;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scena extends JPanel implements ActionListener, MouseListener, MouseMotionListener {


    Timer timer = new Timer(30, this);
    List<Recta> rectList = new ArrayList<Recta>();
    BufferImage bufferImage;
    Button push = new Button(400.0, 700.0, 30.0, 30.0, "push");

    Button pop = new Button(700.0, 700.0, 30.0, 30.0, "pop");

    public Scena () throws IOException {
        super();
        init();
    }

    private void init () throws IOException {

        bufferImage = new BufferImage();
        timer.start();
        push.setBuffer(bufferImage);
        pop.setBuffer(bufferImage);
        addMouseListener(this);
        addMouseListener(push);
        addMouseListener(pop);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent (Graphics g) {
        //отрисовка всех объектов
        bufferImage.draw(g);
        push.draw(g);
        pop.draw(g);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        repaint();
    }

    ////////////////////////////////////////////////
    /////////////// MOUSE LISTENER  ////////////////
    @Override
    public void mouseClicked (MouseEvent e) {
        bufferImage.mouseClicked(e);
    }

    @Override
    public void mousePressed (MouseEvent e) {
        bufferImage.mouseClicked(e);
    }

    @Override
    public void mouseReleased (MouseEvent e) {

    }

    @Override
    public void mouseEntered (MouseEvent e) {
        //bufferImage.mouseClicked(e);
    }

    @Override
    public void mouseExited (MouseEvent e) {
        //bufferImage.mouseClicked(e);
    }

    @Override
    public void mouseDragged (MouseEvent e) {
        //bufferImage.mouseClicked(e);
    }

    @Override
    public void mouseMoved (MouseEvent e) {
        //bufferImage.mouseClicked(e);
    }
    /////////////// MOUSE LISTENER  ////////////////
    ////////////////////////////////////////////////
}
