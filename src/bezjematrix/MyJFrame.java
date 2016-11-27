/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bezjematrix;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.util.Pair;

/**
 *
 * @author RK00448
 */
// TODO сделать драггинг точек
// TODO refacor
// TODO dragging points
// TODO support more points
// TODO REFACTOR-REFACTOR-REFACTOR
public class MyJFrame extends javax.swing.JFrame {

    private List<Point> vertices;
    private Set<Point> points;
    private Graphics graphic;
    private int offsetX;
    private int offsetY;
    private int pWidth;
    private int pHeight;
    private static float stepT=0.001f;
    boolean dragging=false;
    private Map<Integer,Long> factorialCache = new HashMap<Integer,Long>();
    private Map<Pair<Integer,Integer>, Double> polinomCache = new HashMap<>();
    private DrawThread drawThread;
    private boolean drawMode=false;
    private Set<Point> objekts;
    private boolean recalculateCurve=false;
    private final static int SPEED_COEFFICIENT=5;
    
    public MyJFrame() {
        initComponents();
        
        // Инициализируем свои обьекты       
        vertices = new ArrayList<>();
        points = new LinkedHashSet<>();
        objekts = new HashSet<>();
        // TODO лучше динамично определять, на случай ресайза
        graphic = mCanvasPanel.getGraphics();
        pWidth=mCanvasPanel.getWidth();
        pHeight=mCanvasPanel.getHeight();
        offsetX = pWidth/2;
        offsetY = pHeight/2;        
        
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mDrawButton = new javax.swing.JButton();
        mCanvasPanel = new javax.swing.JPanel();
        xTf = new javax.swing.JTextField();
        xLabel = new javax.swing.JLabel();
        yTf = new javax.swing.JTextField();
        yLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        mStepTTf = new javax.swing.JTextField();
        tLabel = new javax.swing.JLabel();
        redrawBtn = new javax.swing.JButton();
        cancelBtn1 = new javax.swing.JButton();
        drawModeCb = new javax.swing.JCheckBox();
        moveBtn = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));

        mDrawButton.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 14)); // NOI18N
        mDrawButton.setText("Add Point");
        mDrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDrawButtonActionPerformed(evt);
            }
        });

        mCanvasPanel.setBackground(new java.awt.Color(255, 255, 255));
        mCanvasPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mCanvasPanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mCanvasPanelMouseMoved(evt);
            }
        });
        mCanvasPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mCanvasPanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mCanvasPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mCanvasPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout mCanvasPanelLayout = new javax.swing.GroupLayout(mCanvasPanel);
        mCanvasPanel.setLayout(mCanvasPanelLayout);
        mCanvasPanelLayout.setHorizontalGroup(
            mCanvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        mCanvasPanelLayout.setVerticalGroup(
            mCanvasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        xLabel.setText("X:");

        yLabel.setText("Y:");

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        mStepTTf.setText("0.001");

        tLabel.setText("t:");

        redrawBtn.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 14)); // NOI18N
        redrawBtn.setText("Redraw");
        redrawBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redrawBtnActionPerformed(evt);
            }
        });

        cancelBtn1.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 14)); // NOI18N
        cancelBtn1.setText("Cancel");
        cancelBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn1ActionPerformed(evt);
            }
        });

        drawModeCb.setText("Draw Mode");
        drawModeCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawModeCbActionPerformed(evt);
            }
        });

        moveBtn.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 14)); // NOI18N
        moveBtn.setText("Move");
        moveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mCanvasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(mDrawButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(xLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xTf, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yTf, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mStepTTf, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(redrawBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(drawModeCb)
                            .addComponent(moveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(xTf)
                                .addComponent(xLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mStepTTf))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(yLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(yTf)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mDrawButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(drawModeCb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moveBtn)
                        .addGap(28, 28, 28)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(redrawBtn)
                            .addComponent(cancelBtn1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                    .addComponent(mCanvasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void drawScene(){
        killDrawThread();       
        
        
        System.out.println("drawscene");
        // erase everything
        graphic.setColor(Color.white);
        graphic.fillRect(0,0,pWidth,pHeight);         
        
        drawAxis();
        drawControlPoints();
        
        drawThread= new DrawThread(0,1f);
        drawThread.start();
        
    }
    
    private void drawAxis(){
        // uzzimet koordinatu asis
        graphic.setColor(Color.black);       
        graphic.drawLine(0, offsetY, pWidth, offsetY);
        graphic.drawLine(offsetX,0, offsetX, pHeight);                   
    }
    
    private void drawControlPoints(){
        int i=0;
        graphic.setColor(Color.RED);
        for(Point p:vertices){            
            // рисуем точку и её номер
            graphic.drawString((i++)+"", p.x+offsetX,offsetY-p.y-6);
            graphic.drawOval(p.x+offsetX,offsetY-p.y,3,3);
        }
    }
    
    private void drawObject(Collection<Point> points){
        for(Point p:points){
            graphic.drawLine(p.x, p.y, p.x, p.y);
        }
    }
    
    private void mDrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDrawButtonActionPerformed
        // TODO add your handling code here:
        // get user input     
        int x=Integer.parseInt(xTf.getText());
        int y=Integer.parseInt(yTf.getText());        
        stepT=Float.parseFloat(mStepTTf.getText());      
        Point p = new Point(x,y);
        vertices.add(p);
        
        
        recalculateCurve=true;
        drawScene();
    }//GEN-LAST:event_mDrawButtonActionPerformed
  
    private void mCanvasPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseClicked
        // TODO add your handling code here:        
        if(!drawMode){
            int x=evt.getX()-offsetX;
            int y=-evt.getY()+offsetY;
            stepT=Float.parseFloat(mStepTTf.getText());   
            vertices.add(new Point(x,y));
            this.recalculateCurve=true;
            drawScene();
        }
    }//GEN-LAST:event_mCanvasPanelMouseClicked
       
    private void bezierCurvePixel(float t){
        // TODO dynamically increase precision if there is a gap between Y or X
        
        int point_count=vertices.size();

        float sumX=0;
        float sumY=0;      
        
        int x,y;
        
        for(int i=0;i<point_count;i++){
            double polinoms= getPolinom(point_count-1,t,i);
            sumX+=polinoms*vertices.get(i).x;
            sumY+=polinoms*vertices.get(i).y;
        }
        
        x=(int)Math.round(sumX);
        y=(int)Math.round(sumY);             
        
        // добавить точку на координатах панели в set (гарантирует уникальность через equals())
        // также при перерисовке мы не будем заново их пересчитывать     
        points.add(new Point(x+offsetX,offsetY-y));
    }   
    
    /** Dabūt skaitla {@code a} faktorialu
     @param a skaitlis, kuram mes aprēkinām faktoriālu*/
    private long fact(int a){
        Long rez = factorialCache.get(a);
        if(rez==null){
            // считаем факториал и добавляем в кэш
            rez=1L;
            for(int i=1;i<=a;i++){
                rez*=i;
            }
            factorialCache.put(a, rez);
        }
        return rez;
    }
    
    /** Kalkulēt Bernšteina polinomu
     @param n polinomu pakāpe (n=N-1), kur N - punktu daudzums
     @param t līknes parametrs (0<t<1)
     @param i punkta numurs */
    private double getPolinom(int n,float t,int i){
        Pair pair = new Pair(n,i);
        // достаём константную част полинома ( без Т) из кэша
        Double part = polinomCache.get(pair);
        if(part==null){
            polinomCache.put(pair,countSomething(n,i));
            return getPolinom(n,t,i);
        }else{
            part*=Math.pow(1-t,n-i)*Math.pow(t,i);
        }
        return part;
    }
    
    /** считаем константную часть полинома (без Т) 
    методом сокращений больших факториалов */
    private double countSomething(int n, int i){
        i = Math.max(i,n-i);   
        // сократить на больший факториал и поделить на меньший
        return getReverseFact(n,i)/fact(n-i);
    }
    
    private int getReverseFact(int n,int i){    
        int rez=1;
        for(int j = n;j>i;j--)  {
            rez*=j;
        }
        return rez;
    }
    
    private void mCanvasPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_mCanvasPanelMouseReleased

    private void mCanvasPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMousePressed
        
    }//GEN-LAST:event_mCanvasPanelMousePressed
    
    private void mCanvasPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseDragged
        // TODO add your handling code here:
        if(drawMode){
            int x=evt.getX();
            int y=evt.getY();
            objekts.add(new Point(x,y));     
            graphic.setColor(Color.BLUE);
            graphic.drawLine(x,y,x,y);
        }        
    }//GEN-LAST:event_mCanvasPanelMouseDragged

    private void redrawBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redrawBtnActionPerformed
        recalculateCurve=true;
        stepT=Float.parseFloat(mStepTTf.getText());
        drawScene();
    }//GEN-LAST:event_redrawBtnActionPerformed

    private void mCanvasPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_mCanvasPanelMouseMoved

    private void cancelBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn1ActionPerformed
       killDrawThread();
    }//GEN-LAST:event_cancelBtn1ActionPerformed

    private void drawModeCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawModeCbActionPerformed
        // TODO add your handling code here:
        drawMode=!drawMode;
    }//GEN-LAST:event_drawModeCbActionPerformed

    private void moveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveBtnActionPerformed
        // TODO add your handling code here:
        
        Runnable r = new Runnable(){
            @Override
            public void run() {
                moveBtn.setEnabled(false);
                List<Point> tempObject = new ArrayList<>();
                // copy by value
                // мы будем менять копию, а не оригинал, дабы вернуться назад
                for(Point p:objekts){
                    tempObject.add(new Point(p.x,p.y));
                }             
                int oldX=-1;
                int oldY=-1;
                // получаем список закрашенных точек кривой
                // во первых - он быстрее чем Set, а точки у нас гарантированно не повторяются
                // во вторых - нам нужен индекс текущей точки в итерации
                List<Point> curveList = new ArrayList<>();
                curveList.addAll(points);
                progressBar.setMaximum(curveList.size());
                int speed=1000/curveList.size()*SPEED_COEFFICIENT;
                for(int i =0;i<curveList.size();i++){
                    Point curvePoint=curveList.get(i);
                    int x=curvePoint.x;
                    int y=curvePoint.y;
                    if(oldX==-1){
                        oldX=x;
                        oldY=y;
                    }
                    int dx=x-oldX;
                    int dy=y-oldY;
                    oldX=x;
                    oldY=y;
                    for(Point objectPoint:tempObject){
                        objectPoint.x+=dx;
                        objectPoint.y+=dy;                    
                    }     

                    graphic.setColor(Color.white);
                    graphic.fillRect(0,0,pWidth,pHeight);   
                    drawAxis();
                    drawControlPoints();
                    graphic.setColor(Color.BLACK);
                    drawObject(curveList);
                    // TODO DEBUG
                    graphic.setColor(Color.RED);
                    graphic.drawOval(x, y,3,3);
                    graphic.setColor(Color.BLUE);
                    drawObject(tempObject);
                    try {
                        Thread.sleep(speed);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MyJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                    progressBar.setValue(progressBar.getValue()+1);
                } 
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }             
                progressBar.setValue(0);
                recalculateCurve=false;
                drawScene();
                moveBtn.setEnabled(true);
            }            
        };
        Thread workerThread = new Thread(r);
        workerThread.start();
    }//GEN-LAST:event_moveBtnActionPerformed
    
    private void killDrawThread(){
        if(drawThread!=null && drawThread.isAlive()){
            drawThread.stop();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn1;
    private javax.swing.JCheckBox drawModeCb;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logArea;
    private javax.swing.JPanel mCanvasPanel;
    private javax.swing.JButton mDrawButton;
    private javax.swing.JTextField mStepTTf;
    private javax.swing.JButton moveBtn;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton redrawBtn;
    private javax.swing.JLabel tLabel;
    private javax.swing.JLabel xLabel;
    private javax.swing.JTextField xTf;
    private javax.swing.JLabel yLabel;
    private javax.swing.JTextField yTf;
    // End of variables declaration//GEN-END:variables

    class DrawThread extends Thread{
        private float t1,t2;

        public DrawThread(float t1, float t2) {
            this.t1 = t1;
            this.t2 = t2;
        }

        @Override
        public void run() {             
            graphic.setColor(Color.black);
            float t=t1;
            if(recalculateCurve){
                points = new LinkedHashSet<>();
                while(t<=t2){
                    bezierCurvePixel(t);
                    t+=stepT;
                }
            }
            drawObject(points);            
            graphic.setColor(Color.BLUE);
            drawObject(objekts);
        }
        
        
        
    }

}
