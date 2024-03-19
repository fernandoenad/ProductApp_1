/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp;

/**
 *
 * @author fernandoenad
 */
import java.sql.*;

public class mysqltest {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/test?verifyServerCertificate=false&useSSL=true";
    public static final String USER = "test";
    public static final String PASS = "test";

    public static void main(String[] args){
        try{
            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(DB_URL,USER, PASS);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM test";
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                System.out.println("ID " + rs.getInt("id"));
            }
            
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    
    }
}
