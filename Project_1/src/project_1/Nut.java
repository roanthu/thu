/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 *
 * @author Roan Thu
 */
public class Nut implements Serializable{
    private Ellipse2D.Float el = new Ellipse2D.Float();
    private Point p = new Point();
    private String index;
    private float tyleX, tyleY;
    private Color colorPoint;

    public Color getColorPoint() {
        return colorPoint;
    }

    public void setColorPoint(Color colorPoint) {
        this.colorPoint = colorPoint;
    }
    public void setTyleX(float tyleX) {
        this.tyleX = tyleX;
    }

    public void setTyleY(float tyleY) {
        this.tyleY = tyleY;
    }

    public float getTyleY() {
        return tyleY;
    }

    public float getTyleX() {
        return tyleX;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
    private float r;

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
    private String A; 
    private String B;
    private String C;
    private String D;

    public String getA() {
        return A;
    }

    public void setA(String A) {
        this.A = A;
    }

    public String getB() {
        return B;
    }

    public void setB(String B) {
        this.B = B;
    }

    public String getC() {
        return C;
    }

    public void setC(String C) {
        this.C = C;
    }

    public String getD() {
        return D;
    }

    public void setD(String D) {
        this.D = D;
    }
    public void drawIndex(Graphics2D g, Color colorIndex) {
	g.setColor(colorIndex);
	int stringLen = (int) g.getFontMetrics()
				.getStringBounds(String.valueOf(index), g).getWidth();
	int stringHeight = (int) g.getFontMetrics()
				.getStringBounds(String.valueOf(index), g).getHeight();
	int startX = -stringLen / 2;
	int startY = stringHeight / 2;
	g.drawString(index, startX + (int) p.x, (int) p.y
				+ startY);
        Font f = new Font("Aria", Font.BOLD, (int) r);
        g.setFont(f);
	}
    public void drawPoint(Graphics2D g) {
	g.setColor(colorPoint);
	g.fill(el);
    }
    public void draw(Graphics2D g, Color colorIndex) {
	drawPoint(g);
	drawIndex(g, colorIndex);
    }

    public Ellipse2D.Float getEl() {
	return el;
    }

    public void setEl(Ellipse2D.Float el) {
	this.el = el;
	this.p.x = (int) (el.x + r);
	this.p.y = (int) (el.y + r);
    }

    public Point getP() {
	return p;
    }

    public void setP(Point p) {
	this.p = p;
    }

    public Nut(Ellipse2D.Float el,String index, String A, String B, String C, String D) {
        r = el.height/2;
	setEl(el);
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.index = index;
        this.tyleX = el.x/5000;
        this.tyleY = el.y/5000;
        this.colorPoint = Color.white;
    }
}
