package org.mab.vehiclefleet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Enterprise")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Enterprise {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="city")
    private String city;

    @OneToMany(mappedBy = "enterprise", fetch = FetchType.EAGER)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "enterprise", fetch = FetchType.EAGER)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Driver> drivers;

    public Enterprise() {
    }

    public Enterprise(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Enterprise(String name, String city, List<Vehicle> vehicles, List<Driver> drivers) {
        this.name = name;
        this.city = city;
        this.vehicles = vehicles;
        this.drivers = drivers;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
//                ", vehicles=" + vehicles +
//                ", drivers=" + drivers +
                '}';
    }
}
