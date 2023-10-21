/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author USER
 */
public class Bala {

    private int daño;
    private int velocidad;
    private JLabel lbl_bala;
    private ImageIcon icon_bala;            
    
    Timer timer = null;
    
    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public JLabel getLbl_bala() {
        return lbl_bala;
    }
    
    public ImageIcon getIcon_bala() {
        return icon_bala;
    }

    public void setIcon_bala(String icon_bala) {
        this.icon_bala = new ImageIcon(getClass()
                .getResource(icon_bala));
        
        this.lbl_bala = new JLabel();
        lbl_bala.setIcon(this.icon_bala);
        lbl_bala.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_bala.setSize(10, 21);
    }
    
    public void setXY(int x, int y){
        lbl_bala.setLocation(x, y);
    }
    public void setX(int x){
        lbl_bala.setLocation(x, lbl_bala.getY());
    }
    public void setY(int y){
        lbl_bala.setLocation(lbl_bala.getX(), y);
    }
    
    public int getX(){
        return lbl_bala.getX();
    }
    
    public int getY(){
        return lbl_bala.getX();
    }
    
    public void moverBalaArriba(){
        
        if (timer == null) {
            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lbl_bala.setLocation(lbl_bala.getX(), lbl_bala.getY() - 12);
                }
            });
            timer.start();
        }
    }
}
