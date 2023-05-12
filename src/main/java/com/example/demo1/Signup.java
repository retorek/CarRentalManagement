package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class Signup {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField id;
    @FXML
    private TextField driverLicenseId;
    @FXML
    private TextField dayBirthDate;
    @FXML
    private TextField monthBirthDate;
    @FXML
    private TextField yearBirthDate;
    @FXML
    private TextField email;
    @FXML
    private PasswordField pwd;

    @FXML
    private Label signUpText;

    @FXML
    private Button signUp;

    Main m = new Main();

    public void signUp(ActionEvent event) throws IOException {
        if(firstName.getText().equals("") ||
            lastName.getText().equals("") ||
            id.getText().equals("") ||
            driverLicenseId.getText().equals("") ||
            dayBirthDate.getText().equals("") ||
            monthBirthDate.getText().equals("") ||
            yearBirthDate.getText().equals("") ||
            email.getText().equals("") ||
            pwd.getText().equals("") ){
                signUpText.setText("Please fill all the information fields, all the information are required.");
        }else{
            Customer c  =  new Customer();
            c.firstName = firstName.getText();
            c.lastName = lastName.getText();
            c.id = id.getText();
            c.driverLicenceId = driverLicenseId.getText();
            c.birthDate = LocalDate.of(Integer.parseInt(yearBirthDate.getText()),
                                        Integer.parseInt(monthBirthDate.getText()),
                                        Integer.parseInt(dayBirthDate.getText()));
            c.email = email.getText();
            c.password = pwd.getText();
            Main.admin.customers.add(c);
            m.changeScene("hello-view.fxml");
        }
    }

}
