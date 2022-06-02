/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi_pbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class ModelMovie {
              static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/movie_db";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public ModelMovie(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
        public String[][] readMovie(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5]; //baris, kolom nya ada 4

            String query = "Select * from movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("judul"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("alur");
                data[jmlData][2] = resultSet.getString("penokohan");
                data[jmlData][3] = resultSet.getString("akting");
                data[jmlData][4] = resultSet.getString("nilai");
                
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
        
        public void insertData(String judul ,String alur, String penokohan, String akting){
        int jmlData=0;
        try { statement = (Statement) koneksi.createStatement();
            String query = "Select * from movie WHERE judul= '"+judul+"'" ; // cek apakah data sudah ada
                     ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }
            double alur1=Double.parseDouble(alur);
            double penokohan1=Double.parseDouble(penokohan);
            double akting1=Double.parseDouble(akting);
            
            double nilai;
            nilai = (alur1+penokohan1+akting1)/3;

            if (jmlData==0) { // jika data dengan no hp tsb belum ada
                query = "INSERT INTO movie VALUES('"+judul+"','"+alur+"','"+penokohan+"','"+akting+"','"+nilai+"')";

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
        
                       public void updateMovie(String judul ,String alur, String penokohan, String akting){
        int jmlData=0;
        try { statement = (Statement) koneksi.createStatement();
            String query = "Select * from movie WHERE judul= '"+judul+"'" ; // cek apakah data sudah ada
                     ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }
 double alur1=Double.parseDouble(alur);
            double penokohan1=Double.parseDouble(penokohan);
            double akting1=Double.parseDouble(akting);
            double nilai;
            nilai = (alur1+penokohan1+akting1)/3;
            
            if (jmlData==1) { // karena no hp merupakan unique value, maka dapat dipastikan hanya ada satu jika ada
                query = "UPDATE movie SET  judul='" + judul + "', alur='" + alur + "' , penokohan='" + penokohan + "' , akting='" + akting + "' , nilai='" + nilai + "'  WHERE judul= '"+judul+"'" ;
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
              
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
      
                       public void deleteMovie(String judul ){
                               try{
            String query = "DELETE FROM movie WHERE judul = '"+judul+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
                       }
        
                 public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from movie";
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
}
