/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;

/**
 *
 * @author Roan Thu
 */
public class VeDoThi extends JPanel implements MouseListener, MouseMotionListener{
    public Data data, data2;
    private int x = 0, y = 0, r = 15, r2 = 2 * r; // ban kinh, duong kinh
    private int indexPointBeginLine, indexPointEndLine, indexTemp, indexPoint, indexLine;
    private Point pointBeginLine;
    private Point point, beginpointdrag;
    private Color colorBackGround = Color.lightGray, colorCost = Color.white,
			colorIndex = Color.black, colorDraw = Color.white;
    private int sizeLine = 1;
    boolean isFindPoint = true;
    float size = 5000f;
    private JScrollPane jc;

    public VeDoThi(int SoDinh, int SoCanh, JScrollPane jc) {
        data = new Data(SoDinh, SoCanh);
        this.jc = jc;
        addMouseMotionListener(this);
	addMouseListener(this);
    }
    public VeDoThi(int n, JScrollPane jc, boolean Torus) {
        data = new Data(n, Torus);
        this.jc = jc;
        addMouseMotionListener(this);
	addMouseListener(this);
    }   
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(colorBackGround);
		Graphics2D g2d = (Graphics2D) g;
		reDraw(g2d);
	}
    @Override
    public void mouseClicked(MouseEvent e) {
        point = e.getPoint();
        indexPoint = indexPointContain(point);
        if(indexPointContain(point) >= 0){
            ThongTin Inf = new ThongTin(this, indexPoint);
            Inf.setVisible(true);
        }
        else{
            indexLine = indexLineContain(point);
            if(indexLineContain(point) >= 0){
                (new ThongTinCanh(this, indexLine)).setVisible(true);
            }
        }
    }
         

    @Override
    public void mousePressed(MouseEvent e) {
        pointBeginLine = e.getPoint();
	point = e.getPoint();
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isFindPoint = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (isFindPoint) {
            indexPointBeginLine = indexPointContain(pointBeginLine);
		if (indexPointBeginLine >= 0) {
                    isFindPoint = false;
                    }
	}
        if (indexPointBeginLine >= 0) {
            int dx = e.getX() - point.x;
            int dy = e.getY() - point.y;
             //System.out.println(dx+","+dy);

	// move point
            Ellipse2D.Float el = data.getArrNut().get(indexPointBeginLine).getEl();
                el.x += dx;
		el.y += dy;
		data.getArrNut().get(indexPointBeginLine).setEl(el);
                float tyleX =  data.getArrNut().get(indexPointBeginLine).getTyleX();
                float tyleY =  data.getArrNut().get(indexPointBeginLine).getTyleY();
                data.getArrNut().get(indexPointBeginLine).setTyleX(tyleX*(el.x/(el.x-dx)));
                data.getArrNut().get(indexPointBeginLine).setTyleY(tyleY*(el.y/(el.y-dy)));
			updateLine();
			repaint();
			point.x += dx;
			point.y += dy;
        }
        else{
            int dx = e.getX() - point.x;
            int dy = e.getY() - point.y;
            Point p = jc.getViewport().getViewPosition();
            if(p.x - dx >= 0 && p.y - dy < 0) jc.getViewport().setViewPosition(new Point(p.x - dx, 0));
            else if(p.x - dx < 0 &&p.y - dy >= 0) jc.getViewport().setViewPosition(new Point(0, p.y - dy));
            else if(p.x - dx >= 0 &&p.y - dy >= 0) jc.getViewport().setViewPosition(new Point(p.x - dx,  p.y - dy));
                    
        }
    }
    public void updateLine() { // update location line after move point
		for (int i = 0; i < data.getArrCanh().size(); i++) {
                    
                    if(data.getArrCanh().get(i) instanceof Line)
			data.getArrCanh()
					.get(i)
					.setL(creatLine(
							data.getArrNut()
									.get(data.getArrCanh().get(i)
											.getIndexPointA()).getP(),
							data.getArrNut()
									.get(data.getArrCanh().get(i)
											.getIndexPointB()).getP()));
                    else {data.getArrCanh()
					.get(i)
					.setL(creatLine2D(
							data.getArrNut()
									.get(data.getArrCanh().get(i)
											.getIndexPointA()).getP(),
							data.getArrNut()
									.get(data.getArrCanh().get(i)
											.getIndexPointB()).getP()));
                       // System.out.println(data.getArrNut().get(data.getArrCanh().get(i).getIndexPointA()).getIndex()+","+
			//				data.getArrNut().get(data.getArrCanh().get(i).getIndexPointB()).getIndex());
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
    //Tim dinh
    protected int indexPointContain(Point point) {
		for (int i = 0; i < data.getArrNut().size(); i++) {
			if (data.getArrNut().get(i).getEl().getBounds2D()
					.contains(point)) {
				return i;
			}
		}
		return -1;
	}
    //Tim canh
    protected int indexLineContain(Point point){
        for(int i = 0; i < data.getArrCanh().size(); i++){
		if (data.getArrCanh().get(i).containerPoint(point)){
                    return i;
                }
        }
        return -1;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    private void reDraw(Graphics2D g2d) {
		//resetGraph(g2d);
		for (int i = 0; i < data.getArrCanh().size(); i++) {
                    if(data.getArrCanh().get(i).isIsHide() == false)
			data.getArrCanh()
					.get(i)
					.drawLine(g2d,data.getArrNut()
						.get(data.getArrCanh().get(i)
							.getIndexPointA()).getP(),
						data.getArrNut()
							.get(data.getArrCanh().get(i)
								.getIndexPointB()).getP(),
                                                                         sizeLine);
		}

		// draw point
		for (int i = 0; i < data.getArrNut().size(); i++) {
			data.getArrNut().get(i).draw(g2d, colorIndex);
		}
	}
    public void readFile(String name) throws ClassNotFoundException {
        Data data = null;
        data = new Data();
        try {
            FileReader f = new FileReader(name);
            Scanner str = new Scanner(f);
            try {
                 data.setTyle(str.nextFloat());
                 String s = str.nextLine();
            s = str.nextLine();
            while(!s.equals("-1")){
                String[] word = s.split(" ");
                for(int i = 0; i < word.length; i++){
                if(word[i].startsWith("\"")&&word[i].endsWith("\""))
                    word[i] = word[i].substring(1, word[i].length()-1);
            }  
                Ellipse2D.Float el = new Ellipse2D.Float(Float.parseFloat(word[1]),Float.parseFloat(word[2]), r2*data.getTyle(), r2*data.getTyle());
                Nut p = new Nut(el, word[0], word[3], word[4], word[5], word[6]);
                p.setTyleX(p.getTyleX()/data.getTyle());
                p.setTyleY(p.getTyleY()/data.getTyle());
                data.getArrNut().add(p);
                s = str.nextLine();
            }
            s = str.nextLine();
            if(s.equals("1")) data.setTorus(true);
            else data.setTorus(false);
            int[][] a = new int[data.getArrNut().size()][data.getArrNut().size()];
            for(int i = 0; i < data.getArrNut().size(); i++){
                for(int j = 0; j < data.getArrNut().size(); j++){
                    try {
                         a[i][j] = str.nextInt();
                    } catch (java.util.NoSuchElementException e) {
                        JOptionPane.showMessageDialog(null, "File đầu vào chưa đúng");
                        break;
                    }
                   
                }
            }
            convertMatrixToData(a, data);
            f.close();
            this.data = data;
            repaint();
            } catch (java.util.InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "File đầu vào chưa đúng");
            }
           
            
        } catch (IOException e) {
            System.out.println("Loi");
        }
    }
    public void writeFile(String name){
        try {
            FileWriter f = new FileWriter(name);
            //ObjectOutputStream oStream = new ObjectOutputStream(f);
            //oStream.writeObject(data);
            //oStream.close();
            f.write(data.getTyle()+"\n");
            for(int i = 0; i < data.getArrNut().size(); i++){
                Point p =data.getArrNut().get(i).getP();
                String a = data.getArrNut().get(i).getA();
                String b = data.getArrNut().get(i).getB();
                String c = data.getArrNut().get(i).getC();
                String d = data.getArrNut().get(i).getD();
                f.write(data.getArrNut().get(i).getIndex()+" "+p.x+" "+p.y+" \""+a+"\" \""+b+"\" \""+c+"\" \""+d+"\"\n");
                f.flush();
            }
            f.write("-1\n");
            if(data.isTorus()) f.write("1\n");
            else f.write("\n");
            f.write("\n");
            int[][] a = DataToMatrix();
            for(int i = 0; i < data.getArrNut().size(); i++){
                for(int j = 0; j < data.getArrNut().size(); j++){
                    f.write(a[i][j]+" ");
                }
                f.write("\n");
            }
            f.close();
            JOptionPane.showMessageDialog(null, "Save success", "Save success",
					JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Save", "Error save file",
            JOptionPane.OK_OPTION);
            System.out.println("Error save file\n" + e.toString());
	}
    }
    public int[][] DataToMatrix() {
	int size = data.getArrNut().size();
	int[][] a = new int[size][size];
	for (int i = 0; i < data.getArrCanh().size(); i++) {
            a[data.getArrCanh().get(i).getIndexPointA()][data.getArrCanh().get(i)
				.getIndexPointB()] = data.getArrCanh().get(i).getCost();
            a[data.getArrCanh().get(i).getIndexPointB()][data.getArrCanh().get(i)
				.getIndexPointA()] = data.getArrCanh().get(i).getCost();
            }
        return a;
	}
    public void convertMatrixToData(int[][] a, Data data) {
	for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
		if (a[i][j] > 0) {
                    if(data.isTorus() == true){
                        int n = (int) Math.sqrt(a.length);
                        if((j==a.length-n+i||(i%n==0&&j==i+n-1))){
                        Shape arc = creatLine2D(data.getArrNut().get(i).getP(), data.getArrNut().get(j).getP());
                        Canh e3 = new Canh2D(arc, i, j,a[i][j]);
                        data.getArrCanh().add(e3);
                        continue;
                        }                        
                    }
                    data.getArrCanh()
                            .add(new Line(creatLine(
					data.getArrNut().get(i).getP(),
						data.getArrNut().get(j).getP()),
								i, j, a[i][j]));
                    
		}
	    }
	}
	}
}



