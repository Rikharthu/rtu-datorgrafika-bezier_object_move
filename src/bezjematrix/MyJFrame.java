/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bezjematrix;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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

    private List<Point> points;
    private Graphics graphic;
    private int offsetX;
    private int offsetY;
    private int pWidth;
    private int pHeight;
    private static final float STEP_T=0.001f;
    
    public MyJFrame() {
        initComponents();
        
        // Инициализируем свои обьекты       
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
        mXTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        mYTextFiled = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mAlphaTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfRy = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        mRotateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 153));

        mDrawButton.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 14)); // NOI18N
        mDrawButton.setText("Draw");
        mDrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mDrawButtonActionPerformed(evt);
            }
        });

        mCanvasPanel.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel1.setText("X:");

        jLabel2.setText("Y:");

        jLabel3.setText("Alpha:");

        jLabel4.setText("Ry:");

        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        mRotateButton.setText("Rotate");
        mRotateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mRotateButtonActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mYTextFiled, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mXTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mAlphaTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfRy))
                            .addComponent(mDrawButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mRotateButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mXTextField)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mYTextFiled)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(mAlphaTextField)
                                .addComponent(mRotateButton))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfRy)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(mDrawButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                    .addComponent(mCanvasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void drawScene(){
        System.out.println("drawscene");
        // erase everything
        graphic.setColor(Color.white);
        graphic.fillRect(0,0,pWidth,pHeight);
        
        graphic.setColor(Color.black);
        // koordinatu asis
        graphic.drawLine(0, offsetY, pWidth, offsetY);
        graphic.drawLine(offsetX,0, offsetX, pHeight);
        
//        if(points.size()>0){
        int i=0;
        graphic.setColor(Color.RED);
        for(Point p:points){            
            // рисуем точку и её номер
            graphic.drawString((i++)+"", p.x+offsetX,offsetY-p.y-6);
            graphic.drawOval(p.x+offsetX,offsetY-p.y,3,3);
        }
        if(points.size()>1){
            // savienot ar linijam
            float t=0;
            graphic.setColor(Color.black);
            while(t<=1){
                bezierCurvePixel(t);
                t+=STEP_T;
            }
        }
//        }
    }
    
    private void mDrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDrawButtonActionPerformed
        // TODO add your handling code here:
        // get user input     
        int x=Integer.parseInt(mXTextField.getText());
        int y=Integer.parseInt(mYTextFiled.getText());
//        int rx=Integer.parseInt(tfRx.getText());
//        int ry=Integer.parseInt(tfRy.getText()); 
        
        
        Point p = new Point(x,y);
        points.add(p);
        
        drawScene();
    }//GEN-LAST:event_mDrawButtonActionPerformed
  
    private void mCanvasPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseClicked
        // TODO add your handling code here:        
        int x=evt.getX()-offsetX;
        int y=-evt.getY()+offsetY;
        
        points.add(new Point(x,y));
        drawScene();
    }//GEN-LAST:event_mCanvasPanelMouseClicked
    
    private void bezierCurvePixel(float t){
        int point_count=points.size();
        float b_p[];
        b_p=new float [point_count];
        // TODO автоматизировать
        switch(point_count){
            //TODO Аналогия с треугольником паскаля
            case 1:
                // 1
                b_p[0]=1*1;
                break;
            case 2:
                // 1 1
                b_p[0]=1*(1-t);
                b_p[1]=1*t;
                break;
            case 3:
                // 1 2 1
                b_p[0]=1*(1-t)*(1-t);
                b_p[1]=2*(1-t)*t;
                b_p[2]=1*t*t;
                break;
            case 4:
                // Треугл. Паскаля - 1 3 3 1
                b_p[0]=1*(1-t)*(1-t)*(1-t);
                b_p[1]=3*(1-t)*(1-t)*t;
                b_p[2]=3*(1-t)*t*t;
                b_p[3]=1*t*t*t;
                break;  
            case 5:
                b_p[0]=1*(1-t)*(1-t)*(1-t)*(1-t);
                b_p[1]=4*(1-t)*(1-t)*(1-t)*t;
                b_p[2]=6*(1-t)*(1-t)*t*t;
                b_p[3]=4*(1-t)*t*t*t;
                b_p[4]=1*t*t*t*t;
                break;
                // если делать по формуле из презы, то сразу дели n! на t!, чтобы не драться с большими числами 
        }
        
        float sumX=0;
        float sumY=0;
        
        for(int i=0;i<point_count;i++){
            sumX+=b_p[i]*points.get(i).x;
            sumY+=b_p[i]*points.get(i).y;
        }
        
        int x,y;
        x=(int)Math.round(sumX);
        y=(int)Math.round(sumY);
        
        // перенести в метод где происходит рисовка. пускай он там это делает
        graphic.drawLine(x+offsetX,pHeight-(y+offsetY),x+offsetX,pHeight-(y+offsetY));
        
    }
    
    private void mCanvasPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_mCanvasPanelMouseReleased

    private void mCanvasPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mCanvasPanelMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_mCanvasPanelMousePressed

    private void mRotateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mRotateButtonActionPerformed
                  
        // TODO add your handling code here:
        // get user input     
        int i, x_new, y_new;
        
        float alpha=(float)Math.toRadians(
                Float.parseFloat(mAlphaTextField.getText())
        );
        
        for(i=0;i<points.size();i++){
            x_new=(int)Math.round(points.get(i).x*Math.cos(alpha)
                -points.get(i).y*Math.sin(alpha));
            y_new=(int)Math.round(points.get(i).x*Math.sin(alpha)
            +points.get(i).y*Math.cos(alpha));
            points.get(i).x=x_new;
            points.get(i).y=y_new;
        }
        drawScene();
         
    }//GEN-LAST:event_mRotateButtonActionPerformed
    
    /** Draws symmetrical points */
    private void drawSymmetric(int xn,int yn,int xc,int yc,Graphics g){
        // simetriski pret OY
        g.drawLine(xn+xc, -yn+yc, xn+xc, -yn+yc);
        // simetriski pret OX un OY
        g.drawLine(-xn+xc, -yn+yc, -xn+xc, -yn+yc);
        // simetriski pret OX
        g.drawLine(-xn+xc, yn+yc, -xn+xc, yn+yc);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea logArea;
    private javax.swing.JTextField mAlphaTextField;
    private javax.swing.JPanel mCanvasPanel;
    private javax.swing.JButton mDrawButton;
    private javax.swing.JButton mRotateButton;
    private javax.swing.JTextField mXTextField;
    private javax.swing.JTextField mYTextFiled;
    private javax.swing.JTextField tfRy;
    // End of variables declaration//GEN-END:variables
}
