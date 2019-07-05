/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.dnd.MouseDragGestureRecognizer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.TransferHandler;
import javax.swing.border.Border;

/**
 *
 * @author Roan Thu
 */
public class GiaoDienChinh extends javax.swing.JFrame{

    /**
     * Creates new form GiaoDienChinh
     */
    VeDoThi graph;
    float size;
    public GiaoDienChinh() {
        initComponents();        
        jPanel1.setBackground(Color.lightGray);
        
        graph = new VeDoThi(0, 0,jScrollPane1);
        graph.setSize(5000, 5000);
        graph.setBounds(jPanel1.getX(), jPanel1.getY(), jPanel1.getHeight(), jPanel1.getWidth());
        graph.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel1.add(graph);
        jRadioButton2D.setSelected(true);
        stenable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButtonRefesh = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        beginPoint = new javax.swing.JTextField();
        endPoint = new javax.swing.JTextField();
        jButtonDijsktra = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtonNguoiDuLich = new javax.swing.JButton();
        jTextField2D = new javax.swing.JTextField();
        jButton2D = new javax.swing.JButton();
        jRadioButton2D = new javax.swing.JRadioButton();
        jRadioButton2DTorus = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vẽ Graph");

        jPanel1.setPreferredSize(new java.awt.Dimension(5000, 5000));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5000, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jLabel1.setText("Số đỉnh");

        jLabel2.setText("Số cạnh");

        jButton1.setText("Vẽ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Các cạnh chứa đỉnh");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setText("Tìm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonRefesh.setText("Refesh");
        jButtonRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefeshActionPerformed(evt);
            }
        });

        jLabel4.setText("Dijsktra:");

        jLabel5.setText("Đỉnh đầu");

        jLabel6.setText("Đỉnh cuối");

        beginPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginPointActionPerformed(evt);
            }
        });

        jButtonDijsktra.setText("Tìm");
        jButtonDijsktra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDijsktraActionPerformed(evt);
            }
        });

        jLabel7.setText("Người du lịch:");

        jButtonNguoiDuLich.setText("Tìm");
        jButtonNguoiDuLich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNguoiDuLichActionPerformed(evt);
            }
        });

        jButton2D.setText("Vẽ");
        jButton2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2DActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2D);
        jRadioButton2D.setText("2D");
        jRadioButton2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2DActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2DTorus);
        jRadioButton2DTorus.setText("2D Torus");

        jMenu1.setText("File");

        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exit");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNguoiDuLich))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2D)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2D))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButtonRefesh))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                    .addComponent(jTextField2)))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonDijsktra)
                                    .addComponent(endPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(beginPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton2D)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jRadioButton2DTorus)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2D)
                            .addComponent(jRadioButton2DTorus, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2D)
                            .addComponent(jTextField2D, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(beginPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDijsktra)
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jButtonNguoiDuLich))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(jButtonRefesh))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    private int findIndex(String index){
        for(int i = 0; i < graph.data.getArrNut().size(); i++){
            if(graph.data.getArrNut().get(i).getIndex().equalsIgnoreCase(index))
                return i;
        }
        JOptionPane.showMessageDialog(null, "Không có đỉnh "+index);
        return -1;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
           int SoDinh = Integer.parseInt(jTextField1.getText());
           int SoCanh = Integer.parseInt(jTextField2.getText());
           if(SoCanh > (SoDinh)*(SoDinh-1)/2){
               JOptionPane.showMessageDialog(null, "Số cạnh quá lớn");
           }
           else{
           jPanel1.remove(graph);
           jPanel1.setSize(5000, 5000);
           jPanel1.setPreferredSize(new Dimension(5000, 5000));
           jScrollPane1.setViewportView(jPanel1);
           jScrollPane1.getViewport().setViewPosition(new Point(0, 0));
           graph = new VeDoThi(SoDinh, SoCanh,jScrollPane1);
           graph.setBounds(jPanel1.getX(), jPanel1.getY(), jPanel1.getHeight(), jPanel1.getWidth());
           graph.setCursor(new Cursor(Cursor.HAND_CURSOR));
            //System.out.println(jPanel1.getHeight());
           jPanel1.add(graph);
           size = 5000f;
           stenable(true);
           repaint();
           }
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lỗi nhập");
        }
        Zoom();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            int Dinh = findIndex(jTextField3.getText());
            if(Dinh >= 0){
            refresh();
            for(int i = 0; i < graph.data.getArrCanh().size(); i++){
                int a = graph.data.getArrCanh().get(i).getIndexPointA();
                int b = graph.data.getArrCanh().get(i).getIndexPointB();
                if(a != Dinh && b != Dinh)
                    graph.data.getArrCanh().get(i).setIsHide(true);
                else graph.data.getArrCanh().get(i).setIsHide(false);
            }
            graph.repaint();
            jButtonRefesh.setEnabled(true);
            }     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setSize(700, 600);
        int value = fc.showOpenDialog(this);
        if(value == JFileChooser.OPEN_DIALOG){
            String name = fc.getSelectedFile().getPath();
            try {
                graph.readFile(name);
                graph.setSize((int)(5000*graph.data.getTyle()),(int) (graph.data.getTyle()*5000));  
                jScrollPane1.getViewport().setViewPosition(new Point(0, 0));
                size = graph.getHeight();
                System.out.println(size);

                Zoom();
                stenable(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
                
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Save graph");
		int select = fc.showSaveDialog(this);
		if (select == 0) {
			String path = fc.getSelectedFile().getPath();  
			graph.writeFile(path);
		}
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void refresh(){
        for(int i = 0; i < graph.data.getArrCanh().size(); i++){
            graph.data.getArrCanh().get(i).setColorCost(Color.white);
            graph.data.getArrCanh().get(i).setColorLine(Color.white);
             graph.data.getArrCanh().get(i).setIsHide(false);
        }
        for(int i = 0; i < graph.data.getArrNut().size(); i++){
            graph.data.getArrNut().get(i).setColorPoint(Color.white);
        }
        graph.repaint();

    }
    private void jButtonRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefeshActionPerformed
        refresh();
    }//GEN-LAST:event_jButtonRefeshActionPerformed

    private void beginPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginPointActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_beginPointActionPerformed

    private void jButtonDijsktraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDijsktraActionPerformed
            int begin = findIndex(beginPoint.getText());
            int end = -1;
            if(begin >= 0)
                end = findIndex(endPoint.getText());
            if(begin >= 0&&end >= 0){
                Dijsktra ds = new Dijsktra(graph.data.getArrNut(),graph.data.getArrCanh(), begin, end);
                repaint();
            }         
        
    }//GEN-LAST:event_jButtonDijsktraActionPerformed

    private void jButtonNguoiDuLichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNguoiDuLichActionPerformed
        NguoiDuLich dl =new NguoiDuLich(graph.data.getArrNut(),graph.data.getArrCanh());
        graph.repaint();
    }//GEN-LAST:event_jButtonNguoiDuLichActionPerformed

    private void jButton2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2DActionPerformed
        try {
           int n = Integer.parseInt(jTextField2D.getText());
           jPanel1.remove(graph);
           jPanel1.setSize(5000, 5000);
           jPanel1.setPreferredSize(new Dimension(5000, 5000));
           jScrollPane1.setViewportView(jPanel1);
           jScrollPane1.getViewport().setViewPosition(new Point(0, 0));
           if(jRadioButton2D.isSelected()) graph = new VeDoThi(n,jScrollPane1, false);
           if(jRadioButton2DTorus.isSelected()) graph = new VeDoThi(n,jScrollPane1, true);
           graph.setBounds(jPanel1.getX(), jPanel1.getY(), jPanel1.getHeight(), jPanel1.getWidth());
           graph.setCursor(new Cursor(Cursor.HAND_CURSOR));
           jPanel1.add(graph);
           size = 5000f;
           stenable(true);
           repaint();
           
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lỗi nhập");
        }
        Zoom();
    }//GEN-LAST:event_jButton2DActionPerformed

    private void jRadioButton2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2DActionPerformed
    private int inArrCanh(int a, int b){
        for(int i = 0; i < graph.data.getArrCanh().size(); i++){
            int A = graph.data.getArrCanh().get(i).getIndexPointA();
            int B = graph.data.getArrCanh().get(i).getIndexPointB();
            if((a == A && b == B) || (a == B)&&(b == A)) return i;
        }
        return -1;
    }
    private void Zoom(){
        graph.addMouseWheelListener(new MouseWheelListener() {
            
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                Point p1 = new Point(jScrollPane1.getViewport().getViewPosition());
                Point p2 = new Point(e.getX(), e.getY()); 
                Point p3;
                int x = p2.x - p1.x;
                int y = p2.y - p1.y;
                int no = e.getUnitsToScroll();
            if(no > 0){
                size = (float) (size*0.95);
                float tl = graph.data.getTyle();
                graph.data.setTyle((float) (0.95*tl));
                p3 = new Point((int)(0.95*(p1.x + x)), (int)(0.95*(p1.y + y)));
                graph.setSize((int)size,(int) size);
                jPanel1.setPreferredSize(new Dimension((int)size, (int)size));
                for(int i = 0; i < graph.data.getArrNut().size();i++){
                    float tyleX = graph.data.getArrNut().get(i).getTyleX();
                    float tyleY = graph.data.getArrNut().get(i).getTyleY();
                    float r = (float) (graph.data.getArrNut().get(i).getR()*0.95);
                    graph.data.getArrNut().get(i).setR(r);
                    Ellipse2D.Float el = new Ellipse2D.Float((int)(tyleX*size), (int)(tyleY*size), 2*(int)r, 2*(int)r);
                    graph.data.getArrNut().get(i).setEl(el);
                    
                }
               graph.updateLine();
            }
            else {
                size = (int) (size/0.95);
                
                float tl = graph.data.getTyle();
                graph.data.setTyle((float) (tl/0.95));
                p3 = new Point((int)((p1.x + x)/0.95), (int)((p1.y + y)/0.95));
                graph.setSize((int)size, (int)size);
                jPanel1.setPreferredSize(new Dimension((int)size, (int)size));
                for(int i = 0; i < graph.data.getArrNut().size();i++){
                    float tyleX = graph.data.getArrNut().get(i).getTyleX();
                    float tyleY = graph.data.getArrNut().get(i).getTyleY();
                    float r = (float) ((graph.data.getArrNut().get(i).getR())/0.95);
                    //System.out.println(r);
                    graph.data.getArrNut().get(i).setR(r);
                    
                    Ellipse2D.Float el = new Ellipse2D.Float((int)(tyleX*size), (int)(tyleY*size), 2*(int)r, 2*(int)r);
                    graph.data.getArrNut().get(i).setEl(el);
                    //graph.data.getArrNut().get(i).set
                }
               graph.updateLine();
                
            }
            jScrollPane1.setViewportView(jPanel1);
            Point p4 = null ;
            if(p3.x-x<0&& p3.y-y<0)
                p4 = new Point(0, 0);
            else if(p3.x-x<0&&p3.y-y>=0) p4 = new Point(0, p3.y-y);
            else if(p3.x-x>=0&&p3.y-y<0) p4 = new Point(p3.x-x, 0);
            else p4 = new Point(p3.x-x, p3.y-y);
            jScrollPane1.getViewport().setViewPosition(p4);
            
            }
        });
    }  
    public void stenable(boolean what){
        jButton2.setEnabled(what);
        jTextField3.setEnabled(what);
        jButtonRefesh.setEnabled(what);
        beginPoint.setEnabled(what);
        endPoint.setEnabled(what);
        jButtonDijsktra.setEnabled(what);
        jButtonNguoiDuLich.setEnabled(what);
    }
    /**
     * @param args the command line arguments
     * 
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField beginPoint;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField endPoint;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton2D;
    private javax.swing.JButton jButtonDijsktra;
    private javax.swing.JButton jButtonNguoiDuLich;
    private javax.swing.JButton jButtonRefesh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton2D;
    private javax.swing.JRadioButton jRadioButton2DTorus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField2D;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

}