/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import javax.swing.JTable;

/**
 *
 * @author HP Probook
 */
public interface Work {
 public void Add();
 public void Update();
 public void Delet();
 public void getAllRows(JTable table);
 public void getOnseRow(String Colum, JTable table);
 public String getAutoNumber();
 public void getCustomRow(String statement , JTable table);
}
