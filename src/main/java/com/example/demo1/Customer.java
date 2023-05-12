package com.example.demo1;



import java.time.LocalDate;
import java.util.ArrayList;

public class Customer{

    public String id;
    protected String firstName;
    protected String lastName;
    protected LocalDate birthDate;
    protected String email;
    protected String password;
    protected Reservation reservation;
    protected String driverLicenceId;
    protected ArrayList<Reservation> previousReservations;

    public Customer(){
        this.previousReservations = new ArrayList<Reservation>();
    }

    public Customer(String driverLicenceId,String id, String firstName, String lastName, LocalDate birth,String email, String password){
        this.driverLicenceId = driverLicenceId;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birth;
        this.email = email;
        this.password = password;

        this.previousReservations = new ArrayList<Reservation>();
    }

    public void setCustomerId(String customerId) {
        this.id = customerId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
        previousReservations.add(reservation);
    }


    @Override
    public String toString() {
        return    "Customer{" +
                "Id='" + id + '\'' +
                ", First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                ", Birth Date=" + birthDate + '\'' +
                ", Email='" + email + '\'' +
                ", Reservation=" + reservation +
                '}';
    }
}
