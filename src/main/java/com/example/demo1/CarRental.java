package com.example.demo1;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class CarRental {

    protected ArrayList<Customer> customers;
    protected ArrayList<Reservation> reservations;
    protected ArrayList<Car> cars;
    protected final String adminId = "admin";
    protected final String pwd = "admin123";
    private final String accessPwd = pwdGenerator();

    public CarRental(){
        this.customers = new ArrayList<Customer>();
        this.reservations = new ArrayList<Reservation>();
        this.cars = new ArrayList<Car>();

        Car car = new Car("123", "Audi", "A4", "Red", 2009, "Berlin", true);
        cars.add(car);
        car = new Car("124",  "BMW", "M4", "Blue", 2018, "Berlin", true);
        cars.add(car);
        car = new Car("125",  "Mercedes", "C180", "Black", 2015, "Berlin", true);
        cars.add(car);


        LocalDate d = LocalDate.of(2000, 5, 3);
        Customer customer = new Customer("23/345678", "1234567", "John", "Doe", d, "customer1@me.you", "customer1");
        customers.add(customer);

        d = LocalDate.of(1990, 5, 3);
        customer = new Customer("24/345678", "1453879", "Jack,", "Biden", d, "customer2@me.you", "customer2");
        customers.add(customer);
    }

    public void addCar(Car car, String pwd){
        if(this.accessPwd.equals(pwd)) {
            cars.add(car);
            System.out.println("Car added successfully.");
        }

        else{
            System.out.print("Wrong Password!!");
        }
    }

    public void sortCustomers(String prioritySorting){
        if(prioritySorting.equals("Name")){
            Comparator<Customer> customerComparator = new Comparator<Customer>() {
                @Override
                public int compare(Customer c1, Customer c2) {
                    return c1.getName().compareTo(c2.getName());
                }
            };
            customers.sort(customerComparator);
        }else if(prioritySorting.equals("customerId")){
            Comparator<Customer> customerComparator = new Comparator<Customer>() {
                @Override
                public int compare(Customer c1, Customer c2) {
                    return c1.getCustomerId().compareTo(c2.getCustomerId());
                }
            };
            customers.sort(customerComparator);
        }
    }

    public void sortCars(String prioritySorting){
        if(prioritySorting.equals("Year")){
            Comparator<Car> carComparator = new Comparator<Car>() {
                @Override
                public int compare(Car c1, Car c2) {
                    return Integer.compare(c1.getYear(),c2.getYear());
                }
            };
            cars.sort(carComparator);
        }else if(prioritySorting.equals("type")){
            Comparator<Car> carComparator = new Comparator<Car>() {
                @Override
                public int compare(Car c1, Car c2) {
                    return c1.getType().compareTo(c2.getType());
                }
            };
            cars.sort(carComparator);
        }
    }

    private String pwdGenerator(){
        char[] s = new char[8];
        for(int i = 0; i < 8; i++){
            Random r = new Random();
            char randomChar = (char)(97 + r.nextInt(26));
            s[i] = randomChar;
        }
        return new String(s);
    }

    public String getAccessPwd(String pwd) {
        if(this.pwd.equals(pwd)) {
            return accessPwd;
        } else {
            return "";
        }
    }
}

