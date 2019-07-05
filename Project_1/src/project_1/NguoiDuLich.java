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
 * @author Roan Thu
 */
public class NguoiDuLich {
    private int a[][];
    int min;
    private int infinity , size ;
    private int[] len, M, L;
    private ArrayList<Nut> arrNut = new ArrayList<Nut>();
    private ArrayList<Canh> arrCanh = new ArrayList<Canh>();
    private boolean[] checkedPointMin;

    public NguoiDuLich(ArrayList<Nut> arrNut, ArrayList<Canh> arrCanh) {
        this.arrNut = arrNut;
        this.arrCanh = arrCanh;
        input();
        processInput();
        initValue();
        Try(1);
        path();
    }
    
    public void input() {
        infinity = 1;
	size = arrNut.size();
        System.out.println(size);
	a = new int[size][size];
        len = new int[size];
        M = new int[size + 1];
        L = new int[size];
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
		if (a[i][j] == 0) {
                    a[i][j] = infinity;
		}
            }
	}
    }
    private void initValue() {
        checkedPointMin = new boolean[size];
	for (int i = 0; i < size; i++) {
            checkedPointMin[i] = false;
	}
	len[0] = 0;
        L[0] = 0;
        checkedPointMin[0] = true;
        min = infinity;        
    }
    void Try(int u){
	int i, j;
	for(i = 1; i < size; i++){
		if(checkedPointMin[i] == false && a[L[u-1]][i] < infinity){
			L[u] = i;
			len[u] = len[u - 1] + a[L[u-1]][i];
			if(u == (size - 1)){
				if(len[u] + a[L[u]][0]< min) {
					for(j = 0; j < size; j++){
						M[j] = L[j];  
					}
                                        M[u+1] = 0;
                                        System.out.println(len[u]+","+a[L[u]][0]);
				    min = len[u] + a[L[u]][0];
			    }
			}
			else {
				if(len[u] + (size-i+1)*1  < min){
			    	checkedPointMin[i] = true;
			    	Try(u+1);
			    	checkedPointMin[i] = false;
			    }
			}
		}
	}
    }
    public void path(){
        System.out.println(min +","+infinity);
        if(min < infinity){
            for(int i = 0; i < arrNut.size(); i++){
                arrNut.get(i).setColorPoint(Color.white);
            }
        for(int i = 0; i < arrCanh.size(); i++){
            arrCanh.get(i).setIsHide(false);
            arrCanh.get(i).setColorCost(Color.white);
            arrCanh.get(i).setColorLine(Color.white);
            int a = arrCanh.get(i).getIndexPointA();
            int b = arrCanh.get(i).getIndexPointB();
            for(int j = 0; j < arrNut.size(); j++){
                arrNut.get(j).setColorPoint(Color.red);
                if((M[j+1] == a&& M[j] == b) || (M[j+1] == b&& M[j] == a)){
                    arrCanh.get(i).setColorCost(Color.red);
                    arrCanh.get(i).setColorLine(Color.red);
                    break;
                }
                
            }
        }
        }
        else JOptionPane.showMessageDialog(null, "Không có đường đi");
    }
    
}
