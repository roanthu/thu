/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Roan Thu cc
 */
public class Dijsktra {
    private int a[][];
    private int[] len, p;
    private int[][] logLen, logP;
    private int infinity , size ;
    private boolean[] checkedPointMin; // diem co duong di ngan nhat (da xet)
    private ArrayList<Nut> arrNut = new ArrayList<Nut>();
    private ArrayList<Canh> arrCanh = new ArrayList<Canh>();
    private int beginPoint , endPoint;
    private int numberPointChecked = 0;

    public Dijsktra(ArrayList<Nut> arrNut, ArrayList<Canh> arrCanh, int beginPoint, int endPoint) {
        this.arrCanh = arrCanh;
        this.arrNut = arrNut;
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
        this.input();
        this.processInput();
        this.dijkstra();
        this.path();
    }
    
    public void input() {
	infinity = 1;
	size = arrNut.size();
	a = new int[size][size];
	len = new int[size];
	p = new int[size];
	checkedPointMin = new boolean[size];

	for (int i = 0; i < arrCanh.size(); i++) {
            a[arrCanh.get(i).getIndexPointA()][arrCanh.get(i)
				.getIndexPointB()] = arrCanh.get(i).getCost();
            a[arrCanh.get(i).getIndexPointB()][arrCanh.get(i)
				.getIndexPointA()] = arrCanh.get(i).getCost();
            infinity += arrCanh.get(i).getCost();
            }
	}
    public void processInput() {
	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
		if (a[i][j] == 0 && i != j) {
                    a[i][j] = infinity;
		}
            }
	}
    }
    private void initValue() {
        logLen = new int[size][size];
	logP = new int[size][size];
        checkedPointMin = new boolean[size];
	// processInput();
	for (int i = 0; i < size; i++) {
            len[i] = infinity;
            checkedPointMin[i] = false;
            p[i] = 0;
	}
	logLen[0] = len;
        logP[0] = p;
	len[beginPoint] = 0;
    }
    public int dijkstra() {
	initValue();
	int i = 1, k = 0;
	// for (int k = 1; k < size; k++) {
	while (checkContinue(k)) {
            for (i = 0; i < size; i++){
             
		if (!checkedPointMin[i] && len[i] < infinity)
		break;}
		if (i >= size){
                    break;
                }
		
		for (int j = 0; j < size; j++){
                    if (!checkedPointMin[j] && len[i] > len[j])
			i = j;}
                checkedPointMin[i] = true;
		for (int j = 0; j < size; j++) {

                    if (!checkedPointMin[j] && len[i] + a[i][j] < len[j]) {
			len[j] = len[i] + a[i][j];
			p[j] = i;
                    }
                    logLen[k][j] = len[j];
                    logP[k][j] = p[j];
            }
		k++;
	}
	numberPointChecked = k;
	return len[endPoint];
	}
    public void path(){
        //System.out.println(beginPoint +"," +endPoint +"," + len[endPoint] +"," +infinity);
        if(beginPoint >= 0&&endPoint >= 0&& len[endPoint] < infinity){
            for(int i = 0; i < arrNut.size(); i++){
                arrNut.get(i).setColorPoint(Color.white);
            }
        for(int i = 0; i < arrCanh.size(); i++){
            arrCanh.get(i).setIsHide(false);
            arrCanh.get(i).setColorCost(Color.white);
            arrCanh.get(i).setColorLine(Color.white);
            
            int j = endPoint;
            arrNut.get(endPoint).setColorPoint(Color.red);
            int a = arrCanh.get(i).getIndexPointA();
            int b = arrCanh.get(i).getIndexPointB();
            while(j != beginPoint){
                if((j == a&& p[j] == b) || (j == b&& p[j] == a)){
                    arrCanh.get(i).setColorCost(Color.red);
                    arrCanh.get(i).setColorLine(Color.red);
                   // arrCanh.get(i).setIsHide(false);
                    
                    j = p[j];
                    break;
                }
                j = p[j];
                arrNut.get(j).setColorPoint(Color.red);
            }
        }
        }
        else JOptionPane.showMessageDialog(null, "Không có đường đi");
    }
    private boolean checkContinue(int k) {
	if (endPoint != -1) {
            return (!checkedPointMin[endPoint]);
		}
	return (k < arrNut.size() - 1);
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public int[] getLen() {
        return len;
    }

    public void setLen(int[] len) {
        this.len = len;
    }

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }

    public int[][] getLogLen() {
        return logLen;
    }

    public void setLogLen(int[][] logLen) {
        this.logLen = logLen;
    }

    public int[][] getLogP() {
        return logP;
    }

    public void setLogP(int[][] logP) {
        this.logP = logP;
    }

    public int getInfinity() {
        return infinity;
    }

    public void setInfinity(int infinity) {
        this.infinity = infinity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean[] getCheckedPointMin() {
        return checkedPointMin;
    }

    public void setCheckedPointMin(boolean[] checkedPointMin) {
        this.checkedPointMin = checkedPointMin;
    }

    public ArrayList<Nut> getarrNut() {
        return arrNut;
    }

    public void setarrNut(ArrayList<Nut> arrNut) {
        this.arrNut = arrNut;
    }

    public ArrayList<Canh> getarrCanh() {
        return arrCanh;
    }

    public void setarrCanh(ArrayList<Canh> arrCanh) {
        this.arrCanh = arrCanh;
    }

    public int getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(int beginPoint) {
        this.beginPoint = beginPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }


    public int getNumberPointChecked() {
        return numberPointChecked;
    }

    public void setNumberPointChecked(int numberPointChecked) {
        this.numberPointChecked = numberPointChecked;
    }
}
