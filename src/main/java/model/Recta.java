package model;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.UUID;

public class Recta {
    Double x, y, w, h, alpha, centerX, centerY;
    Rectangle rect = new Rectangle();
    public AffineTransform transform = new AffineTransform();
    private Color color = Color.RED;
    private String name;

    public Recta () {
        this.x = 0.0;
        this.y = 0.0;
        this.w = 0.0;
        this.h = 0.0;
        this.alpha = 0.0;
        this.centerX = 400.0;
        this.centerY = 400.0;
    }

    public Recta (Double x, Double y, Double w, Double h, Double alpha, Double cX, Double cY) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.alpha = alpha;
        this.centerX = cX;
        this.centerY = cY;
    }

    public Recta (int x, int y, int w, int h, Double alpha, Double cX, Double cY) {
        this.x = Integer.valueOf(x).doubleValue();
        this.y = Integer.valueOf(y).doubleValue();
        this.w = Integer.valueOf(w).doubleValue();
        this.h = Integer.valueOf(h).doubleValue();
        this.alpha = alpha;
        this.centerX = cX;
        this.centerY = cY;
        this.name = UUID.randomUUID().toString();
    }

    void draw (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.rotate(Math.toRadians(alpha), centerX, centerY);
        g2d.setColor(this.color);
        rect.setRect(x-w/2, y-h/2, w, h);
        //g2d.draw(rect);
        g2d.fill(rect);
        g2d.setColor(Color.BLACK);
        g2d.draw(g2d.getStroke().createStrokedShape(rect));
        g2d.rotate(Math.toRadians(-alpha), centerX, centerY);
    }

    public boolean intersects (Rectangle eventRect) {
        rect.setRect(x-w/2, y-h/2, w, h);
        transform.setToRotation(Math.toRadians(alpha), centerX, centerY);
        boolean t = transform.createTransformedShape(rect).intersects(eventRect);
        return t;
    }

    public int getX () {
        return x.intValue();
    }

    public void setX (Double x) {
        this.x = x;
    }

    public int getY () {
        return y.intValue();
    }

    public void setY (Double y) {
        this.y = y;
    }

    public int getW () {
        return w.intValue();
    }

    public void setW (Double w) {
        this.w = w;
    }

    public int getH () {
        return h.intValue();
    }

    public void setH (Double h) {
        this.h = h;
    }

    public int getAlpha () {
        return alpha.intValue();
    }

    public void setAlpha (Double alpha) {
        this.alpha = alpha;
    }

    public void setColor (Color blue) {
        this.color = blue;
    }

    public void changeColor () {
        if (this.color.getRGB() == Color.BLUE.getRGB()){
            this.color = Color.RED;
        }else {
            this.color = Color.BLUE;
        }
    }

    public String name () {
        return this.name;
    }
}
