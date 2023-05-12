package com.example.demo1;
import java.time.LocalDate;
public class Reservation {

    protected String reservationId;
    protected LocalDate date;
    protected Customer customer;
    protected Car car;

    public Reservation(String id, LocalDate date, Customer customer, Car car){
        this.reservationId = id;
        this.date = date;
        this.customer = customer;
        this.car = car;
    }

    public String getReservationId(String pwdS) {
        return reservationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId +
                ", date=" + date +
                ", customer=" + customer +
                ", car=" + car +
                '}';
    }
}

