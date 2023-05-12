package com.example.demo1;
public class Car {

    protected String carId;
    protected String make;
    protected String model;
    protected String color;
    protected int year;
    protected String type;
    protected boolean available = true;

    protected boolean isAdmin = false;

    public Car(){

    }

    public Car(String id, String make, String model, String color, int year, String type, boolean available){
        this.carId = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.type = type;
        this.available = available;
    }

    public String getCarId() {
        return carId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public String getAvailable(){
        if (available)
        {
            return "The "+ color + " " + make + " " + model
                    + " is available. Please wait until the reservation is complete";
        }
        else{
            return "The "+ color + " " + make + " " + model
                    + " is not available.";
        }
    }

    protected void setCarId(String carId , boolean isAdmin) {
        if(isAdmin) this.carId = carId;
    }

    protected void setMake(String make, boolean isAdmin) {
        if(isAdmin) this.make = make;
    }

    protected void setModel(String model, boolean isAdmin) {
        if(isAdmin)this.model = model;
    }

    protected void setColor(String color, boolean isAdmin) {
        if(isAdmin)this.color = color;
    }

    protected void setYear(int year) {
        if(isAdmin)this.year = year;
    }

    public void setType(String type, boolean isAdmin) {
        if(isAdmin)this.type = type;
    }

    protected void setAvailable(boolean available, boolean isAdmin) {
        if(isAdmin)this.available = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", type='" + type;
    }
}

