/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.io.Serializable;

/**
 *
 * @author Roan Thu
 */
public abstract class Canh implements Serializable{
    private static final long serialVersionUID = 1L;	
    private int indexPointA, indexPointB;
	private int cost;
        private boolean isHide;
        private Color colorCost, colorLine;

    public Color getColorCost() {
        return colorCost;
    }

    public void setColorCost(Color colorCost) {
        this.colorCost = colorCost;
    }

    public Color getColorLine() {
        return colorLine;
    }

    public void setColorLine(Color colorLine) {
        this.colorLine = colorLine;
    }

    public boolean isIsHide() {
        return isHide;
    }

    public void setIsHide(boolean isHide) {
        this.isHide = isHide;
    }

	final int barb = 10;
	final int r = 15;
	final double phi = Math.PI / 6;

	public Canh( int indexPointA, int indexPointB, int cost) {
		this.cost = cost;
		this.indexPointA = indexPointA;
		this.indexPointB = indexPointB;
                this.isHide = false;
                colorLine = Color.white;
                colorCost = Color.white;
	}
        public abstract void drawLine(Graphics2D g, Point p1, Point p2, int size);
        public abstract boolean containerPoint(Point p);
        

	public int getIndexPointA() {
		return indexPointA;
	}

	public void setIndexPointA(int indexPointA) {
		this.indexPointA = indexPointA;
	}

	public int getIndexPointB() {
		return indexPointB;
	}

	public void setIndexPointB(int indexPointB) {
		this.indexPointB = indexPointB;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

    /**
     *
     * @param l
     */
    public abstract void setL(Line2D.Double l); 

    /**
     *
     * @param l
     */
    public abstract void setL(Shape l);
}
