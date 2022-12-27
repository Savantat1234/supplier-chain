package com.example.supplerchain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private GridPane loginPage() {
        Label emaillable = new Label("Email");//lable email
        Label passwordlable = new Label("Password");// lable password
        TextField emailtextfield = new TextField();// textbox to type mail
        PasswordField passwordField = new PasswordField();//textbox to tyo]pe passsword
        GridPane gridPane = new GridPane();
        //first is x co-ordinate..&.. 2nd is y co-ordinate
        gridPane.add(emaillable,0,0);//location of email label
        gridPane.add(emailtextfield,1,0);//locztion of email text field
        gridPane.add(passwordlable,0,1);// location  of password label
        gridPane.add(passwordField,1,1);//location of password textfield

return gridPane;
    }
    private Pane createContent() {//this is thee main pane..or mother pane


        Pane root = new Pane();
       root.getChildren().addAll(loginPage()) ;// all the components that we r outting inside the bigger pane that r taken as children to the bigger root pane
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