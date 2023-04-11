package com.fajarmf.systemdesign.parkinglot;

public class ParkingSpot {
    private final int id;
    private Car car;

    public ParkingSpot(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
