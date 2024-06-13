package org.mab.vehiclefleet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Vehicle")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
    @JsonIdentityReference(alwaysAsId = true)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="enterprise_id", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Enterprise enterprise;

    @ManyToOne
    @JoinColumn(name="driver_id", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Driver driver;


    public Vehicle() {
    }

    public Vehicle(int price, int yearOfManufacture, int mileage, String color) {
        this.price = price;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.color = color;
    }

    public Vehicle(int price, int yearOfManufacture, int mileage, String color, Brand brand, Enterprise enterprise) {
        this.price = price;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.color = color;
        this.brand = brand;
        this.enterprise = enterprise;
    }

    public Vehicle(int price, int yearOfManufacture, int mileage, String color, Brand brand, Enterprise enterprise, Driver driver) {
        this.price = price;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.color = color;
        this.brand = brand;
        this.enterprise = enterprise;
        this.driver = driver;
    }

    public void setId(int id) {
        this.id = id;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
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
