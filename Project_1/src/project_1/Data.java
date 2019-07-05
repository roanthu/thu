/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.shape.Arc;

/**
 *
 * @author Roan Thu
 */
public class Data implements Serializable{
    private int[][] a;
    private ArrayList<Nut> arrNut;
    private ArrayList<Canh> arrCanh;
    final private int r = 15, r2 = 30;
    private float tyle;
    boolean Torus;

    public boolean isTorus() {
        return Torus;
    }

    public void setTorus(boolean Torus) {
        this.Torus = Torus;
    }

    public float getTyle() {
        return tyle;
    }

    public void setTyle(float tyle) {
        this.tyle = tyle;
    }
    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public ArrayList<Nut> getArrNut() {
        return arrNut;
    }

    public void setArrNut(ArrayList<Nut> arrNut) {
        this.arrNut = arrNut;
    }

    public ArrayList<Canh> getArrCanh() {
        return arrCanh;
    }

    public void setArrCanh(ArrayList<Canh> arrCanh) {
        this.arrCanh = arrCanh;
    }

    public Data() {
        this.arrNut = new ArrayList<>();
        this.arrCanh = new ArrayList<>();
    }
    
    public Data(int SoDinh, int SoCanh) {
        
        tyle = 1;
        this.arrNut = new ArrayList<>();
        this.arrCanh = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < SoDinh; i++) {
            int x, y; 
            if(SoDinh < 400){
            
            x = rd.nextInt(1000);
            y = rd.nextInt(1000);}
            else {
                if(SoDinh >= 400 && SoDinh < 2000){
                    x = rd.nextInt(2200);
                    y = rd.nextInt(2200);
                }
                else{
                 x = rd.nextInt((int) (50*Math.sqrt(SoDinh)));
                 y =  rd.nextInt((int) (50*Math.sqrt(SoDinh)));
                }
            }
            Ellipse2D.Float el = new Ellipse2D.Float(x, y, r2, r2);
            int a = rd.nextInt(100);
            int b = rd.nextInt(100);
            int c = rd.nextInt(100);
            int d = rd.nextInt(100);
            Nut e = new Nut(el, String.valueOf(i), String.valueOf(a), String.valueOf(b), String.valueOf(c), String.valueOf(d));
            arrNut.add(e);
	}
        int count = 0;
        while(count < SoCanh){
            int a = rd.nextInt(SoDinh); int b = rd.nextInt(SoDinh);
            if(a == b || inArrCanh(a, b)) continue;
            else{
                Line2D.Double l = creatLine(arrNut.get(a).getP(), arrNut.get(b).getP());
                Canh e = new Line(l, a, b,1 + rd.nextInt(200));
                arrCanh.add(e); 
                count++;
            }
            
        }
    }
    public Data(int n,boolean Torus){
        tyle = 1;
        this.arrNut = new ArrayList<>();
        this.arrCanh = new ArrayList<>();
        Random rd = new Random();
         for (int i = 0; i < n; i++) {
             int x = 0;
             int y = i*100 +100;
             for(int j = 0; j < n; j++){
                x = 100 + 100*j;
                Ellipse2D.Float el = new Ellipse2D.Float(x, y, r2, r2);
            int a = rd.nextInt(100);
            int b = rd.nextInt(100);
            int c = rd.nextInt(100);
            int d = rd.nextInt(100);
            Nut e = new Nut(el, String.valueOf(i*n+j), String.valueOf(a), String.valueOf(b), String.valueOf(c), String.valueOf(d));
            arrNut.add(e);
             }
	}
        this.Torus = Torus;
        for(int i = 0; i < n; i++){
            if(Torus == true){
            Shape arc = creatLine2D(arrNut.get( i).getP(), arrNut.get(n*(n-1) + i).getP());
                Canh e3 = new Canh2D(arc, i, n*(n-1) +i,1 + rd.nextInt(200));
                arrCanh.add(e3);
            Shape arc2 = creatLine2D(arrNut.get(i*n).getP(), arrNut.get((i+1)*n-1).getP());
                Canh e4 = new Canh2D(arc2, i*n, (i+1)*n-1,1 + rd.nextInt(200));
                arrCanh.add(e4);
            }
            for(int j = 0; j < n -1; j++){
                Line2D.Double l = creatLine(arrNut.get(i*n + j).getP(), arrNut.get(i*n + j+1).getP());
                Canh e = new Line(l, i*n + j, i*n + j+1,1 + rd.nextInt(200));
                arrCanh.add(e);
                
                Line2D.Double l2 = creatLine(arrNut.get(j*n+i).getP(), arrNut.get(j*n+n+i).getP());
                Canh e2 = new Line(l2, j*n+i, j*n+n+i,1 + rd.nextInt(200));
                arrCanh.add(e2);
            }
        } 
    }
    private Line2D.Double creatLine(Point p1, Point p2) {
		Line2D.Double l = new Line2D.Double(p1.x, p1.y, p2.x, p2.y);
		return l;
	}
    private Shape creatLine2D(Point p1, Point p2){
        AffineTransform at = new AffineTransform();
        double theta = Math.atan2(p2.y - p1.y, p2.x - p1.x);
        double theta2 = Math.PI/2 -theta;
        double d = Math.sqrt(Math.pow(p2.y - p1.y,2)+Math.pow( p2.x - p1.x, 2));
        at.rotate(theta, p1.x , p1.y);
        
        Arc2D.Double l = new Arc2D.Double(p1.x, (p1.y - d*0.1), d, d*0.2, 0, 180, 0);
        Shape arc2 = at.createTransformedShape(l);        
        return arc2;
    }
    
    private boolean inArrCanh(int a, int b){
        for(int i = 0; i < arrCanh.size(); i++){
            int A = arrCanh.get(i).getIndexPointA();
            int B = arrCanh.get(i).getIndexPointB();
            if((a == A && b == B) || (a == B)&&(b == A)) return true;
        }
        return false;
    }
}
