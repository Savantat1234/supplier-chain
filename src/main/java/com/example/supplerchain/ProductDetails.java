package com.example.supplerchain;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetails {    //in productdetails class we r attaching that data to a table..
    public TableView<Product> productTable;// we created product table of tableview type..
    public Pane getAllProducts(){
        TableColumn id = new TableColumn("ID");//  these r the columns that we hv created..id,name,price
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));   //inside producttable we created 3 columns & provided lable name to it.
        TableColumn price = new TableColumn("PRICE");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

       // ObservableList<Product> data = FXCollections.observableArrayList();
      //  data.add(new Product(1,"Lenovo", 80999.0));    // we create obeservable arraylist of product type..
       // data.add(new Product(2,"HP", 81999.0));        // inside arraylist  we added the 2 products..

        ObservableList<Product> products = Product.getAllProducts();

        productTable = new TableView<>();//  object of tableview type is created..
        productTable.setMinSize(Supply_Chain.width, Supply_Chain.height);
        productTable.setItems(products); // added data_ arraylist to the productTable..
        productTable.getColumns().addAll(id,name,price); // added all columns pn productTable..

        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // removed one extra column & set exact suitable size..

        Pane tablePane = new Pane(); // we cretaed the new tablePane..
        tablePane.setStyle("-fx-background-color: #87CEEB");
        tablePane.setMinSize(Supply_Chain.width, Supply_Chain.height);
        tablePane.getChildren().add(productTable); // added productTable to the TablePane
        return tablePane; // retured tablePane..

    }


    public Pane getProductsByName(String productName){
        TableColumn id = new TableColumn("ID");//  these r the columns that we hv created..id,name,price
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name = new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));   //inside producttable we created 3 columns & provided lable name to it.
        TableColumn price = new TableColumn("PRICE");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        // ObservableList<Product> data = FXCollections.observableArrayList();
        //  data.add(new Product(1,"Lenovo", 80999.0));    // we create obeservable arraylist of product type..
        // data.add(new Product(2,"HP", 81999.0));        // inside arraylist  we added the 2 products..

        ObservableList<Product> products = Product.getProductsByName(productName);

        productTable = new TableView<>();//  object of tableview type is created..
        productTable.setMinSize(Supply_Chain.width, Supply_Chain.height);
        productTable.setItems(products); // added data_ arraylist to the productTable..
        productTable.getColumns().addAll(id,name,price); // added all columns pn productTable..

        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // removed one extra column & set exact suitable size..

        Pane tablePane = new Pane(); // we cretaed the new tablePane..
        tablePane.setStyle("-fx-background-color: #87CEEB");
        tablePane.setMinSize(Supply_Chain.width, Supply_Chain.height);
        tablePane.getChildren().add(productTable); // added productTable to the TablePane
        return tablePane; // retured tablePane..

    }


}
