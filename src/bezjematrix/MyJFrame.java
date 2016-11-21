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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private List<Point> points;
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
    
    public MyJFrame() {
        initComponents();
        
        // Инициализируем свои обьекты       
        vertices = new ArrayList<>();
        points = new ArrayList<>();
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
        mAlphaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        mRotateButton = new javax.swing.JButton();
        mLoadHomeworkBtn = new javax.swing.JButton();
        mStepTTf = new javax.swing.JTextField();
        tLabel = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();

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

        jLabel3.setText("Alpha:");

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        mRotateButton.setText("Rotate");
        mRotateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRotateButtonActionPerformed(evt);
            }
        });

        mLoadHomeworkBtn.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 14)); // NOI18N
        mLoadHomeworkBtn.setText("Load Homework");
        mLoadHomeworkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoadHomeworkBtnActionPerformed(evt);
            }
        });

        mStepTTf.setText("0.001");

        tLabel.setText("t:");

        cancelBtn.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 14)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mCanvasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mAlphaTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mRotateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mLoadHomeworkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(mStepTTf, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 96, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mLoadHomeworkBtn)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mAlphaTextField)
                            .addComponent(mRotateButton))
                        .addGap(24, 24, 24)
                        .addComponent(cancelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                    .addComponent(mCanvasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void drawScene(){
        points = new ArrayList<>();
        
        System.out.println("drawscene");
        // erase everything
        graphic.setColor(Color.white);
        graphic.fillRect(0,0,pWidth,pHeight);
        
        graphic.setColor(Color.black);
        
        // uzzimet koordinatu asis
        graphic.drawLine(0, offsetY, pWidth, offsetY);
        graphic.drawLine(offsetX,0, offsetX, pHeight);
        
        clearLog();
        log("Punkti skaits: "+vertices.size(),0);
        log("Punkti:",0);
        int counter=0;
        for(Point p:vertices){
            log("P"+(counter++)+"("+p.x+", "+p.y+")",1);
        }
        log("{",0);
        
        int i=0;
        graphic.setColor(Color.RED);
        for(Point p:vertices){            
            // рисуем точку и её номер
            graphic.drawString((i++)+"", p.x+offsetX,offsetY-p.y-6);
            graphic.drawOval(p.x+offsetX,offsetY-p.y,3,3);
        }
        
        if(vertices.size()>1){
            // savienot ar linijam            
            graphic.setColor(Color.black);
//            float t=0;
//            while(t<=1){
//                log("t = "+t,1);
//                bezierCurvePixel(t);
//                t+=stepT;
//            }
            drawThread= new DrawThread(0,1f);
            drawThread.start();
        }
        
//        log("Factorial Cache:",0);
//        factorialCache.forEach((k,v)->
//        {
//            log("key: "+k+", value: "+v,0);
//        });
//        points.forEach(point->log("x: "+point.x+", y: "+point.y,1));
//        log("Polinom Cache:",0);
//        polinomCache.forEach((k,v)->
//        {
//            log("key: "+k+", value: "+v,0);
//        });
    }
    
    private void log(String message,int level){
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0;i<level;i++){
            strBuilder.append("    ");
        }
        strBuilder.append(message+"\n");
        logArea.append(strBuilder.toString());
    }
    
    
    private void clearLog(){
        logArea.setText("");
    }
    
    private void mDrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDrawButtonActionPerformed
        // TODO add your handling code here:
        // get user input     
        int x=Integer.parseInt(xTf.getText());
        int y=Integer.parseInt(yTf.getText());        
        stepT=Float.parseFloat(mStepTTf.getText());      
        Point p = new Point(x,y);
        vertices.add(p);
        
        drawScene();
    }//GEN-LAST:event_mDrawButtonActionPerformed
  
    private void mCanvasPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseClicked
        // TODO add your handling code here:        
        int x=evt.getX()-offsetX;
        int y=-evt.getY()+offsetY;
        stepT=Float.parseFloat(mStepTTf.getText());   
        vertices.add(new Point(x,y));
        drawScene();
    }//GEN-LAST:event_mCanvasPanelMouseClicked
    
    private void bezierCurvePixel(float t){
        // TODO dynamically increase precision if there is a gap between Y or X
        
        int point_count=vertices.size();

        float sumX=0;
        float sumY=0;      
        
        int x,y;
        
        StringBuilder strXBuilder = new StringBuilder();
        StringBuilder strYBuilder = new StringBuilder();
        
        log("rekinam Bernšteina koeficientus:",3);
        
        for(int i=0;i<point_count;i++){
//            log("rekinam X pie i="+i+":",3);
            double polinoms= getPolinom(point_count-1,t,i);
            sumX+=polinoms*vertices.get(i).x;
            sumY+=polinoms*vertices.get(i).y;
            strXBuilder.append("+"+polinoms+"*"+vertices.get(i).x);
            strYBuilder.append("+"+polinoms+"*"+vertices.get(i).y);
        }
        
        log("rekinam punkta koordinatus:",3);
        
        x=(int)Math.round(sumX);
        y=(int)Math.round(sumY); 
        
        Point point = new Point(x,y);
        
        if(points.size()>0){
            if(!points.get(points.size()-1).equals(point)){
                points.add(new Point(x,y));
            }
        }else{
            points.add(new Point(x,y));
        }       
        
        log("X="+strXBuilder.toString()+"="+x,4);  
        log("Y="+strYBuilder.toString()+"="+y,4);
        
        putPointToAxis(point);
    }
    
    private void putPixelToAxis(int x,int y){
        graphic.drawLine(x+offsetX,pHeight-(y+offsetY),x+offsetX,pHeight-(y+offsetY));   
    }
    
    private void putPointToAxis(Point p){
        putPixelToAxis(p.x,p.y); 
    }
    
    /** Dabūt skaitla {@code a} faktorialu
     @param a skaitlis, kuram mes aprēkinām faktoriālu*/
    private long fact(int a){
        Long rez = factorialCache.get(a);
        if(rez==null){
            log("factorial calculation",0);
            rez=1L;
            for(int i=1;i<=a;i++){
                rez*=i;
            }
            factorialCache.put(a, rez);
        }else{       
            log("factorial from cache",0);
        }
        return rez;
    }
    
    /** Kalkulēt Bernšteina polinomu
     @param n polinomu pakāpe (n=N-1), kur N - punktu daudzums
     @param t līknes parametrs (0<t<1)
     @param i punkta numurs */
    private double getPolinom(int n,float t,int i){
        Pair pair = new Pair(n,i);
        Double part = polinomCache.get(pair);
        double rez;
        if(part==null){
            log("polinom calculated",0);
//        double result = fact(n)/(fact(i)*fact(n-i))*Math.pow(1-t,n-i)*Math.pow(t,i);
            polinomCache.put(pair,countSomething(n,i));
            return getPolinom(n,t,i);
//            part = countSomething(n,i)*Math.pow(1-t,n-i)*Math.pow(t,i);
//            String expression = String.format("%d!/(%d!*(%d-%d)!)*(1-%.2f)^(%d-%d)*%.2f^%d",n,i,n,i,t,n,i,t,i);
//            log("B"+i+","+n+"("+t+")="+expression+"="+part,4);
//            polinomCache.put(pair,part);
        }else{
            log("polinom from cache",0);
            part*=Math.pow(1-t,n-i)*Math.pow(t,i);
        }
        return part;
    }
    
    private double countSomething(int n, int i){
        i = Math.max(i,n-i);   
        // сократить на больший факторил и поделить на меньший
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

    private void mRotateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRotateButtonActionPerformed
                  
        // TODO add your handling code here:
        // get user input     
        int i, x_new, y_new;
        
        float alpha=(float)Math.toRadians(
                Float.parseFloat(mAlphaTextField.getText())
        );
        
        for(i=0;i<vertices.size();i++){            
            x_new=(int)Math.round(vertices.get(i).x*Math.cos(alpha)
                -vertices.get(i).y*Math.sin(alpha));            
            y_new=(int)Math.round(vertices.get(i).x*Math.sin(alpha)
                +vertices.get(i).y*Math.cos(alpha));
            
            vertices.get(i).x=x_new;
            vertices.get(i).y=y_new;
        }
        drawScene();         
    }//GEN-LAST:event_mRotateButtonActionPerformed

    private void mCanvasPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mCanvasPanelMouseDragged

    private void mLoadHomeworkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoadHomeworkBtnActionPerformed
        /* 2. Variants
        P0=(10,15);P1=(25,20); P2=(40,20); P3=(25,40);
        P4=(35,90); P5=(35,20); P6=(16,40); P7=(55,60)
        t=0.4 */
        stepT=Float.parseFloat(mStepTTf.getText());     
        vertices=new ArrayList<>();
        vertices.add(new Point(10,15));
        vertices.add(new Point(25,20));
        vertices.add(new Point(40,20));
        vertices.add(new Point(25,40));
        vertices.add(new Point(35,90));
        vertices.add(new Point(35,20));
        vertices.add(new Point(16,40));
        vertices.add(new Point(55,66));
        
        drawScene();
    }//GEN-LAST:event_mLoadHomeworkBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if(drawThread.isAlive()){
            drawThread.stop();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void mCanvasPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseMoved
        // TODO add your handling code here:
        if(getNearestPoint(evt.getX(),evt.getY())!=null){
            mCanvasPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            log("moved",0);
        }else{
            mCanvasPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_mCanvasPanelMouseMoved
    
    private Point getNearestPoint(int x, int y){
        for(int i =0; i<vertices.size();i++){
            Point p = vertices.get(i);
            log("dd"+(x-offsetX)+" "+(offsetY-y),0);
            log("po"+p.x+" "+p.y,0);
            log(""+p.distance(x-offsetX,offsetY-y),0);
            if(p.distance(x-offsetX,offsetY-y)<=10){
                log("RETURN",0);
                return p;
            }
        }        
        return null;
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
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logArea;
    private javax.swing.JTextField mAlphaTextField;
    private javax.swing.JPanel mCanvasPanel;
    private javax.swing.JButton mDrawButton;
    private javax.swing.JButton mLoadHomeworkBtn;
    private javax.swing.JButton mRotateButton;
    private javax.swing.JTextField mStepTTf;
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
            float t=t1;
            while(t<=t2){
//                if(this.isInterrupted()){
//                    return;
//                }
                log("t = "+t,1);
                bezierCurvePixel(t);
                t+=stepT;
            }
        }
        
        
        
    }

}
