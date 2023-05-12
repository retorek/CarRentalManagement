package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class CustomerController {

    @FXML
    private Label firstNameText;

    @FXML
    private Label lastNameText;

    @FXML
    private Label id1Text;

    @FXML
    private Label emailText;

    @FXML
    private Label birthText;

    @FXML
    private Label reservationText;

    @FXML
    private Button showCustomer;

    @FXML
    private Button showCars;

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
    private Label id2Text;

    @FXML
    private Button next;
    @FXML
            private Button previous;
    @FXML
            private Button show;
    @FXML
            private Button reserve;
    
    int size = Main.admin.cars.toArray().length;

    int rank = 0;

    public void customer(ActionEvent event) throws IOException {
        firstNameText.setText(Main.actualCustomer.firstName);
        lastNameText.setText(Main.actualCustomer.lastName);
        id1Text.setText(Main.actualCustomer.id);
        emailText.setText(Main.actualCustomer.email);
        String birth = String.valueOf(Main.actualCustomer.birthDate.getDayOfMonth()) + " " +
                        String.valueOf(Main.actualCustomer.birthDate.getMonth()) + " " +
                        String.valueOf(Main.actualCustomer.birthDate.getYear());
        birthText.setText(birth);
        if(Main.actualCustomer.reservation == null){
            reservationText.setText("None");
        }else {
            reservationText.setText(String.valueOf(Main.actualCustomer.reservation.toString()));
        }
    }

    public void cars(ActionEvent event) throws IOException{
        makeText.setText(String.valueOf(Main.admin.cars.get(rank).make));
        modelText.setText(String.valueOf(Main.admin.cars.get(rank).model));
        typeText.setText(String.valueOf(Main.admin.cars.get(rank).type));
        colorText.setText(String.valueOf(Main.admin.cars.get(rank).color));
        yearText.setText(String.valueOf(Main.admin.cars.get(rank).year));
        availabilityText.setText(String.valueOf(Main.admin.cars.get(rank).available));
        id2Text.setText(String.valueOf(Main.admin.cars.get(rank).carId));
        reservation2Text.setText("");
    }

    public void next(ActionEvent event) throws IOException{
        if(rank != size - 1){
            rank ++;
            makeText.setText(String.valueOf(Main.admin.cars.get(rank).make));
            modelText.setText(String.valueOf(Main.admin.cars.get(rank).model));
            typeText.setText(String.valueOf(Main.admin.cars.get(rank).type));
            colorText.setText(String.valueOf(Main.admin.cars.get(rank).color));
            yearText.setText(String.valueOf(Main.admin.cars.get(rank).year));
            availabilityText.setText(String.valueOf(Main.admin.cars.get(rank).available));
            id2Text.setText(String.valueOf(Main.admin.cars.get(rank).carId));
            reservation2Text.setText("");

        }
    }
    public void previous(ActionEvent event) throws IOException{
        if(rank != 0){
            rank --;
            makeText.setText(String.valueOf(Main.admin.cars.get(rank).make));
            modelText.setText(String.valueOf(Main.admin.cars.get(rank).model));
            typeText.setText(String.valueOf(Main.admin.cars.get(rank).type));
            colorText.setText(String.valueOf(Main.admin.cars.get(rank).color));
            yearText.setText(String.valueOf(Main.admin.cars.get(rank).year));
            availabilityText.setText(String.valueOf(Main.admin.cars.get(rank).available));
            id2Text.setText(String.valueOf(Main.admin.cars.get(rank).carId));
            reservation2Text.setText("");
        }
    }

    @FXML
    private Label reservation2Text;

    public void reserve(ActionEvent event) throws IOException{
        if(Main.admin.cars.get(rank).available && Main.actualCustomer.reservation == null){
            String rId;
            if(Main.actualCustomer.previousReservations.isEmpty()){
                rId = "12345";
            }else{
                int num = Integer.parseInt(Main.actualCustomer.previousReservations.get(Main.actualCustomer.previousReservations.size()- 1).reservationId);
                num ++;
                rId = Integer.toString(num);
            }
            Main.admin.cars.get(rank).available = false;
            Reservation r = new Reservation(rId, LocalDate.now(), Main.actualCustomer, Main.admin.cars.get(rank));
            Main.actualCustomer.previousReservations.add(r);
            Main.actualCustomer.reservation = r;
            reservation2Text.setText("The car is reserved you.");
        }else{
            reservation2Text.setText("This car is not available to reserve.");
        }
    }

    public void logOut(ActionEvent event) throws IOException{
        Main m  = new Main();
        m.changeScene("hello-view.fxml");
    }

}
