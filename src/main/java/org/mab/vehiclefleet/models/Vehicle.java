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

    @ManyToOne
    @JoinColumn(name="brand_id", referencedColumnName = "id")
    private Brand brand;

    public Vehicle() {
    }

    public Vehicle(int price, int yearOfManufacture, int mileage, String color, Brand brand) {
        this.price = price;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.color = color;
        this.brand = brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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
