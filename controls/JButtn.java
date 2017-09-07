/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author HP Probook
 */
public class JButtn extends JButton  {
 public JButtn(){
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        
 }
 @Override
         
        public void paintComponent(Graphics g){
        g.setColor(new Color(50,100,180));
        g.fillRoundRect(0,0,getWidth()-1, getHeight()-1,20 ,20);
        super.paintComponent(g);
        }
        @Override
        public void paintBorder(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRoundRect(0,0,getWidth()-1, getHeight()-1,20 ,20);
        }
        
}
