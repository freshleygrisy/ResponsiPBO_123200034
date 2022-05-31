/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsi_123200034;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class ModAslab {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/aslab_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public ModAslab() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readContact(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][5]; 
            
            String query = "SELECT * FROM aslab"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getDouble("portofolio"));                
                data[jmlData][2] = String.valueOf(resultSet.getDouble("microteaching"));
                data[jmlData][3] = String.valueOf(resultSet.getDouble("wawancara"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("nilai"));
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    
    public void insertData(String Nama, double Portofolio, double Microteaching, double Wawancara, double Nilai){
        int jmlData=0;
        
        try {
           String query = "SELECT * FROM aslab WHERE nama='" + Nama +"'"; 
           System.out.println(Nama + " " + Portofolio + " " + Microteaching + " " + Wawancara);
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {
                query = "INSERT INTO aslab(nama,portofolio,microteaching,wawancara,nilai) VALUES('"+ Nama +"','"+ Portofolio +"','"+ Microteaching +"','"+ Wawancara +"','"+ Nilai +"')";
           
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateData(String Nama, double Portofolio, double Microteaching, double Wawancara, double Nilai){
        int jmlData=0;
         try {
           String query = "SELECT * FROM aslab WHERE nama='" + Nama +"'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
           while (resultSet.next()){ 
                jmlData++;
            }
           
             if (jmlData==1) {
                query = "UPDATE aslab SET portofolio='" + Portofolio + "', microteaching='" + Microteaching + "', nilai='"+ Nilai+"' WHERE nama='" + Nama +"'"; 
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }
           
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteContact (String Nama) {
        try{
            String query = "DELETE FROM aslab WHERE nama = '"+ Nama +"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
