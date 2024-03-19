/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp;

import java.util.ArrayList;
import java.sql.*;
import jdbc.*;

/**
 *
 * @author fernandoenad
 */
public class ProductDaoImpl {
    Connection connection;
    Statement statement;
    ArrayList<Product> products = new ArrayList<Product>();
   
    public void addProduct(Product product) throws SQLException{
        String name = product.getName();
        String safeName = name.replace("'", "\\'");
        String query = "INSERT INTO products (barcode, name, price, unit) "
                + "VALUES('"+product.getBarcode()+"',"
                + " '"+safeName+"',"
                + " "+product.getPrice()+","
                + " '"+product.getUnit()+"')";
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            
            statement.executeUpdate(query);
        } catch (Exception e){
        
        } finally{
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }
    
    public void modifyProduct(Product product) throws SQLException{
        String name = product.getName();
        String safeName = name.replace("'", "\\'");
        String query = "UPDATE products"
                + " SET barcode='"+product.getBarcode()+"',"
                + " name='"+safeName+"',"
                + " price="+product.getPrice()+","
                + " unit='"+product.getUnit()+"'"
                + " WHERE id="+product.getId()+"";
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            
            statement.executeUpdate(query);
        } catch (Exception e){
            System.out.println(e);
        
        } finally{
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }
    
    public void deleteProduct(int id) throws SQLException{
        String query = "DELETE FROM products WHERE id="+id+"";
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            
            statement.executeUpdate(query);
        } catch (Exception e){
        
        } finally{
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
    }
    
    public Product getProduct(int id) throws SQLException{
        String query = "SELECT * FROM products WHERE id="+id+"";
        ResultSet rs = null;
        Product product = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("barcode"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("unit")
                );
            }
            
        } catch (Exception e){
        
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        
        return product;
    }
    
    public ArrayList<Product> getProducts() throws SQLException{
        products.clear();
        
        String query = "SELECT * FROM products LIMIT 0, 100";
        ResultSet rs = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("barcode"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("unit")
                );
                this.products.add(product);
            }
            
        } catch (Exception e){
        
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        
        return this.products;
    }
    
    public ArrayList<Product> searchProducts(String str) throws SQLException{
        products.clear();
        
        String query = "SELECT * FROM products WHERE id='"+str+"'"
                + " OR barcode='"+str+"'"
                + " OR name LIKE '%"+str+"%'";
        ResultSet rs = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while(rs.next()){
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("barcode"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("unit")
                );
                products.add(product);
            }
            
        } catch (Exception e){
        
        } finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);        
        }
        
        return this.products;
    }
    
    public int getIndexOfId(int id){
        for(int index = 0; index < this.products.size(); index++){
            if(products.get(index).getId() == id){
                return index;
            }
        }
        
        return -1;
    }
}
