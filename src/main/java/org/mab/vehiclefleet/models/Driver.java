package org.mab.vehiclefleet.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="driver")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Driver {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    @Column(name="salary")
    private int salary;

    @ManyToOne
    @JoinColumn(name="enterprise_id", referencedColumnName = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private Enterprise enterprise;

    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
    @JsonIdentityReference(alwaysAsId = true)
    private List<Vehicle> vehicles;

    @OneToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Vehicle activeVehicle;

    public Vehicle getActiveVehicle() {
        return activeVehicle;
    }

    public void setActiveVehicle(Vehicle activeVehicle) {
        this.activeVehicle = activeVehicle;
    }

    public Driver(String name, int salary, Enterprise enterprise, List<Vehicle> vehicles, Vehicle activeVehicle) {
        this.name = name;
        this.salary = salary;
        this.enterprise = enterprise;
        this.vehicles = vehicles;
        this.activeVehicle = activeVehicle;
    }

    public Driver() {
    }

    public Driver(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Driver(String name, int salary, Enterprise enterprise) {
        this.name = name;
        this.salary = salary;
        this.enterprise = enterprise;
    }

    public Driver(String name, int salary, Enterprise enterprise, List<Vehicle> vehicles) {
        this.name = name;
        this.salary = salary;
        this.enterprise = enterprise;
        this.vehicles = vehicles;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
//                ", enterprise=" + enterprise +
                '}';
    }
}
