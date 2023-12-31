/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
/**
 *
 * @author USER
 */
public class Partida extends javax.swing.JFrame {

    JLabel lbl_fondo;
    JLabel lbl_nave;
    JLabel lbl_enemigo;
    
    ArrayList<JLabel> balas = new ArrayList<>();
    Timer timer = null;
    
    Timer movimientoEnemigo;
    int enemigoSpeed = 2;
    boolean moverEnemigoDerecha = true; 
    
    
    
    /**
     * Creates new form NewJFrame1
     */
    public Partida() {
        initComponents();        
        
        // Configuramos el JLabel después de que el JFrame sea visible
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                
                // Configuramos el tamaño y la posición del JLabel
                lbl_fondo.setBounds(0, 0, 306, 380);
                lbl_nave.setBounds(110, 290, 79, 79);
                lbl_enemigo.setBounds(110, 10, 79, 79);
            }
        });

        lbl_fondo = new JLabel();        
        ImageIcon icon = new javax.swing.ImageIcon(getClass()
                .getResource("/Img/FondoEspacio.png"));
        lbl_fondo.setIcon(icon);
        
        lbl_nave = new JLabel(); 
        ImageIcon icon2 = new javax.swing.ImageIcon(getClass()
                .getResource("/Img/NavePersonaje.png"));
        lbl_nave.setIcon(icon2);
        
        lbl_enemigo = new JLabel(); 
        ImageIcon icon3 = new javax.swing.ImageIcon(getClass()
                .getResource("/Img/NaveEnemiga.png"));
        lbl_enemigo.setIcon(icon3);

        // Agregar el JLabel al JFrame        
        getContentPane().add(lbl_nave);
        getContentPane().add(lbl_enemigo);
        getContentPane().add(lbl_fondo);
        
        // Establecemos la capa de los labels        
        // 2- capa más al fondo, 1- capa media, 0- capa más arriba
        getContentPane().setComponentZOrder(lbl_nave, 0);
        getContentPane().setComponentZOrder(lbl_enemigo,1);
        getContentPane().setComponentZOrder(lbl_fondo, 2);
        
        // Configura el movimiento del enemigo
        movimientoEnemigo = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverEnemigoAleatoriamente();
            }
        });
        movimientoEnemigo.start();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        if (evt.getKeyChar() == 'd' || evt.getKeyChar() == 'D') {
            moverDerecha();
        } else if (evt.getKeyChar() == 'a' || evt.getKeyChar() == 'A'){
            moverIzquierda();
        }
    }//GEN-LAST:event_formKeyTyped

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Disparar();
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Partida().setVisible(true);
            }
        });
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
    
    public void Disparar() {
        System.out.println("Disparando");
        // Crea una nueva bala
        JLabel lbl_bala = new JLabel();
        ImageIcon icon4 = new ImageIcon(getClass()
                .getResource("/Img/BalaAzul.png"));
        lbl_bala.setIcon(icon4);
        lbl_bala.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_bala.setSize(10, 21);

        int x = lbl_nave.getX() + (lbl_nave.getWidth() / 2) - 
                (lbl_bala.getWidth() / 2);
        int y = lbl_nave.getY();
        lbl_bala.setBounds(x, y, lbl_bala.getWidth()
                , lbl_bala.getHeight());

        getContentPane().add(lbl_bala);
        getContentPane().setComponentZOrder(lbl_bala, 0);

        // Agrega la nueva bala a la lista de balas
        balas.add(lbl_bala);

        // Crea un temporizador si no existe uno y comienza a mover las balas
        if (timer == null) {
            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mueveBalasArriba();
                }
            });
            timer.start();
        }
    }
    
    public void mueveBalasArriba() {
        for (int i = 0; i < balas.size(); i++) {
            JLabel lbl_bala = balas.get(i);
            int y = lbl_bala.getY() - 12; // velocidad
            lbl_bala.setLocation(lbl_bala.getX(), y);
            
            eliminarBala(lbl_bala, i, y);
        }
    }
    
    public void moverEnemigoAleatoriamente() {
        if (moverEnemigoDerecha) {
            lbl_enemigo.setLocation(lbl_enemigo.getX() + enemigoSpeed,
                    lbl_enemigo.getY());
        } else {
            lbl_enemigo.setLocation(lbl_enemigo.getX() - enemigoSpeed, 
                    lbl_enemigo.getY());
        }

        // Determinar el cambio de dirección aleatoriamente
        if (Math.random() < 0.01) {
            moverEnemigoDerecha = !moverEnemigoDerecha;
        }

        // Asegúrando de que el enemigo no salga de la pantalla
        if (lbl_enemigo.getX() < 0) {
            lbl_enemigo.setLocation(0, lbl_enemigo.getY());
            moverEnemigoDerecha = true;
        } else if (lbl_enemigo.getX() + lbl_enemigo.getWidth() > getWidth()) {
            lbl_enemigo.setLocation(getWidth() - lbl_enemigo.getWidth(),
                    lbl_enemigo.getY());
            moverEnemigoDerecha = false;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
  
    public boolean detectaColisionBalaAEnemigo(JLabel lbl_bala){
        if (((lbl_bala.getY() < lbl_enemigo.getY()+ 15 && 
            lbl_bala.getX() > lbl_enemigo.getX()-8) &&
            (lbl_bala.getY() < lbl_enemigo.getY()+ 15 && 
            lbl_bala.getX() < lbl_enemigo.getX()+79)) ||
            ((lbl_bala.getY() < lbl_enemigo.getY()+ 35 && 
            lbl_bala.getX() > lbl_enemigo.getX()+12)) &&
            (lbl_bala.getY() < lbl_enemigo.getY()+ 35 && 
            lbl_bala.getX() < lbl_enemigo.getX()+68) ||
            ((lbl_bala.getY() < lbl_enemigo.getY()+ 55 && 
            lbl_bala.getX() > lbl_enemigo.getX()+19)) &&
            (lbl_bala.getY() < lbl_enemigo.getY()+ 55 && 
            lbl_bala.getX() < lbl_enemigo.getX()+33) ||
            ((lbl_bala.getY() < lbl_enemigo.getY()+ 55 && 
            lbl_bala.getX() > lbl_enemigo.getX()+37)) &&
            (lbl_bala.getY() < lbl_enemigo.getY()+ 55 && 
            lbl_bala.getX() < lbl_enemigo.getX()+59) ||
            ((lbl_bala.getY() < lbl_enemigo.getY()+ 70 && 
            lbl_bala.getX() > lbl_enemigo.getX()+27)) &&
            (lbl_bala.getY() < lbl_enemigo.getY()+ 70 && 
            lbl_bala.getX() < lbl_enemigo.getX()+33) ||
            ((lbl_bala.getY() < lbl_enemigo.getY()+ 70 && 
            lbl_bala.getX() > lbl_enemigo.getX()+37)) &&
            (lbl_bala.getY() < lbl_enemigo.getY()+ 70 && 
            lbl_bala.getX() < lbl_enemigo.getX()+50) ) { return true;}
        else {return false;}
    }  
    
    public void eliminarBala(JLabel lbl_bala, int i, int y) {
        if (y < -lbl_bala.getIcon().getIconHeight()) {
            // La bala ha salido de la pantalla, elimínala
            getContentPane().remove(lbl_bala);
            balas.remove(i);
            System.out.println("Bala eliminada");
        } else if (detectaColisionBalaAEnemigo(lbl_bala)) {
            // Cambiar el icono de la bala
            ImageIcon iconExplosion = new ImageIcon(getClass()
                    .getResource("/Img/Explosion.png"));
            lbl_bala.setIcon(iconExplosion);

            // Generar un valor aleatorio entre 0 y 1
            double randomValue = Math.random();

            if (randomValue < 0.08) {
                // 50% de probabilidad: cambia la dirección del enemigo
                moverEnemigoDerecha = !moverEnemigoDerecha;
            }

            System.out.println("Bala colisionada");
        }
    }
}