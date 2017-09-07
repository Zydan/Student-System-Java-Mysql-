/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import javax.swing.JTable;
import studentinformationsystem.Tools;

/**
 *
 * @author HP Probook
 */
public class Teacher implements Work{
    private String FName;
    private String SName;
    private String BirthDate;
    private String City;
    private String Street;
    private String PostCode;
    private String Nationality;
    private String Eduction_Now;
    private String Eduction_Old;
    private String Student_Number;
    private String Email;
    private String Phone ;
    private String Claas_Name;
    private String Class_Numbe;

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getEduction_Now() {
        return Eduction_Now;
    }

    public void setEduction_Now(String Eduction_Now) {
        this.Eduction_Now = Eduction_Now;
    }

    public String getEduction_Old() {
        return Eduction_Old;
    }

    public void setEduction_Old(String Eduction_Old) {
        this.Eduction_Old = Eduction_Old;
    }

    public String getStudent_Number() {
        return Student_Number;
    }

    public void setStudent_Number(String Student_Number) {
        this.Student_Number = Student_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public void Add() {
  String strAdd = "insert into Student_information values('" + FName + "','" + SName + "','" 
          + BirthDate + "','" + City + "','" + Street + "','" + PostCode + "','" + Nationality + "','"
           +  Eduction_Now + "','" + Eduction_Old + "','" + Student_Number + "','"
          + Email + "','" + Phone + "','" + Class_Numbe +  "','" + Claas_Name + "')"
          ;    
boolean isAdd = db.go.EcecuteNonQuery(strAdd);
if(isAdd){Tools.MBox("Done");}
     
    }

    @Override
    public void Update() {
        String strUpdate = "update Student_information set FName='" + FName + "',SName='" 
                 + SName + "',BirthDate='" + BirthDate + "',City='" +  City + "',Street='" + Street + "',PostCode='"
                 +  PostCode + "',Nationality='" + Nationality + "',Eduction_Now='" + Eduction_Now + "',Eduction_Old='" 
                 + Eduction_Old + "',Student_Number='" + Student_Number + "',Email='" + Email + "',Phone='" 
                + Phone + "',Class_Number='" + Class_Numbe + "',Class_Name='" + Claas_Name + "'" + " where Student_Number=" +  "'" + Student_Number + "'"
                 ;
        boolean isUpdated = db.go.EcecuteNonQuery(strUpdate);
        if(isUpdated){Tools.MBox("Student Information is Updated");}
    }

    @Override
    public void Delet() {
      String  strDelete = "delete  from Student_information where Student_Number='" + Student_Number + "'";
      boolean isDeleted = db.go.EcecuteNonQuery(strDelete);
      if(isDeleted){
      Tools.MBox("Information for Student is Deleted");
      }
    }

    @Override
    public void getAllRows(JTable table) {
      db.go.FillJTable("Student_information", table); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getOnseRow(String Colum ,JTable table ) {
        String get = "select * from Student_information where Student_Number='" + Colum + "'" ;
      db.go.FillJTable(get, table);
    }

    @Override
    public String getAutoNumber() {
       return db.go.getAutoNum("Student_information", "Student_Number"); //To change body of generated methods, choose Tools | Templates.
    }

    public String getClaas_Name() {
        return Claas_Name;
    }

    public void setClaas_Name(String Claas_Name) {
        this.Claas_Name = Claas_Name;
    }

    public String getClass_Numbe() {
        return Class_Numbe;
    }

    public void setClass_Numbe(String Class_Numbe) {
        this.Class_Numbe = Class_Numbe;
    }

    @Override
    public void getCustomRow(String statement,JTable table) {
db.go.FillJTable(statement,table);
    }
}
