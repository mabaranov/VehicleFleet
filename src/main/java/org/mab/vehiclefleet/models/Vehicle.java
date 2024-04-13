package org.mab.vehiclefleet.models;

import jakarta.persistence.*;

@Entity
@Table(name="Vehicle")
public class Vehicle {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="price")
    private int price;
    @Column(name="year_of_manufacture")
    private int yearOfManufacture;
    @Column(name="mileage")
    private int mileage;
    @Column(name="color")
    private String color;

    public Vehicle() {
    }

    public Vehicle(int price, int year_of_manufacture, int mileage, String color) {
        this.price = price;
        this.yearOfManufacture = year_of_manufacture;
        this.mileage = mileage;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", price=" + price +
                ", year_of_manufacture=" + yearOfManufacture +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                '}';
    }
}
