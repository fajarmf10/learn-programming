package com.fajarmf.systemdesign.parkinglot;

public class ParkingLot {
    private final int capacity;
    private int available;
    private final ParkingSpot[] parkingSpots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.available = capacity;
        this.parkingSpots = new ParkingSpot[capacity];
        for (int i = 0; i < capacity; i++) {
            parkingSpots[i] = new ParkingSpot(i);
        }
    }

    public void park(Car car) {
        if (available == 0) {
            System.out.println("Parking lot is full! Car " + car.getLicensePlate() + " cannot be parked!");
            return;
        }
        for (int i = 0; i < capacity; i++) {
            if (parkingSpots[i].getCar() == null) {
                parkingSpots[i].setCar(car);
                available--;
                System.out.println("Car " + car.getLicensePlate() + " parked at spot " + parkingSpots[i].getId());
                return;
            }
        }
    }

    public boolean leave(ParkingSpot parkingSpot) {
        if (parkingSpot.getCar() == null) {
            System.out.println("Parking spot is empty!");
            return false;
        }
        parkingSpot.setCar(null);
        available++;
        System.out.println("Car left spot " + parkingSpot.getId());
        return true;
    }

    public int getAvailable() {
        return available;
    }

    public int getCapacity() {
        return capacity;
    }
}
