package oscarblancarte.ipd.factorymethod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oscarblancarte.ipd.factorymethod.IDBAdapter;
import oscarblancarte.ipd.factorymethod.DBFactory;
import oscarblancarte.ipd.factorymethod.entity.Product;

public class ProductDAO {
    
    private final IDBAdapter dbAdapter;
    
    public ProductDAO(){
        dbAdapter = DBFactory.getDefaultDBAdapter();
    }
    
    public List<Product> findAllProducts(){
        try (Connection connection = dbAdapter.getConnection()) {
            List<Product> productList = new ArrayList<>();
            PreparedStatement statement = connection
                    .prepareStatement("SELECT idProduct,productName"
                            + ",price FROM product");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                productList.add(new Product(results.getLong(1),
                        results.getString(2), results.getDouble(3)));
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean saveProduct(Product product){
        try (Connection connection = dbAdapter.getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO product(idProduct,"
                            + "productName,price) VALUES (?,?,?)");
            statement.setLong(1, product.getIdProduct());
            statement.setString(2, product.getProductName());
            statement.setDouble(3, product.getPrice());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}