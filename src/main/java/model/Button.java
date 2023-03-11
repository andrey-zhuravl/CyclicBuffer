package model;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button implements MouseListener {
    Double x, y, w, h, alpha, centerX, centerY;
    Rectangle rect = new Rectangle();
    Rectangle r = new Rectangle();
    String name;
    BufferImage bufferImage = null;
    private Color color;

    public Button (Double x, Double y, Double w, Double h, String name) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        rect.setRect(x,y,w,h);
        this.name = name;
        color = Color.CYAN;
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        r.setRect(e.getX(), e.getY(), 1.0, 1.0);
        if(rect.intersects(r)){
            if(name.equals("push")){
            this.bufferImage.push();
            }
            if(name.equals("pop")){
                this.bufferImage.pop();
            }
        }
    }

    @Override
    public void mousePressed (MouseEvent e) {

    }

    @Override
    public void mouseReleased (MouseEvent e) {

    }

    @Override
    public void mouseEntered (MouseEvent e) {

    }

    @Override
    public void mouseExited (MouseEvent e) {

    }

    public void setBuffer (BufferImage bufferImage) {
        this.bufferImage = bufferImage;
    }

    public void draw (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(this.color);
        rect.setRect(x-w/2, y-h/2, w, h);
        g2d.fill(rect);
        g2d.setColor(Color.BLACK);
        g2d.draw(g2d.getStroke().createStrokedShape(rect));
    }
}
