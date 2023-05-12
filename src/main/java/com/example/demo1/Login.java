package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class Login {

    @FXML
    private Button logIn;

    @FXML
    private Button signUp;

    @FXML
    private Label loginText;

    @FXML
    private TextField email;

    @FXML
    private PasswordField pwd;

    Main m = new Main();

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    public void checkLogin() throws IOException {

        if(email.getText().equals(Main.admin.adminId) && pwd.getText().equals(Main.admin.pwd)){
            loginText.setText("Welcome!!");
            m.changeScene("admin.fxml");
        }else if(checkCustomer(email.getText(), pwd.getText()) != null ){
            Main.actualCustomer = checkCustomer(email.getText(), pwd.getText());
            loginText.setText("Welcome!!");
            m.changeScene("customer.fxml");
        }else{
            loginText.setText("Wrong!!");
        }
    }

    public void userSignUp(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("signup.fxml");
    }

    static Customer checkCustomer(String email, String pwd){
        for(Customer c : Main.admin.customers){
            if(pwd.equals(c.password) && email.equals(c.email)){
                return c;
            }
        }
        return null;
    }
}
