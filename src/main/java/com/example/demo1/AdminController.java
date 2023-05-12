package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminController {


    @FXML
    private Label makeText;
    @FXML
    private Label modelText;
    @FXML
    private Label typeText;
    @FXML
    private Label colorText;
    @FXML
    private Label yearText;
    @FXML
    private Label availabilityText;
    @FXML
    private Label idText;

    @FXML
    private Button next;
    @FXML
    private Button previous;
    @FXML
    private Button show;
    @FXML
    private Button logOut;

    int rank = 0;

    int size = Main.admin.cars.toArray().length;


    public void showCar(ActionEvent event) throws IOException{
        makeText.setText(String.valueOf(Main.admin.cars.get(rank).make));
        modelText.setText(String.valueOf(Main.admin.cars.get(rank).model));
        typeText.setText(String.valueOf(Main.admin.cars.get(rank).type));
        colorText.setText(String.valueOf(Main.admin.cars.get(rank).color));
        yearText.setText(String.valueOf(Main.admin.cars.get(rank).year));
        availabilityText.setText(String.valueOf(Main.admin.cars.get(rank).available));
        idText.setText(String.valueOf(Main.admin.cars.get(rank).carId));
    }

    public void nextCar(ActionEvent event) throws IOException {
        int size = Main.admin.cars.toArray().length;
        if(rank != size - 1){
            rank ++;
            makeText.setText(String.valueOf(Main.admin.cars.get(rank).make));
            modelText.setText(String.valueOf(Main.admin.cars.get(rank).model));
            typeText.setText(String.valueOf(Main.admin.cars.get(rank).type));
            colorText.setText(String.valueOf(Main.admin.cars.get(rank).color));
            yearText.setText(String.valueOf(Main.admin.cars.get(rank).year));
            availabilityText.setText(String.valueOf(Main.admin.cars.get(rank).available));
            idText.setText(String.valueOf(Main.admin.cars.get(rank).carId));
        }
    }

    public void previousCar(ActionEvent event) throws IOException{
        int size = Main.admin.cars.toArray().length;
        if(rank != 0){
            rank --;
            makeText.setText(String.valueOf(Main.admin.cars.get(rank).make));
            modelText.setText(String.valueOf(Main.admin.cars.get(rank).model));
            typeText.setText(String.valueOf(Main.admin.cars.get(rank).type));
            colorText.setText(String.valueOf(Main.admin.cars.get(rank).color));
            yearText.setText(String.valueOf(Main.admin.cars.get(rank).year));
            availabilityText.setText(String.valueOf(Main.admin.cars.get(rank).available));
            idText.setText(String.valueOf(Main.admin.cars.get(rank).carId));
        }
    }

    public void logOut(ActionEvent event) throws IOException{
        Main m  = new Main();
        m.changeScene("hello-view.fxml");
    }


    @FXML
    private Label fNameText;
    @FXML
    private Label lNameText;
    @FXML
    private Label idText1;
    @FXML
    private Label emailText;
    @FXML
    private Label birthText;
    @FXML
    private Label reservationText;
    @FXML
    private Button showCustomer;
    @FXML
    private Button nextCustomer;
    @FXML
    private Button previousCustomer;
    @FXML
    private Button logOut1;

    int rank1 = 0;

    int size1 = Main.admin.customers.toArray().length;


    public void showCustomer(ActionEvent event) throws IOException{
        fNameText.setText(String.valueOf(Main.admin.customers.get(rank1).firstName));
        lNameText.setText(String.valueOf(Main.admin.customers.get(rank1).lastName));
        idText1.setText(String.valueOf(Main.admin.customers.get(rank1).id));
        emailText.setText(String.valueOf(Main.admin.customers.get(rank1).email));
        birthText.setText(String.valueOf(Main.admin.customers.get(rank1).birthDate));
        reservationText.setText(String.valueOf(Main.admin.customers.get(rank1).reservation));
    }

    public void nextCustomer(ActionEvent event) throws IOException {
        if(rank1 != size1 - 1){
            rank1 ++;
            fNameText.setText(String.valueOf(Main.admin.customers.get(rank1).firstName));
            lNameText.setText(String.valueOf(Main.admin.customers.get(rank1).lastName));
            idText1.setText(String.valueOf(Main.admin.customers.get(rank1).id));
            emailText.setText(String.valueOf(Main.admin.customers.get(rank1).email));
            birthText.setText(String.valueOf(Main.admin.customers.get(rank1).birthDate));
            reservationText.setText(String.valueOf(Main.admin.customers.get(rank1).reservation));
        }
    }

    public void previousCustomer(ActionEvent event) throws IOException{
        if(rank1 != 0){
            rank1 --;
            fNameText.setText(String.valueOf(Main.admin.customers.get(rank1).firstName));
            lNameText.setText(String.valueOf(Main.admin.customers.get(rank1).lastName));
            idText1.setText(String.valueOf(Main.admin.customers.get(rank1).id));
            emailText.setText(String.valueOf(Main.admin.customers.get(rank1).email));
            birthText.setText(String.valueOf(Main.admin.customers.get(rank1).birthDate));
            reservationText.setText(String.valueOf(Main.admin.customers.get(rank1).reservation));
        }
    }

    @FXML
    private TextField make;

    @FXML
    private TextField model;

    @FXML
    private TextField type;

    @FXML
    private TextField color;

    @FXML
    private TextField year;

    @FXML
    private CheckBox available;

    @FXML
    private TextField id;

    @FXML
    private Label addCarCheck;

    public void addCar(ActionEvent event) throws IOException{
        if(make.getText().equals("") ||
                model.getText().equals("") ||
                id.getText().equals("") ||
                type.getText().equals("") ||
                color.getText().equals("") ||
                year.getText().equals("")){
                addCarCheck.setText("Please fill all the information fields, all the information are required.");
        }else{
            Car c = new Car();
            c.make = make.getText();
            c.model = model.getText();
            c.carId = id.getText();
            c.color = color.getText();
            c.type = type.getText();
            c.year = Integer.parseInt(year.getText());
            c.available = available.isSelected();
            Main.admin.cars.add(c);
            addCarCheck.setText("Car added successfully.");
        }
    }


}
