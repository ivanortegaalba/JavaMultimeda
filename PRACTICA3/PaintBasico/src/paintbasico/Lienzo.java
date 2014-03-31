/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paintbasico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


/**
 *
 * @author ivan
 */
public class Lienzo extends javax.swing.JPanel {
    /**
     * Vamos a editar el lienzo de dibujo desde Lienzo.java para que los cambios 
     * afecten a la clase y no al objeto solo. 
     */
    
    //CONSTANTES ASOCIADAS A LA FIGURA ELEGIDA
    
    private Color color; //Color en el que pìntará la forma;
    private int figura; //Figura que vamos a dibujar.
    private boolean relleno; //Esta o no rellenada
    private Point pClick, pDrag; //Punto de click y punto de arrastre.
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
    }
    @Override
    public void paint(Graphics g){
        //Cuidado con no usar variables que esten a null dentro del metodo paint,
        //Ya que dejara de ejecutar el metodo y no pintará bien.
        super.paint(g);
        if(pClick != null){
                g.setColor(color);
                /*---------------------PUNTO---------------------*/
                if(this.figura==0){
                        g.fillOval(pClick.x - 5, pClick.y - 5, 10, 10);
                }
                /*---------------------LINEA---------------------*/
                if(this.figura==1){
                    g.drawLine(pClick.x, pClick.y, pDrag.x, pDrag.y);
                }
                /*---------------------RECTANGULO---------------------*/
                if(this.figura==2){
                    if(this.getRelleno()){
                        //ABAJO-DERECHA
                        if((pDrag.x- pClick.x) < 0 && (pDrag.y - pClick.y) < 0){
                            g.fillRect(pDrag.x, pDrag.y, Math.abs(pClick.x- pDrag.x), Math.abs(pClick.y - pDrag.y));
                        }
                        else{
                            g.fillRect(pClick.x, pClick.y, pDrag.x- pClick.x, pDrag.y - pClick.y);
                        }
                    }
                    else
                        //ARRIBA-IZQUIERDA
                        if((pDrag.x- pClick.x) < 0 && (pDrag.y - pClick.y) < 0){
                            g.drawRect(pDrag.x, pDrag.y, Math.abs(pClick.x- pDrag.x), Math.abs(pClick.y - pDrag.y));
                        }
                        else{
                            g.drawRect(pClick.x, pClick.y, pDrag.x- pClick.x, pDrag.y - pClick.y);
                        }
                }
                /*---------------------OVALO---------------------*/
                if(this.figura==3){
                    if(this.getRelleno()){
                        //ABAJO-DERECHA
                        if((pDrag.x- pClick.x) < 0 && (pDrag.y - pClick.y) < 0){
                            g.fillOval(pDrag.x, pDrag.y, Math.abs(pClick.x- pDrag.x), Math.abs(pClick.y - pDrag.y));
                        }
                        else{
                            g.fillOval(pClick.x, pClick.y, pDrag.x- pClick.x, pDrag.y - pClick.y);
                        }
                    }
                    else
                        //ARRIBA-IZQUIERDA
                        if((pDrag.x- pClick.x) < 0 && (pDrag.y - pClick.y) < 0){
                            g.drawOval(pDrag.x, pDrag.y, Math.abs(pClick.x- pDrag.x), Math.abs(pClick.y - pDrag.y));
                        }
                        else{
                            g.drawOval(pClick.x, pClick.y, pDrag.x- pClick.x, pDrag.y - pClick.y);
                        }
                }
                /*---------------------LIENZO VACÍO---------------------*/
                if(this.figura == 4){
                    g.fillOval(0, 0, 0, 0);
                }
        }
    }
    
    /*Devuelve el punto de click*/
    public Point getClickPoint(){
        return this.pClick;
    }
    
    /*Devuelve el punto de arrastrado*/
    public Point getDragPoint(){
        return this.pDrag;
    }
    
    /*Devuelve el color seleccionado actualmente*/
    public Color getColor(){
        return this.color;
    }
    
    /*Cambia la forma que se va a dibujar*/
    public void setForma(int i){
        this.figura = i;
    }
    
    /*Devuelve la forma que se va a dibujar*/
    public int getForma(){
        return this.figura;
    }
    
    /*Devuelve si está seleccionado el relleno*/
    public boolean getRelleno(){
        return this.relleno;
    }
    
    /*Cambia el punto de click*/
    public void setClickPoint(Point p){
        this.pClick = p;
    }
    
    /*Cambia el punto arrastrado*/
    public void setDragPoint(Point p){
        this.pDrag = p;
    }
    
    /*Cambia el color seleccionado actualmente*/
    public void setColor(Color color){
        this.color=color;
    }
    
    /*Devuelve el lienzo a su estado original*/
    public void nuevoLienzo(){
        int forma = this.getForma();
        this.setForma(4);
        this.paint(this.getGraphics());
        this.setForma(forma);
    }
    
    /*Cambia a figura con o sin relleno*/
    public void setRelleno(boolean b){
        this.relleno = b;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(254, 254, 254));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.setClickPoint(evt.getPoint());
        if(this.figura == 0)
            this.paint(this.getGraphics());
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.setClickPoint(evt.getPoint());
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setDragPoint(evt.getPoint());
        this.paint(this.getGraphics());
    }//GEN-LAST:event_formMouseDragged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
