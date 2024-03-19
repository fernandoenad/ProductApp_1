/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.*;
/**
 *
 * @author fernandoenad
 */
public class ConnectionFactory {
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String DB_URL = "jdbc:mysql://localhost/productapp?verifyServerCertificate=false&useSSL=true";
    public static final String USER = "root";
    public static final String PASS = "";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    private ConnectionFactory(){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private Connection createConnection() {
        Connection connection = null;
        try {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        return connection;
    }
    
    public static Connection getConnection() {
        return instance.createConnection();
    }
    
}
