package com.example.supplerchain;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Product {        // in product class we r bringing data from databse..
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;

    public int getId() {// right click >> generate >> getters
        return id.get();
    }
    public String getName() {// right click >> generate >> getters
        return name.get();
    }
    public double getPrice() {// right click >> generate >> getters
        return price.get();
    }

    public Product(int id, String name, Double price) {  //generated the constructors..
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }

   public static ObservableList<Product> getAllProducts(){ // we are fetching all products from database..

        // we need following to  get all products:
        DataBaseConnection dataBaseConnection = new DataBaseConnection(); //object of Databaseconnection class..
        ObservableList<Product> productList = FXCollections.observableArrayList();//ObservableList
        String selectProduct = "select * from Product";                           // & a querry
        try {
            ResultSet rs = dataBaseConnection.getQueryTable(selectProduct);
            while (rs.next()){
                productList.add(new Product(rs.getInt("Prod_id"),
                        rs.getString("name"), rs.getDouble("price")
                        ));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }


    public static ObservableList<Product> getProductsByName(String productName){ // we are fetching all products from database..

        // we need following to  get all products:
        DataBaseConnection dataBaseConnection = new DataBaseConnection(); //object of Databaseconnection class..
        ObservableList<Product> productList = FXCollections.observableArrayList();//ObservableList
        String selectProduct = String.format("select * from Product where lower(name) like '%%%s%%'",productName.toLowerCase());                           // & a querry
        try {
            ResultSet rs = dataBaseConnection.getQueryTable(selectProduct);
            while (rs.next()){
                productList.add(new Product(rs.getInt("Prod_id"),
                        rs.getString("name"), rs.getDouble("price")
                ));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
}
