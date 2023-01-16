package com.example.supplerchain;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Supply_Chain extends Application {
    public static final int  width =700, height = 600,headerbar = 50;
    public static Pane bodyPane = new Pane();
    Login login = new Login();
    ProductDetails productDetails = new ProductDetails();
    Button globalLoginButton;
    Label customerEmailLabel = null;
    String customerEmail = null;


    private GridPane headerBar(){
        TextField searchTextfield = new TextField();
        Button searchButton = new Button("search");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productName = searchTextfield.getText();

                // clear the body and put this new pane in body..
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(productDetails.getProductsByName(productName));
            }
        });



        customerEmailLabel = new Label();

        globalLoginButton = new Button("Log in");
        globalLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(loginPage());
                globalLoginButton.setDisable(true);

            }
        });
        customerEmailLabel = new Label("Welcome User");
        GridPane gridPane = new GridPane();
       // gridPane.setVgap(5);//vertical gap between controls..
       // gridPane.setHgap(5);//horizontal gap between controls..
        gridPane.setMinSize(bodyPane.getMinWidth(),headerbar - 10);//size for d gridpane of login page is with ref to bodypane
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setStyle("-fx-background-color: #87CEEB");
        gridPane.setAlignment(Pos.CENTER);//ALLIGNMENT OF LOGIN PAGE IS SETTELED TO CENTER..
        gridPane.add(searchTextfield,0,0);
        gridPane.add(searchButton,1,0);
        gridPane.add(globalLoginButton,2,0);
        gridPane.add(customerEmailLabel,3,0);
        return gridPane;
    }
    private GridPane loginPage() {
        Label emaillable = new Label("Email");//lable email
        Label passwordlable = new Label("Password");// lable password
        Label messageLabel = new Label("Plzz Enter Ur Mail & Password");
        TextField emailtextfield = new TextField();// textbox to type mail
        PasswordField passwordField = new PasswordField();//textbox to tyo]pe passsword
        Button loginbutton = new Button("Sign In");
        loginbutton.setOnAction(new EventHandler<ActionEvent>() {//this is to capture the action event..
            @Override
            public void handle(ActionEvent actionEvent) {
                String email = emailtextfield.getText();
                String password = passwordField.getText();
              //  messageLabel.setText(Email + " && " + Password);
               if (login.customerLogin(email,password)){
                   messageLabel.setText("Yehh, Login Successful");
                   customerEmail = email;
                   globalLoginButton.setDisable(true);
                   customerEmailLabel.setText("Welcome:" + customerEmail );
                   bodyPane.getChildren().clear();
                   bodyPane.getChildren().add(productDetails.getAllProducts());
               }
               else{
                   messageLabel.setText("Account Not Found");
               }

            }
        });
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(),bodyPane.getMinHeight());//size for d gridpane of login page is with ref to bodypane
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setStyle("-fx-background-color: #87CEEB");
        gridPane.setAlignment(Pos.CENTER);//ALLIGNMENT OF LOGIN PAGE IS SETTELED TO CENTER..
        //first is x co-ordinate..&.. 2nd is y co-ordinate
        gridPane.add(emaillable,0,0);//location of email label
        gridPane.add(emailtextfield,1,0);//locztion of email text field
        gridPane.add(passwordlable,0,1);// location  of password label
        gridPane.add(passwordField,1,1);//location of password textfield
        gridPane.add(loginbutton,0,2);
        gridPane.add(messageLabel,1,2);

return gridPane;
    }
    private GridPane footerbar(){
        Button addToCartButton = new Button("Add To Cart");
        Button buyNowButton = new Button("Buy Now");
        Label messageLabel = new Label("");
        buyNowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Product  selectedProduct = productDetails.getSelectedProduct();
                if(Order.placeOrder(customerEmail,selectedProduct)){
                    messageLabel.setText("Ordere Placed");
                }
                else {
                    messageLabel.setText("Order Failed");
                }

            }
        });

        GridPane gridPane = new GridPane();
        // gridPane.setVgap(5);//vertical gap between controls..
        // gridPane.setHgap(5);//horizontal gap between controls..
        gridPane.setMinSize(bodyPane.getMinWidth(),headerbar - 10);//size for d gridpane of login page is with ref to bodypane
        gridPane.setVgap(5);
        gridPane.setHgap(50);
        gridPane.setStyle("-fx-background-color: #87CEEB");
        gridPane.setAlignment(Pos.CENTER);//ALLIGNMENT OF LOGIN PAGE IS SETTELED TO CENTER..
        gridPane.setTranslateY(headerbar + height + 5);
        gridPane.add(addToCartButton,0,0);
        gridPane.add(buyNowButton,1,0);
        gridPane.add(messageLabel,2,0);

        return gridPane;
    }
    private Pane createContent() {//this is thee main pane..or mother pane


        Pane root = new Pane();
        root.setPrefSize(width, height + 2*headerbar);
        bodyPane.setMinSize(width,height);
        bodyPane.setTranslateY(headerbar);
        bodyPane.getChildren().addAll(productDetails.getAllProducts());
       root.getChildren().addAll(headerBar(), bodyPane,footerbar()) ;// all the components that we r putting inside the bigger pane that r taken as children to the bigger root pane
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
      //  FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}