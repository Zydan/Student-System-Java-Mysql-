/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import studentinformationsystem.Tools;

/**
 *
 * @author HP Probook
 */
public class go {
    public static String url;
    public static  Connection  con;
    public static void setUrl(){
    url = "jdbc:mysql://localhost:3306/studeninformationsystem";
    }
    public static void setConnection(){
    setUrl();
    try{
    con = (Connection)DriverManager.getConnection(url,"root","");
    }catch(SQLException ex){
    Tools.MBox(ex.getMessage());
    }
    }
    public static boolean login(String UserName , String Password){
try{
    setConnection();
    Statement stm = con.createStatement();
        String str = "select * from teacher where User='" + UserName + "' and " + "Password='" + Password  + "'" ;
        stm.executeQuery(str);
        while(stm.getResultSet().next()){
        con.close();
        return true;
        
        }
        con.close();
            }catch(SQLException ex){Tools.MBox(ex.getMessage());}
    return false;
    }
    public static boolean loginStudent(String UserName, String Password){
    try{
    setConnection();
    Statement stm = con.createStatement();
    String str = "select * from Student where User_Student='" + UserName + "' and " + "Password_Student='" + Password + "'";
    stm.executeQuery(str);
    while(stm.getResultSet().next()){
    con.close();
    return true;
    }
    con.close();
    
    }catch(SQLException ex){
    Tools.MBox(ex.getMessage());
     
    }
     return false;
    }
    public static boolean EcecuteNonQuery(String statement){
    try{
    setConnection();
    Statement stm = con.createStatement();
    stm.execute(statement);
      con.close();

    return true;
    
    }catch(SQLException ex ){
    Tools.MBox(ex.getMessage());
    }
    return false;
    }
    public static String getAutoNum(String Table,String Colum){
    try{
    setConnection();
    String str = "select max(" + Colum + ")+1 as autonum" + " from " + Table;
    Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(str);
       String a = "";
       while(rs.next()){
       a = rs.getString("autonum");
       }
    con.close();
    return a ;
    }catch(SQLException ex){
    Tools.MBox(ex.getMessage());
        return "1";
    }

    }
    public static void FillJTable(String StatementOrTable ,JTable table){
    try{
    setConnection();
    Statement stm = con.createStatement();
            String statement;
            if("select ".equals(StatementOrTable.substring(0,7).toLowerCase())){
            statement = StatementOrTable;
            
            
            }else {
            statement = "select * from " + StatementOrTable; 
            
            }
      
            ResultSet rs = stm.executeQuery(statement);
            
        ResultSetMetaData rsmd = rs.getMetaData();
       int c =  rsmd.getColumnCount();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
            model.setRowCount(0);
            Vector row = new Vector();
            while(rs.next()){
            row = new Vector(c);
          for(int x = 1 ; x<= c ; x++){
 row.add(rs.getString(x));
 
 }
          if(table.getColumnCount() != c){
 Tools.MBox("The Count of table is not equals to the Count Table in The dataBases The Columns Count in The Databases is :" + c);
 }else{

 model.addRow(row);
 
 }
            }
            con.close();
          
    }catch(SQLException ex){
    Tools.MBox(ex.getMessage());
    }
    
    }
}
