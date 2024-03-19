/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package productapp;

import java.util.ArrayList;

/**
 *
 * @author fernandoenad
 */
public interface ProductDao {
    public void addProduct(Product product);
    public void modifyProduct(Product product);
    public void deleteProduct(int index);
    public Product getProduct(int index);
    public ArrayList<Product> getProducts();
    public ArrayList<Product> searchProducts(String str);
    
    
}
