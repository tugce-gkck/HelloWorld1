package htwberlin.guenstigertanken;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Tanken {
    private long id;
    private Timestamp date;
    private String name, city;
    private double distance;
    private double price;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Tanken(long id,String date,String name,String city,double distance,double price){
        this.id = id;
        this.date = Timestamp.valueOf(date);
        this.name = name;
        this.city = city;
        this.distance = distance;
        this.price = price;
    }
    public Tanken(String date,String name,String city,double distance,double price){
        this(0,date,name,city,distance,price);
    }

    @Override
    public String toString() {
        return "Tanken[id=" + id +
                     ",name=" + name +
                     ",city=" + city +
                     ",distance=" + distance +
                     ",price=" + price +
                     "]" ;
    }

    // getters & setters omitted for brevity

    public long getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getDistance() {
        return distance;
    }

    public double getPrice() {
        return price;
    }
}
