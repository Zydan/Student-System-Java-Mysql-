/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controls;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPasswordField;

/**
 *
 * @author HP Probook
 */
public class JTextPass  extends JPasswordField{
 public JTextPass(int size){
 super(size);
 
 }
 @Override
 public void paintComponent(Graphics g){
     g.setColor(getBackground());
 g.fillRoundRect(0,0,getWidth()-1, getHeight()-1, 20, 20);
         super.paintComponent(g);
 }
 @Override 
 public void paintBorder(Graphics g){
 g.setColor(Color.BLACK);
 g.drawRoundRect(0,0,getWidth()-1, getHeight()-1,20,20);
 
 }
}
