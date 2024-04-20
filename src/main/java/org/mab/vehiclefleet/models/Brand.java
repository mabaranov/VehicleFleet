package org.mab.vehiclefleet.models;

import jakarta.persistence.*;

@Entity
@Table(name="Brand")
public class Brand {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="tank_in_liters")
    private int tankInLiters;
    @Column(name="lifting_capacity_in_tons")
    private int liftingCapacityInTons;
    @Column(name="number_of_seats")
    private int numberOfSeats;

    public Brand() {
    }

    public Brand(String name, String type, int tankInLiters, int liftingCapacityInTons, int numberOfSeats) {
        this.name = name;
        this.type = type;
        this.tankInLiters = tankInLiters;
        this.liftingCapacityInTons = liftingCapacityInTons;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTankInLiters() {
        return tankInLiters;
    }

    public void setTankInLiters(int tankInLiters) {
        this.tankInLiters = tankInLiters;
    }

    public int getLiftingCapacityInTons() {
        return liftingCapacityInTons;
    }

    public void setLiftingCapacityInTons(int liftingCapacityInTons) {
        this.liftingCapacityInTons = liftingCapacityInTons;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", tankInLiters=" + tankInLiters +
                ", liftingCapacityInTons=" + liftingCapacityInTons +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}