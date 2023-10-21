/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio9;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 *
 * @author USER
 */
public class Nave {   

    private int vida;
    private int velocidad;
    private final Bala[] balas = new Bala[10];
    private JLabel lbl_nave;
    private ImageIcon icon_nave; 
    private Bala diseñoBala;
    
    public Nave(){        
    }
        
    public Nave(Bala bala){  
        diseñoBala = bala;        
    }
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
        
    public JLabel getLbl_nave() {
        return lbl_nave;
    }
    
    public ImageIcon getIcon_nave() {
        return icon_nave;
    }

    public void setIcon_nave(String icon_nave) {
        
        this.icon_nave = new ImageIcon(getClass()
                .getResource(icon_nave));
        
        this.lbl_nave = new JLabel();
        lbl_nave.setIcon(this.icon_nave);
        lbl_nave.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_nave.setSize(this.icon_nave.getIconWidth(),
                this.icon_nave.getIconHeight());
    }
    
    public void setXY(int x, int y){
        lbl_nave.setLocation(x, y);
    }
    public void setX(int x){
        lbl_nave.setLocation(x, lbl_nave.getY());
    }
    public void setY(int y){
        lbl_nave.setLocation(lbl_nave.getX(), y);
    }
    
    public int getX(){
        return lbl_nave.getX();
    }
    
    public int getY(){
        return lbl_nave.getX();
    }
    
    public boolean cartuchoVacio(){
        for (Bala bala : balas) {
            if (bala != null) {
                return false;
            }
        }
    return true;
    }
    
    public void recarga(){
        vaciarCartucho();
        for (int i = 0; i < balas.length; i++) {                
            balas[i] = crearBala();
        }
    } 
    
    public void vaciarCartucho(){
        for (int i = 0; i < balas.length; i++) {
                balas[i] = null;
            }
    }
    
    public void moverIzquierda(){
        if (lbl_nave.getX() < -60) {
            lbl_nave.setLocation(290, lbl_nave.getY());
        }
        
        lbl_nave.setLocation(lbl_nave.getX() - 5, lbl_nave.getY());
        System.out.println("A la izquierda");
    }
    
    public void moverDerecha(){
        if (lbl_nave.getX() > 290) {
            lbl_nave.setLocation(-50, lbl_nave.getY());
        }        
        
        lbl_nave.setLocation(lbl_nave.getX() + 5, lbl_nave.getY());
        System.out.println("A la derecha");
    }
    
    public Bala disparar(){
        if (!cartuchoVacio()) {           
            Bala balaLanzada = null;
            for (int i = 0; i < balas.length; i++) {
                if (balas[i] != null) {
                    balaLanzada = balas[i]; 
                    int x = lbl_nave.getX() + (lbl_nave.getWidth() / 2) - 
                                (balaLanzada.getLbl_bala().getWidth() / 2);
                    int y = lbl_nave.getY();
                    
                    balaLanzada.setXY(x, y);
                    
                    balaLanzada.moverBalaArriba();
                    balas[i] = null;
                    break;
                }
            }
            return balaLanzada;             
        }
        else{
            return null;
        }
    }
    
    public Bala crearBala(){
        Bala nuevaBala = diseñoBala;
        
        return nuevaBala;       
    }
    
    public void posicionarNave(int x, int y){
        lbl_nave.setBounds(x, y,this.icon_nave.getIconWidth() 
                , this.icon_nave.getIconHeight());
    }
}