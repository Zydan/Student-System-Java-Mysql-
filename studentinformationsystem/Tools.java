/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HP Probook
 */
public class Tools {
  public static  void MBox(String Message){
      JOptionPane.showMessageDialog(null, Message);
  
  }
  public static String InputBox(String Message){
  String s = JOptionPane.showInputDialog(Message);
  return s;
  }
 public  static boolean Confirm(String Massege){
    int Data = JOptionPane.showConfirmDialog(null, Massege);
    if(Data == JOptionPane.YES_OPTION){
    return true;
    }else{
    
    return false;
    }
    
    }
 public static void OpenForm(JFrame form){
      try {
          Image image = ImageIO.read(Tools.class.getResource("graduate-student-icon-14068.png"));
         form.setIconImage(image);
         form.setLocationRelativeTo(null);
         
         form.setVisible(true);
      } catch (IOException ex) {
          Tools.MBox(ex.getMessage());
      }
 form.setBackground(Color.WHITE);
 
 
 }
 public static void Clear(Container con){
 for(Component com : con.getComponents() ){
 if(com instanceof JTextField){
 JTextField text = (JTextField)com;
 text.setText("");
 }else if(com instanceof  Container ){
     Clear((Container)com);
 }
 
 }
 
 }
}
