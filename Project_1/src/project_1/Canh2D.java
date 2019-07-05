/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.io.Serializable;

/**
 *
 * @author Roan Thu
 */
public class Canh2D extends Canh implements Serializable{
    final int barb = 10;
	final int r = 15;
	final double phi = Math.PI / 6;

    public Shape getL() {
        return l;
    }

    @Override
    public void setL(Shape l) {
        this.l = l;
    }
        Shape l;
	public Canh2D(Shape l,int indexPointA,int indexPointB,int cost) {
            super(indexPointA, indexPointB, cost);
            this.l = l;
	}

    @Override
    public void drawLine(Graphics2D g, Point p1, Point p2, int size) {
        AffineTransform at = new AffineTransform();
                double theta = Math.atan2(p2.y - p1.y, p2.x - p1.x);
                double theta2 = Math.PI/2 -theta;
                double d = Math.sqrt(Math.pow(p2.y - p1.y,2)+Math.pow( p2.x - p1.x, 2));
                g.setColor(super.getColorLine());
                at.rotate(theta, p1.x , p1.y);
                Arc2D.Double arc = new Arc2D.Double(p1.x, p1.y + d*0.2, d, d*0.4, 0, 180, 0);
                g.draw(l);
                g.setColor(super.getColorCost());
                String c = String.valueOf(super.getCost());
                //System.out.println(Math.toDegrees(theta));
		g.drawString(c, (int) (Math.abs(p1.x + p2.x + d*0.2*Math.sin(theta)) / 2 ), (int) ((int) (p1.y + p2.y - d *0.2*Math.cos(theta)) / 2));
    }

    @Override
    public boolean containerPoint(Point p) {
        if(l.contains(p.x, p.y,5, 5)) return true;
        return false;
    } 

    @Override
    public void setL(Line2D.Double l) {
    }
    
}
